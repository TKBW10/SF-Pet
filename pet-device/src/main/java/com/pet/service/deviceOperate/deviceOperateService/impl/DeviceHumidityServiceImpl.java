package com.pet.service.deviceOperate.deviceOperateService.impl;

import com.pet.constant.ErrorConstants;
import com.pet.service.deviceOperate.deviceOperateService.DeviceHumidityService;
import com.pet.dto.deviceDto.OperateDto;
import com.pet.mapper.deviceMapper.DeviceHumidityMapper;
import com.pet.result.Result;
import org.springframework.stereotype.Service;

@Service
public class DeviceHumidityServiceImpl implements DeviceHumidityService {

    private final DeviceHumidityMapper deviceHumidityMapper;

    public DeviceHumidityServiceImpl(DeviceHumidityMapper deviceHumidityMapper) {
        this.deviceHumidityMapper = deviceHumidityMapper;
    }

    @Override
    public Result<String> operateHumidity(OperateDto operateDto) {
        Boolean success = deviceHumidityMapper.updateHumidity(operateDto.getRoomId(), operateDto.getDeviceId(), Double.parseDouble(operateDto.getValue()));
        if (success) {
            return Result.success();
        } else {
            return Result.error(ErrorConstants.OPERATION_FAILED);
        }
    }
}
