package com.pet.service.deviceOperate.strategy.deviceOperateStrategyImpl.WeightScaleOperateStrategy;

import com.pet.constant.DeviceTypeConstants;
import com.pet.constant.OperateConstants;
import com.pet.dto.deviceDto.OperateDto;
import com.pet.result.Result;
import com.pet.service.deviceOperate.deviceOperateService.DeviceWeightScaleService;
import com.pet.service.deviceOperate.strategy.DeviceOperateStrategy;
import org.springframework.stereotype.Component;

@Component
public class WeightScaleOperateStrategy implements DeviceOperateStrategy {

    private final DeviceWeightScaleService deviceWeightScaleService;

    public WeightScaleOperateStrategy(DeviceWeightScaleService deviceWeightScaleService) {
        this.deviceWeightScaleService = deviceWeightScaleService;
    }

    @Override
    public boolean support(String deviceType, String operation) {
        return DeviceTypeConstants.WEIGHT_SCALE.equals(deviceType)
                && OperateConstants.WEIGHT.equals(operation);
    }

    @Override
    public Result<String> execute(OperateDto operateDto) {
        return deviceWeightScaleService.operateWeight(operateDto);
    }
}