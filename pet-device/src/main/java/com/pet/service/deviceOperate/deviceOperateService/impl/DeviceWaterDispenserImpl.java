package com.pet.service.deviceOperate.deviceOperateService.impl;

import com.pet.constant.ErrorConstants;
import com.pet.dto.deviceDto.OperateDto;
import com.pet.mapper.deviceMapper.DeviceWaterDispenserMapper;
import com.pet.result.Result;
import org.springframework.stereotype.Service;
import com.pet.service.deviceOperate.deviceOperateService.DeviceWaterDispenserService;

@Service
public class DeviceWaterDispenserImpl implements DeviceWaterDispenserService {

    private final DeviceWaterDispenserMapper deviceWaterDispenserMapper;

    public DeviceWaterDispenserImpl(DeviceWaterDispenserMapper deviceWaterDispenserMapper) {
        this.deviceWaterDispenserMapper = deviceWaterDispenserMapper;
    }

    @Override
    public Result<String> operateWaterLevel(OperateDto operateDto) {
        Boolean success = deviceWaterDispenserMapper.updateWaterLevel(operateDto.getRoomId(), operateDto.getDeviceId(), Double.parseDouble(operateDto.getValue()));
        if (success) {
            return Result.success();
        } else {
            return Result.error(ErrorConstants.OPERATION_FAILED);
        }
    }

    @Override
    public Result<String> operateTemperature(OperateDto operateDto) {
        Boolean success = deviceWaterDispenserMapper.updateTemperature(operateDto.getRoomId(), operateDto.getDeviceId(), Double.parseDouble(operateDto.getValue()));
        if (success) {
            return Result.success();
        } else {
            return Result.error(ErrorConstants.OPERATION_FAILED);
        }
    }

    @Override
    public Result<String> operateFlow(OperateDto operateDto) {
        Boolean success = deviceWaterDispenserMapper.updateFlow(operateDto.getRoomId(), operateDto.getDeviceId(), Integer.parseInt(operateDto.getValue()));
        if (success) {
            return Result.success();
        } else {
            return Result.error(ErrorConstants.OPERATION_FAILED);
        }
    }

    @Override
    public Result<String> operateFilter(OperateDto operateDto) {
        Boolean success = deviceWaterDispenserMapper.updateFilter(operateDto.getRoomId(), operateDto.getDeviceId(), Double.parseDouble(operateDto.getValue()));
        if (success) {
            return Result.success();
        } else {
            return Result.error(ErrorConstants.OPERATION_FAILED);
        }
    }
}