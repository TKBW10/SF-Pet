package com.pet.service.impl;

import com.github.promeg.pinyinhelper.Pinyin;
import com.pet.context.BaseContext;
import com.pet.dto.deviceDto.DeleteDeviceDto;
import com.pet.dto.deviceDto.DeviceInfoDto;
import com.pet.dto.deviceDto.HomeDeviceDto;
import com.pet.dto.deviceDto.UpdateDeviceDto;
import com.pet.entity.device.HomeDevice;
import com.pet.mapper.HomeDeviceMapper;
import com.pet.mapping.DeviceTypeToDeviceDataTableMapping;
import com.pet.service.deviceInfo.strategy.DeviceInfoProStrategy;
import com.pet.vo.deviceVo.DeviceInfoListVo;
import com.pet.result.Result;
import com.pet.service.HomeDeviceService;
import com.pet.service.deviceInfo.strategy.DeviceInfoStrategy;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HomeDeviceServiceImpl implements HomeDeviceService {

    private final HomeDeviceMapper homeDeviceMapper;
    private final Map<String, DeviceInfoStrategy> deviceInfoStrategieMap;
    private final Map<String, DeviceInfoProStrategy> deviceInfoProStrategieMap;

    public HomeDeviceServiceImpl(HomeDeviceMapper homeDeviceMapper, List<DeviceInfoStrategy> deviceInfoStrategies, List<DeviceInfoProStrategy> deviceInfoProStrategies) {
        this.homeDeviceMapper = homeDeviceMapper;
        deviceInfoStrategieMap = deviceInfoStrategies.stream()
                .collect(Collectors.toMap(DeviceInfoStrategy::getType, s -> s));
        deviceInfoProStrategieMap = deviceInfoProStrategies.stream()
                .collect(Collectors.toMap(DeviceInfoProStrategy::getType, s -> s));
    }

    @Override
    @Transactional
    public Result<String> addDevice(HomeDeviceDto homeDeviceDto) {
        HomeDevice homeDevice = new HomeDevice();
        homeDevice.setUserId(BaseContext.getCurrentId());
        BeanUtils.copyProperties(homeDeviceDto, homeDevice);
        homeDevice.setDeviceId(Pinyin.toPinyin(homeDeviceDto.getDeviceType(), "") + "_" + Instant.now().toEpochMilli());
        Boolean success1 = homeDeviceMapper.insert1(homeDevice);

        String tableName = DeviceTypeToDeviceDataTableMapping.getTableNameByDeviceType(homeDeviceDto.getDeviceType());
        Boolean success2 = homeDeviceMapper.insert2(tableName, homeDevice.getUserId(), homeDevice.getRoomId(), homeDevice.getDeviceId(), homeDevice.getDeviceName(), homeDevice.getDeviceType());

        if (success1 && success2) {
            return Result.success();
        }
        return Result.error("添加失败");
    }

    @Override
    public Result<Set<String>> getAllDeviceType() {
        Set<String> deviceTypeSet = homeDeviceMapper.getAllDeviceType();
        return Result.success(deviceTypeSet);
    }

    @Override
    public Result<DeviceInfoListVo> getDeviceInfoList(String roomId) {
        DeviceInfoListVo deviceInfoListVo = new DeviceInfoListVo();
        Set<String> deviceTypeSet = homeDeviceMapper.getDeviceTypeByRoomId(roomId);
        deviceTypeSet.forEach(deviceType -> {
            DeviceInfoStrategy deviceInfoStrategy = deviceInfoStrategieMap.get(deviceType);
            deviceInfoStrategy.fill(roomId, deviceInfoListVo);
        });
        return Result.success(deviceInfoListVo);
    }

    @Override
    public List<?> getDeviceInfo(DeviceInfoDto deviceInfoDto) {
        DeviceInfoProStrategy deviceInfoProStrategy = deviceInfoProStrategieMap.get(deviceInfoDto.getDeviceType());
        return deviceInfoProStrategy.getDeviceInfo(deviceInfoDto.getRoomId(), deviceInfoDto.getDeviceId());
    }

    @Override
    public Result<String> updateDeviceName(UpdateDeviceDto updateDeviceDto) {
        String tableName = DeviceTypeToDeviceDataTableMapping.getTableNameByDeviceType(updateDeviceDto.getDeviceType());
        String roomId = updateDeviceDto.getRoomId();
        String deviceId = updateDeviceDto.getDeviceId();
        String deviceName = updateDeviceDto.getDeviceName();
        Boolean success1 = homeDeviceMapper.updateDeviceFromHomeDevice(roomId, deviceId, deviceName);
        Boolean success2 = homeDeviceMapper.updateDeviceFromDeviceDataTable(tableName, roomId, deviceId, deviceName);
        if (success1 && success2) {
            return Result.success();
        }
        return Result.error("更新失败");
    }

    @Override
    public Result<String> updateDeviceRoom(UpdateDeviceDto updateDeviceDto) {
        String tableName = DeviceTypeToDeviceDataTableMapping.getTableNameByDeviceType(updateDeviceDto.getDeviceType());
        String roomId = updateDeviceDto.getRoomId();
        String deviceId = updateDeviceDto.getDeviceId();
        String newRoomId = updateDeviceDto.getNewRoomId();
        Boolean success1 = homeDeviceMapper.updateDeviceRoomFromHomeDevice(roomId, deviceId, newRoomId);
        Boolean success2 = homeDeviceMapper.updateDeviceRoomFromDeviceDataTable(tableName, roomId, deviceId, newRoomId);
        if (success1 && success2) {
            return Result.success();
        }
        return Result.error("更新失败");
    }

    @Override
    @Transactional
    public Result<String> deleteDevice(DeleteDeviceDto deleteDeviceDto) {
        String tableName = DeviceTypeToDeviceDataTableMapping.getTableNameByDeviceType(deleteDeviceDto.getDeviceType());
        String roomId = deleteDeviceDto.getRoomId();
        String deviceId = deleteDeviceDto.getDeviceId();
        Boolean success1 = homeDeviceMapper.deleteDeviceFromHomeDevice(roomId, deviceId);
        Boolean success2 = homeDeviceMapper.deleteDeviceFromDeviceDataTable(tableName, roomId, deviceId);
        if (success1 && success2) {
            return Result.success();
        }
        return Result.error("删除失败");
    }
}