package com.pet.service.deviceOperate.deviceOperateService.impl;

import com.pet.constant.ErrorConstants;
import com.pet.service.deviceOperate.deviceOperateService.DeviceTemperatureService;
import com.pet.dto.deviceDto.OperateDto;
import com.pet.mapper.deviceMapper.DeviceTemperatureMapper;
import com.pet.result.Result;
import org.springframework.stereotype.Service;

@Service
public class DeviceTemperatureServiceImpl implements DeviceTemperatureService {

    private final DeviceTemperatureMapper deviceTemperatureMapper;

    public DeviceTemperatureServiceImpl(DeviceTemperatureMapper deviceTemperatureMapper) {
        this.deviceTemperatureMapper = deviceTemperatureMapper;
    }

    @Override
    public Result<String> operateTemperature(OperateDto operateDto) {
        Boolean success = deviceTemperatureMapper.updateTemperature(operateDto.getRoomId(), operateDto.getDeviceId(), Double.parseDouble(operateDto.getValue()));
        if (success) {
            return Result.success();
        } else {
            return Result.error(ErrorConstants.OPERATION_FAILED);
        }
    }
}