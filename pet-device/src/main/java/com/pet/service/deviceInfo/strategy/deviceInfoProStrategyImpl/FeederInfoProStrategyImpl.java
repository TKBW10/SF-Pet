package com.pet.service.deviceInfo.strategy.deviceInfoProStrategyImpl;

import com.pet.constant.DeviceTypeConstants;
import com.pet.mapper.deviceMapper.DeviceFeederMapper;
import com.pet.service.deviceInfo.strategy.DeviceInfoProStrategy;
import com.pet.vo.deviceVo.deviceInfoVo.DeviceFeederVo;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class FeederInfoProStrategyImpl implements DeviceInfoProStrategy {

    private final DeviceFeederMapper deviceFeederMapper;

    public FeederInfoProStrategyImpl(DeviceFeederMapper deviceFeederMapper) {
        this.deviceFeederMapper = deviceFeederMapper;
    }

    @Override
    public String getType() {
        return DeviceTypeConstants.FEEDER;
    }

    @Override
    public List<DeviceFeederVo> getDeviceInfo(String roomId, String deviceId) {
        return Collections.singletonList(deviceFeederMapper.selectInfoPro(roomId, deviceId));
    }
}
