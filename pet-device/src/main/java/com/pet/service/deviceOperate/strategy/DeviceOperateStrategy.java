package com.pet.service.deviceOperate.strategy;

import com.pet.dto.deviceDto.OperateDto;
import com.pet.result.Result;

public interface DeviceOperateStrategy {
    boolean support(String deviceType, String operation);
    Result<String> execute(OperateDto dto);
}
