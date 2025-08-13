package com.pet.service.deviceOperate.deviceOperateService;

import com.pet.dto.deviceDto.OperateDto;
import com.pet.result.Result;

public interface DeviceHumidityService {

    Result<String> operateHumidity(OperateDto operateDto);
}
