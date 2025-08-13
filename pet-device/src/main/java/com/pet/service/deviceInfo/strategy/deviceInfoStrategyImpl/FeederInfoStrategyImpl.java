package com.pet.service.deviceInfo.strategy.deviceInfoStrategyImpl;

import com.pet.constant.DeviceTypeConstants;
import com.pet.mapper.deviceMapper.DeviceFeederMapper;
import com.pet.vo.deviceVo.DeviceInfoListVo;
import com.pet.vo.deviceVo.deviceInfoVo.DeviceFeederVo;
import com.pet.service.deviceInfo.strategy.DeviceInfoStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeederInfoStrategyImpl implements DeviceInfoStrategy {

    private final DeviceFeederMapper deviceFeederMapper;

    public FeederInfoStrategyImpl(DeviceFeederMapper deviceFeederMapper) {
        this.deviceFeederMapper = deviceFeederMapper;
    }

    @Override
    public String getType() {
        return DeviceTypeConstants.FEEDER;
    }

    @Override
    public void fill(String roomId, DeviceInfoListVo deviceInfoListVo) {
        List<DeviceFeederVo> deviceFeederVoList = deviceFeederMapper.selectInfo(roomId);
        deviceInfoListVo.setDeviceFeederVoList(deviceFeederVoList);
    }
}
