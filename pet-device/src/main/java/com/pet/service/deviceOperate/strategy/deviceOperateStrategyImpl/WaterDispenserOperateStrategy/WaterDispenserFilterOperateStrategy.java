package com.pet.service.deviceOperate.strategy.deviceOperateStrategyImpl.WaterDispenserOperateStrategy;

import com.pet.constant.DeviceTypeConstants;
import com.pet.constant.OperateConstants;
import com.pet.dto.deviceDto.OperateDto;
import com.pet.result.Result;
import com.pet.service.deviceOperate.deviceOperateService.DeviceWaterDispenserService;
import com.pet.service.deviceOperate.strategy.DeviceOperateStrategy;
import org.springframework.stereotype.Component;

@Component
public class WaterDispenserFilterOperateStrategy implements DeviceOperateStrategy {

    private final DeviceWaterDispenserService deviceWaterDispenserService;

    public WaterDispenserFilterOperateStrategy(DeviceWaterDispenserService deviceWaterDispenserService) {
        this.deviceWaterDispenserService = deviceWaterDispenserService;
    }

    @Override
    public boolean support(String deviceType, String operation) {
        return DeviceTypeConstants.WATER_DISPENSER.equals(deviceType)
                && OperateConstants.FILTER.equals(operation);
    }

    @Override
    public Result<String> execute(OperateDto operateDto) {
        return deviceWaterDispenserService.operateFilter(operateDto);
    }
}