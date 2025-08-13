package com.pet.service.deviceOperate.deviceOperateService;

import com.pet.dto.deviceDto.OperateDto;
import com.pet.result.Result;

public interface DeviceAirPurifierService {

    Result<String> operateWindSpeed(OperateDto operateDto);

    Result<String> operateAnion(OperateDto operateDto);

    Result<String> operateMode(OperateDto operateDto);

    Result<String> operateFilter(OperateDto operateDto);
}
