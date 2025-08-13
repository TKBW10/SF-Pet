package com.pet.service.deviceOperate.strategy.deviceOperateStrategyImpl.airPurifierOperateStrategy;

import com.pet.constant.DeviceTypeConstants;
import com.pet.constant.OperateConstants;
import com.pet.dto.deviceDto.OperateDto;
import com.pet.result.Result;
import com.pet.service.deviceOperate.deviceOperateService.DeviceAirPurifierService;
import com.pet.service.deviceOperate.strategy.DeviceOperateStrategy;
import org.springframework.stereotype.Component;

@Component
public class AirPurifierModeOperateStrategy implements DeviceOperateStrategy {

    private final DeviceAirPurifierService deviceAirPurifierService;

    public AirPurifierModeOperateStrategy(DeviceAirPurifierService deviceAirPurifierService) {
        this.deviceAirPurifierService = deviceAirPurifierService;
    }

    @Override
    public boolean support(String deviceType, String operation) {
        return DeviceTypeConstants.AIR_PURIFIER.equals(deviceType)
                && OperateConstants.MODE.equals(operation);
    }

    @Override
    public Result<String> execute(OperateDto operateDto) {
        return deviceAirPurifierService.operateMode(operateDto);
    }
}