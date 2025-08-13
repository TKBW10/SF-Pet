package com.pet.service.Impl;

import com.pet.context.BaseContext;
import com.pet.entity.UserHome;
import com.pet.mapper.HomeDeviceMapper;
import com.pet.mapper.PetMapper;
import com.pet.mapper.UserHomeMapper;
import com.pet.mapper.deviceMapper.DeviceHumidityMapper;
import com.pet.mapper.deviceMapper.DeviceTemperatureMapper;
import com.pet.mapping.DeviceTypeToDeviceDataTableMapping;
import com.pet.service.UserHomeService;
import com.pet.vo.UserHomeVo;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;

@Service
public class UserHomeServiceImpl implements UserHomeService {

    private final UserHomeMapper userHomeMapper;
    private final PetMapper petMapper;
    private final HomeDeviceMapper homeDeviceMapper;
    private final DeviceTemperatureMapper deviceTemperatureMapper;
    private final DeviceHumidityMapper deviceHumidityMapper;

    public UserHomeServiceImpl(UserHomeMapper userHomeMapper, PetMapper petMapper, HomeDeviceMapper homeDeviceMapper, DeviceTemperatureMapper deviceTemperatureMapper, DeviceHumidityMapper deviceHumidityMapper) {
        this.userHomeMapper = userHomeMapper;
        this.petMapper = petMapper;
        this.homeDeviceMapper = homeDeviceMapper;
        this.deviceTemperatureMapper = deviceTemperatureMapper;
        this.deviceHumidityMapper = deviceHumidityMapper;
    }

    @Override
    public List<UserHomeVo> selectUserHomeInfo() {
        List<UserHomeVo> userHomeVoList = userHomeMapper.selectUserHomeInfo(BaseContext.getCurrentId());
        userHomeVoList.forEach(userHomeVo -> {
            String roomId = userHomeVo.getRoomId();
            userHomeVo.setPetName(petMapper.selectPetNames(roomId));
            userHomeVo.setDeviceName(homeDeviceMapper.selectDeviceNames(roomId));
            userHomeVo.setTemperature(deviceTemperatureMapper.selectTemperature(roomId));
            userHomeVo.setHumidity(deviceHumidityMapper.selectHumidity(roomId));
        });
        return userHomeVoList;
    }

    @Override
    public Boolean addRoom(String roomName) {
        String roomId = BaseContext.getCurrentId() + "_" + Instant.now().toEpochMilli();
        UserHome userHome = new UserHome();
        userHome.setUserId(BaseContext.getCurrentId());
        userHome.setRoomId(roomId);
        userHome.setRoomName(roomName);

        return userHomeMapper.addRoom(userHome);
    }

    @Override
    public List<Map<String, String>> getRoomIdRoomNameMap() {
        return userHomeMapper.getRoomIdRoomNameMap(BaseContext.getCurrentId());
    }

    @Override
    public Boolean updateRoomName(String roomId, String roomName) {
        return userHomeMapper.updateRoomName(roomId, roomName);
    }

    @Override
    @GlobalTransactional
    public Boolean deleteRoom(String roomId) {
        Set<String> deviceTypeSet = homeDeviceMapper.getDeviceTypeByRoomId(roomId);
        deviceTypeSet.forEach(deviceType -> homeDeviceMapper.deleteRoomIdOfDeviceToDeviceDataTable(DeviceTypeToDeviceDataTableMapping.getTableNameByDeviceType(deviceType), BaseContext.getCurrentId(), roomId));
        homeDeviceMapper.deleteRoomIdOfDevice(BaseContext.getCurrentId(), roomId);
        return userHomeMapper.deleteRoom(BaseContext.getCurrentId(), roomId);
    }
}
