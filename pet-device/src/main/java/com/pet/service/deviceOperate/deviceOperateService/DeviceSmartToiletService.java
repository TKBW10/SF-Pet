package com.pet.service.deviceOperate.deviceOperateService;

import com.pet.dto.deviceDto.OperateDto;
import com.pet.result.Result;

public interface DeviceSmartToiletService {

    Result<String> operateClean(OperateDto operateDto);

    Result<String> operateStopClean(OperateDto operateDto);

    Result<String> operateAutoClear(OperateDto operateDto);

    Result<String> operateDeodorization(OperateDto operateDto);

    Result<String> operateCatLitter(OperateDto operateDto);

}