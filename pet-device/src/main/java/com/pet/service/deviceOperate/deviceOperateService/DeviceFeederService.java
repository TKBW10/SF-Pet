package com.pet.service.deviceOperate.deviceOperateService;

import com.pet.dto.deviceDto.OperateDto;
import com.pet.result.Result;

public interface DeviceFeederService {

    Result<String> operateFeed(OperateDto operateDto);

    Result<String> operateFoodLevel(OperateDto operateDto);

}
