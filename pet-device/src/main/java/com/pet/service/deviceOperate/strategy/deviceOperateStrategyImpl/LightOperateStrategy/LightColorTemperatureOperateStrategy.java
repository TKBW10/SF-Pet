package com.pet.service.deviceOperate.strategy.deviceOperateStrategyImpl.LightOperateStrategy;

import com.pet.constant.DeviceTypeConstants;
import com.pet.constant.OperateConstants;
import com.pet.dto.deviceDto.OperateDto;
import com.pet.result.Result;
import com.pet.service.deviceOperate.deviceOperateService.DeviceLightService;
import com.pet.service.deviceOperate.strategy.DeviceOperateStrategy;
import org.springframework.stereotype.Component;

@Component
public class LightColorTemperatureOperateStrategy implements DeviceOperateStrategy {

    private final DeviceLightService deviceLightService;

    public LightColorTemperatureOperateStrategy(DeviceLightService deviceLightService) {
        this.deviceLightService = deviceLightService;
    }

    @Override
    public boolean support(String deviceType, String operation) {
        return DeviceTypeConstants.LIGHT.equals(deviceType)
                && OperateConstants.COLOR_TEMPERATURE.equals(operation);
    }

    @Override
    public Result<String> execute(OperateDto operateDto) {
        return deviceLightService.operateColorTemperature(operateDto);
    }
}