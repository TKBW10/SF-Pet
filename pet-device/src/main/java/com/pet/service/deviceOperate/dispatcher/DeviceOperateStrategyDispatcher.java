package com.pet.service.deviceOperate.dispatcher;

import com.pet.dto.deviceDto.OperateDto;
import com.pet.result.Result;
import com.pet.service.deviceOperate.strategy.DeviceOperateStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeviceOperateStrategyDispatcher {

    private final List<DeviceOperateStrategy> strategies;

    public DeviceOperateStrategyDispatcher(List<DeviceOperateStrategy> strategies) {
        this.strategies = strategies;
    }

    public Result<String> dispatch(OperateDto operateDto) {
        for (DeviceOperateStrategy strategy : strategies) {
            if (strategy.support(operateDto.getDeviceType(), operateDto.getOperation())) {
                return strategy.execute(operateDto);
            }
        }
        throw new IllegalArgumentException("不支持的设备类型或操作");
    }
}
