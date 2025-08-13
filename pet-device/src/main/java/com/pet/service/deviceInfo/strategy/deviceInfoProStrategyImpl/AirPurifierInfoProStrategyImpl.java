package com.pet.service.deviceInfo.strategy.deviceInfoProStrategyImpl;

import com.pet.constant.DeviceTypeConstants;
import com.pet.mapper.deviceMapper.DeviceAirPurifierMapper;
import com.pet.service.deviceInfo.strategy.DeviceInfoProStrategy;
import com.pet.vo.deviceVo.deviceInfoVo.DeviceAirPurifierVo;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class AirPurifierInfoProStrategyImpl implements DeviceInfoProStrategy {

    private final DeviceAirPurifierMapper deviceAirPurifierMapper;

    public AirPurifierInfoProStrategyImpl(DeviceAirPurifierMapper deviceAirPurifierMapper) {
        this.deviceAirPurifierMapper = deviceAirPurifierMapper;
    }

    @Override
    public String getType() {
        return DeviceTypeConstants.AIR_PURIFIER;
    }

    @Override
    public List<DeviceAirPurifierVo> getDeviceInfo(String roomId, String deviceId) {
        return Collections.singletonList(deviceAirPurifierMapper.selectInfoPro(roomId, deviceId));
    }
}
