package com.pet.service.deviceOperate.deviceOperateService;

import com.pet.dto.deviceDto.OperateDto;
import com.pet.result.Result;

public interface DeviceThermostatService {

    Result<String> operateTargetTemperature(OperateDto operateDto);

    Result<String> operateMode(OperateDto operateDto);

    Result<String> operateWindSpeed(OperateDto operateDto);

    Result<String> operateSweep(OperateDto operateDto);
}