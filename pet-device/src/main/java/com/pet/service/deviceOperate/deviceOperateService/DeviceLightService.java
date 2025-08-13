package com.pet.service.deviceOperate.deviceOperateService;

import com.pet.dto.deviceDto.OperateDto;
import com.pet.result.Result;

public interface DeviceLightService {

    Result<String> operateBrightness(OperateDto operateDto);

    Result<String> operateColorTemperature(OperateDto operateDto);

    Result<String> operateColor(OperateDto operateDto);

}