package com.pet.service.deviceOperate.deviceOperateService.impl;

import com.pet.constant.ErrorConstants;
import com.pet.service.deviceOperate.deviceOperateService.DeviceAirPurifierService;
import com.pet.dto.deviceDto.OperateDto;
import com.pet.mapper.deviceMapper.DeviceAirPurifierMapper;
import com.pet.result.Result;
import org.springframework.stereotype.Service;

@Service
public class DeviceAirPurifierServiceImpl implements DeviceAirPurifierService {

    private final DeviceAirPurifierMapper deviceAirPurifierMapper;

    public DeviceAirPurifierServiceImpl(DeviceAirPurifierMapper deviceAirPurifierMapper) {
        this.deviceAirPurifierMapper = deviceAirPurifierMapper;
    }

    @Override
    public Result<String> operateWindSpeed(OperateDto operateDto) {
        if (Integer.parseInt(operateDto.getValue()) <1 || Integer.parseInt(operateDto.getValue()) > 11) {
            return null;
        }
        Boolean success = deviceAirPurifierMapper.updateWindSpeed(operateDto.getRoomId(), operateDto.getDeviceId(), operateDto.getValue());
        if (success) {
            return Result.success();
        }
        return Result.error(ErrorConstants.OPERATION_FAILED);
    }

    @Override
    public Result<String> operateAnion(OperateDto operateDto) {
        Boolean success = deviceAirPurifierMapper.updateAnion(operateDto.getRoomId(), operateDto.getDeviceId(), Boolean.parseBoolean(operateDto.getValue()));
        if (success) {
            return Result.success();
        }
        return Result.error(ErrorConstants.OPERATION_FAILED);
    }

    @Override
    public Result<String> operateMode(OperateDto operateDto) {
        Boolean success = deviceAirPurifierMapper.updateMode(operateDto.getRoomId(), operateDto.getDeviceId(), operateDto.getValue());
        if (success) {
            return Result.success();
        }
        return Result.error(ErrorConstants.OPERATION_FAILED);
    }

    @Override
    public Result<String> operateFilter(OperateDto operateDto) {
        Boolean success = deviceAirPurifierMapper.updateScreen(operateDto.getRoomId(), operateDto.getDeviceId(), Double.parseDouble(operateDto.getValue()));
        if (success) {
            return Result.success();
        }
        return Result.error(ErrorConstants.OPERATION_FAILED);
    }
}
