package com.pet.service.deviceOperate.strategy.deviceOperateStrategyImpl.FeederOperateStrategy;

import com.pet.constant.DeviceTypeConstants;
import com.pet.constant.OperateConstants;
import com.pet.dto.deviceDto.OperateDto;
import com.pet.result.Result;
import com.pet.service.deviceOperate.deviceOperateService.DeviceFeederService;
import com.pet.service.deviceOperate.strategy.DeviceOperateStrategy;
import org.springframework.stereotype.Component;

@Component
public class FeederFeedOperateStrategy implements DeviceOperateStrategy {

    private final DeviceFeederService deviceFeederService;

    public FeederFeedOperateStrategy(DeviceFeederService deviceFeederService) {
        this.deviceFeederService = deviceFeederService;
    }

    @Override
    public boolean support(String deviceType, String operation) {
        return DeviceTypeConstants.FEEDER.equals(deviceType)
                && OperateConstants.FEED.equals(operation);
    }

    @Override
    public Result<String> execute(OperateDto operateDto) {
        return deviceFeederService.operateFeed(operateDto);
    }
}