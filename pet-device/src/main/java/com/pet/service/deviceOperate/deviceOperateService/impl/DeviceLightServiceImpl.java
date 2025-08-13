package com.pet.service.deviceOperate.deviceOperateService.impl;

import com.pet.constant.ErrorConstants;
import com.pet.service.deviceOperate.deviceOperateService.DeviceLightService;
import com.pet.dto.deviceDto.OperateDto;
import com.pet.mapper.deviceMapper.DeviceLightMapper;
import com.pet.result.Result;
import org.springframework.stereotype.Service;

@Service
public class DeviceLightServiceImpl implements DeviceLightService {

    private final DeviceLightMapper deviceLightMapper;

    public DeviceLightServiceImpl(DeviceLightMapper deviceLightMapper) {
        this.deviceLightMapper = deviceLightMapper;
    }

    @Override
    public Result<String> operateBrightness(OperateDto operateDto) {
        Boolean success = deviceLightMapper.updateBrightness(operateDto.getRoomId(), operateDto.getDeviceId(), Integer.parseInt(operateDto.getValue()));
        if (success) {
            return Result.success();
        } else {
            return Result.error(ErrorConstants.OPERATION_FAILED);
        }
    }

    @Override
    public Result<String> operateColorTemperature(OperateDto operateDto) {
        Boolean success = deviceLightMapper.updateColorTem(operateDto.getRoomId(), operateDto.getDeviceId(), Integer.parseInt(operateDto.getValue()));
        if (success) {
            return Result.success();
        } else {
            return Result.error(ErrorConstants.OPERATION_FAILED);
        }
    }

    @Override
    public Result<String> operateColor(OperateDto operateDto) {
        Boolean success = deviceLightMapper.updateColor(operateDto.getRoomId(), operateDto.getDeviceId(), operateDto.getValue());
        if (success) {
            return Result.success();
        } else {
            return Result.error(ErrorConstants.OPERATION_FAILED);
        }
    }
}
