package com.pet.service.deviceOperate.strategy.deviceOperateStrategyImpl._baseOperateStrategy;

import com.pet.constant.OperateConstants;
import com.pet.dto.deviceDto.OperateDto;
import com.pet.result.Result;
import com.pet.service.deviceOperate.deviceOperateService.BaseDeviceService;
import com.pet.service.deviceOperate.strategy.DeviceOperateStrategy;
import org.springframework.stereotype.Component;

@Component
public class CloseOperateStrategy implements DeviceOperateStrategy {

    private final BaseDeviceService baseDeviceService;

    public CloseOperateStrategy(BaseDeviceService baseDeviceService) {
        this.baseDeviceService = baseDeviceService;
    }

    @Override
    public boolean support(String deviceType, String operation) {
        return OperateConstants.CLOSE.equals(operation);
    }

    @Override
    public Result<String> execute(OperateDto operateDto) {
        return baseDeviceService.close(operateDto);
    }
}
