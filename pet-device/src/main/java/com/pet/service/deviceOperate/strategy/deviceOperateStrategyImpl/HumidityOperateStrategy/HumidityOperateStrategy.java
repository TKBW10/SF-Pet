package com.pet.service.deviceOperate.strategy.deviceOperateStrategyImpl.HumidityOperateStrategy;

import com.pet.constant.DeviceTypeConstants;
import com.pet.constant.OperateConstants;
import com.pet.dto.deviceDto.OperateDto;
import com.pet.result.Result;
import com.pet.service.deviceOperate.deviceOperateService.DeviceHumidityService;
import com.pet.service.deviceOperate.strategy.DeviceOperateStrategy;
import org.springframework.stereotype.Component;

@Component
public class HumidityOperateStrategy implements DeviceOperateStrategy {

    private final DeviceHumidityService deviceHumidityService;

    public HumidityOperateStrategy(DeviceHumidityService deviceHumidityService) {
        this.deviceHumidityService = deviceHumidityService;
    }

    @Override
    public boolean support(String deviceType, String operation) {
        return DeviceTypeConstants.HUMIDITY.equals(deviceType)
                && OperateConstants.HUMIDITY.equals(operation);
    }

    @Override
    public Result<String> execute(OperateDto operateDto) {
        return deviceHumidityService.operateHumidity(operateDto);
    }
}