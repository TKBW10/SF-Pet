package com.pet.service.deviceOperate.strategy.deviceOperateStrategyImpl.ThermostatOperateStrategy;

import com.pet.constant.DeviceTypeConstants;
import com.pet.constant.OperateConstants;
import com.pet.dto.deviceDto.OperateDto;
import com.pet.result.Result;
import com.pet.service.deviceOperate.deviceOperateService.DeviceThermostatService;
import com.pet.service.deviceOperate.strategy.DeviceOperateStrategy;
import org.springframework.stereotype.Component;

@Component
public class ThermostatSweepOperateStrategy implements DeviceOperateStrategy {

    private final DeviceThermostatService deviceThermostatService;

    public ThermostatSweepOperateStrategy(DeviceThermostatService deviceThermostatService) {
        this.deviceThermostatService = deviceThermostatService;
    }

    @Override
    public boolean support(String deviceType, String operation) {
        return DeviceTypeConstants.THERMOSTAT.equals(deviceType)
                && OperateConstants.SWEEP.equals(operation);
    }

    @Override
    public Result<String> execute(OperateDto operateDto) {
        return deviceThermostatService.operateSweep(operateDto);
    }
}