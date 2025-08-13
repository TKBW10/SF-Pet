package com.pet.service.deviceOperate.deviceOperateService;

import com.pet.dto.deviceDto.OperateDto;
import com.pet.result.Result;

public interface DeviceWaterDispenserService {

    Result<String> operateWaterLevel(OperateDto operateDto);

    Result<String> operateTemperature(OperateDto operateDto);

    Result<String> operateFlow(OperateDto operateDto);

    Result<String> operateFilter(OperateDto operateDto);

}