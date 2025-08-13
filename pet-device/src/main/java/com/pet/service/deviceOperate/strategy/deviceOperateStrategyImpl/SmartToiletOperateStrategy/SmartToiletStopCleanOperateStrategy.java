package com.pet.service.deviceOperate.strategy.deviceOperateStrategyImpl.SmartToiletOperateStrategy;

import com.pet.constant.DeviceTypeConstants;
import com.pet.constant.OperateConstants;
import com.pet.dto.deviceDto.OperateDto;
import com.pet.result.Result;
import com.pet.service.deviceOperate.deviceOperateService.DeviceSmartToiletService;
import com.pet.service.deviceOperate.strategy.DeviceOperateStrategy;
import org.springframework.stereotype.Component;

@Component
public class SmartToiletStopCleanOperateStrategy implements DeviceOperateStrategy {

    private final DeviceSmartToiletService deviceSmartToiletService;

    public SmartToiletStopCleanOperateStrategy(DeviceSmartToiletService deviceSmartToiletService) {
        this.deviceSmartToiletService = deviceSmartToiletService;
    }

    @Override
    public boolean support(String deviceType, String operation) {
        return DeviceTypeConstants.SMART_TOILET.equals(deviceType)
                && OperateConstants.STOP_CLEAN.equals(operation);
    }

    @Override
    public Result<String> execute(OperateDto operateDto) {
        return deviceSmartToiletService.operateStopClean(operateDto);
    }
}