package com.pet.service.deviceOperate.strategy.deviceOperateStrategyImpl.airPurifierOperateStrategy;

import com.pet.constant.DeviceTypeConstants;
import com.pet.constant.OperateConstants;
import com.pet.dto.deviceDto.OperateDto;
import com.pet.result.Result;
import com.pet.service.deviceOperate.deviceOperateService.DeviceAirPurifierService;
import com.pet.service.deviceOperate.strategy.DeviceOperateStrategy;
import org.springframework.stereotype.Component;

@Component
public class AirPurifierAnionOperateStrategy implements DeviceOperateStrategy {

    private final DeviceAirPurifierService deviceAirPurifierService;

    public AirPurifierAnionOperateStrategy(DeviceAirPurifierService deviceAirPurifierService) {
        this.deviceAirPurifierService = deviceAirPurifierService;
    }

    @Override
    public boolean support(String deviceType, String operation) {
        return DeviceTypeConstants.AIR_PURIFIER.equals(deviceType)
                && OperateConstants.ANION.equals(operation);
    }

    @Override
    public Result<String> execute(OperateDto operateDto) {
        return deviceAirPurifierService.operateAnion(operateDto);
    }
}