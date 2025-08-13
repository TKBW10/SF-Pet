package com.pet.service.deviceOperate.strategy.deviceOperateStrategyImpl.SmartToiletOperateStrategy;

import com.pet.constant.DeviceTypeConstants;
import com.pet.constant.OperateConstants;
import com.pet.dto.deviceDto.OperateDto;
import com.pet.result.Result;
import com.pet.service.deviceOperate.deviceOperateService.DeviceSmartToiletService;
import com.pet.service.deviceOperate.strategy.DeviceOperateStrategy;
import org.springframework.stereotype.Component;

@Component
public class SmartToiletCleanOperateStrategy implements DeviceOperateStrategy {

    private final DeviceSmartToiletService deviceSmartToiletService;

    public SmartToiletCleanOperateStrategy(DeviceSmartToiletService deviceSmartToiletService) {
        this.deviceSmartToiletService = deviceSmartToiletService;
    }

    @Override
    public boolean support(String deviceType, String operation) {
        return DeviceTypeConstants.SMART_TOILET.equals(deviceType)
                && OperateConstants.CLEAN.equals(operation);
    }

    @Override
    public Result<String> execute(OperateDto operateDto) {
        return deviceSmartToiletService.operateClean(operateDto);
    }
}