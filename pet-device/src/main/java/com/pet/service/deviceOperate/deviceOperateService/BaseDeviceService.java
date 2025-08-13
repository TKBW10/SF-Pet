package com.pet.service.deviceOperate.deviceOperateService;

import com.pet.dto.deviceDto.OperateDto;
import com.pet.result.Result;

public interface BaseDeviceService {

    Result<String> open(OperateDto operateDto);

    Result<String> close(OperateDto operateDto);

}
