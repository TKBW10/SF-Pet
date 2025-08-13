package com.pet.service.deviceOperate.deviceOperateService.impl;

import com.pet.constant.DeviceTypeConstants;
import com.pet.service.deviceOperate.deviceOperateService.BaseDeviceService;
import com.pet.dto.deviceDto.OperateDto;
import com.pet.mapper.deviceMapper.BaseDeviceOperateMapper;
import com.pet.mapper.HomeDeviceMapper;
import com.pet.mapping.DeviceTypeToDeviceDataTableMapping;
import com.pet.result.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BaseDeviceServiceImpl implements BaseDeviceService {

    private final BaseDeviceOperateMapper baseDeviceOperateMapper;
    private final HomeDeviceMapper homeDeviceMapper;

    protected BaseDeviceServiceImpl(BaseDeviceOperateMapper baseDeviceOperateMapper, HomeDeviceMapper homeDeviceMapper) {
        this.baseDeviceOperateMapper = baseDeviceOperateMapper;
        this.homeDeviceMapper = homeDeviceMapper;
    }

    @Override
    @Transactional
    public Result<String> open(OperateDto operateDto) {
        Boolean success1 = homeDeviceMapper.updateOnline(operateDto.getRoomId(), operateDto.getDeviceId(), true);
        if (operateDto.getDeviceType().equals(DeviceTypeConstants.WEIGHT_SCALE)){
            if (success1.equals(Boolean.TRUE)){
                return Result.success();
            }else return Result.error("操作失败");
        }
        Boolean success2 = baseDeviceOperateMapper.updateOnline(
                DeviceTypeToDeviceDataTableMapping.getTableNameByDeviceType(
                        operateDto.getDeviceType()),
                operateDto.getRoomId(), operateDto.getDeviceId(), true);
        if (success1 && success2) {
            return Result.success();
        }
        throw new RuntimeException("设备更新失败");
    }

    @Transactional
    public Result<String> close(OperateDto operateDto) {
        Boolean success1 = homeDeviceMapper.updateOnline(operateDto.getRoomId(), operateDto.getDeviceId(), false);
        if (operateDto.getDeviceType().equals(DeviceTypeConstants.WEIGHT_SCALE)){
            if (success1.equals(Boolean.TRUE)){
                return Result.success();
            }else return Result.error("操作失败");
        }
        Boolean success2 = baseDeviceOperateMapper.updateOnline(
                DeviceTypeToDeviceDataTableMapping.getTableNameByDeviceType(
                        operateDto.getDeviceType()),
                operateDto.getRoomId(), operateDto.getDeviceId(), false);
        if (success1 && success2) {
            return Result.success();
        }
        throw new RuntimeException("设备更新失败");
    }
}
