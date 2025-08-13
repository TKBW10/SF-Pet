package com.pet.service.deviceOperate.deviceOperateService.impl;

import com.pet.constant.ErrorConstants;
import com.pet.dto.deviceDto.OperateDto;
import com.pet.mapper.deviceMapper.DeviceThermostatMapper;
import com.pet.result.Result;
import org.springframework.stereotype.Service;
import com.pet.service.deviceOperate.deviceOperateService.DeviceThermostatService;

@Service
public class DeviceThermostatServiceImpl implements DeviceThermostatService {

    private final DeviceThermostatMapper deviceThermostatMapper;

    public DeviceThermostatServiceImpl(DeviceThermostatMapper deviceThermostatMapper) {
        this.deviceThermostatMapper = deviceThermostatMapper;
    }

    @Override
    public Result<String> operateTargetTemperature(OperateDto operateDto) {
        Boolean success = deviceThermostatMapper.updateTargetTemperature(operateDto.getRoomId(), operateDto.getDeviceId(), Double.parseDouble(operateDto.getValue()));
        if (success) {
            return Result.success();
        } else {
            return Result.error(ErrorConstants.OPERATION_FAILED);
        }
    }

    @Override
    public Result<String> operateMode(OperateDto operateDto) {
        Boolean success = deviceThermostatMapper.updateType(operateDto.getRoomId(), operateDto.getDeviceId(), operateDto.getValue());
        if (success) {
            return Result.success();
        } else {
            return Result.error(ErrorConstants.OPERATION_FAILED);
        }
    }

    @Override
    public Result<String> operateWindSpeed(OperateDto operateDto) {
        Boolean success = deviceThermostatMapper.updateSpeed(operateDto.getRoomId(), operateDto.getDeviceId(), Integer.parseInt(operateDto.getValue()));
        if (success) {
            return Result.success();
        } else {
            return Result.error(ErrorConstants.OPERATION_FAILED);
        }
    }

    @Override
    public Result<String> operateSweep(OperateDto operateDto) {
        Boolean success = deviceThermostatMapper.updateSweep(operateDto.getRoomId(), operateDto.getDeviceId(), Boolean.parseBoolean(operateDto.getValue()));
        if (success) {
            return Result.success();
        } else {
            return Result.error(ErrorConstants.OPERATION_FAILED);
        }
    }
}