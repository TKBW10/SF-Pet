package com.pet.service.deviceInfo.strategy.deviceInfoStrategyImpl;

import com.pet.constant.DeviceTypeConstants;
import com.pet.mapper.deviceMapper.DeviceAirPurifierMapper;
import com.pet.vo.deviceVo.DeviceInfoListVo;
import com.pet.vo.deviceVo.deviceInfoVo.DeviceAirPurifierVo;
import com.pet.service.deviceInfo.strategy.DeviceInfoStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AirPurifierInfoStrategyImpl implements DeviceInfoStrategy {

    private final DeviceAirPurifierMapper deviceAirPurifierMapper;

    public AirPurifierInfoStrategyImpl(DeviceAirPurifierMapper deviceAirPurifierMapper) {
        this.deviceAirPurifierMapper = deviceAirPurifierMapper;
    }

    @Override
    public String getType() {
        return DeviceTypeConstants.AIR_PURIFIER;
    }

    @Override
    public void fill(String roomId, DeviceInfoListVo deviceInfoListVo) {
        List<DeviceAirPurifierVo> deviceAirPurifierVoList = deviceAirPurifierMapper.selectInfo(roomId);
        deviceInfoListVo.setDeviceAirPurifierVoList(deviceAirPurifierVoList);
    }
}
