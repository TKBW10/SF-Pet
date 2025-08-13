package com.pet.service.deviceOperate.strategy.deviceOperateStrategyImpl.WaterDispenserOperateStrategy;

import com.pet.constant.DeviceTypeConstants;
import com.pet.constant.OperateConstants;
import com.pet.dto.deviceDto.OperateDto;
import com.pet.result.Result;
import com.pet.service.deviceOperate.deviceOperateService.DeviceWaterDispenserService;
import com.pet.service.deviceOperate.strategy.DeviceOperateStrategy;
import org.springframework.stereotype.Component;

@Component
public class WaterDispenserFlowOperateStrategy implements DeviceOperateStrategy {

    private final DeviceWaterDispenserService deviceWaterDispenserService;

    public WaterDispenserFlowOperateStrategy(DeviceWaterDispenserService deviceWaterDispenserService) {
        this.deviceWaterDispenserService = deviceWaterDispenserService;
    }

    @Override
    public boolean support(String deviceType, String operation) {
        return DeviceTypeConstants.WATER_DISPENSER.equals(deviceType)
                && OperateConstants.FLOW.equals(operation);
    }

    @Override
    public Result<String> execute(OperateDto operateDto) {
        return deviceWaterDispenserService.operateFlow(operateDto);
    }
}