package com.pet.vo.deviceVo;

import com.pet.vo.deviceVo.deviceInfoVo.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceInfoListVo {
    private List<DeviceAirPurifierVo> deviceAirPurifierVoList;
    private List<DeviceFeederVo> deviceFeederVoList;
    private List<DeviceHumidityVo> deviceHumidityVoList;
    private List<DeviceLightVo> deviceLightVoList;
    private List<DeviceSmartToiletVo> deviceSmartToiletVoList;
    private List<DeviceTemperatureVo> deviceTemperatureVoList;
    private List<DeviceThermostatVo> deviceThermostatVoList;
    private List<DeviceWaterDispenserVo> deviceWaterDispenserVoList;
    private List<DeviceWeightScaleVo> deviceWeightScaleVoList;
}
