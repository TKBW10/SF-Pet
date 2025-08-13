package com.pet.service.deviceOperate.strategy.deviceOperateStrategyImpl.TemperatureOperateStrategy;

import com.pet.constant.DeviceTypeConstants;
import com.pet.constant.OperateConstants;
import com.pet.dto.deviceDto.OperateDto;
import com.pet.result.Result;
import com.pet.service.deviceOperate.deviceOperateService.DeviceTemperatureService;
import com.pet.service.deviceOperate.strategy.DeviceOperateStrategy;
import org.springframework.stereotype.Component;

@Component
public class TemperatureOperateStrategy implements DeviceOperateStrategy {

    private final DeviceTemperatureService deviceTemperatureService;

    public TemperatureOperateStrategy(DeviceTemperatureService deviceTemperatureService) {
        this.deviceTemperatureService = deviceTemperatureService;
    }

    @Override
    public boolean support(String deviceType, String operation) {
        return DeviceTypeConstants.TEMPERATURE.equals(deviceType)
                && OperateConstants.TEMPERATURE.equals(operation);
    }

    @Override
    public Result<String> execute(OperateDto operateDto) {
        return deviceTemperatureService.operateTemperature(operateDto);
    }
}