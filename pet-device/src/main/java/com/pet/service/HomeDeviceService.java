package com.pet.service;

import com.pet.dto.deviceDto.DeleteDeviceDto;
import com.pet.dto.deviceDto.DeviceInfoDto;
import com.pet.dto.deviceDto.HomeDeviceDto;
import com.pet.dto.deviceDto.UpdateDeviceDto;
import com.pet.vo.deviceVo.DeviceInfoListVo;
import com.pet.result.Result;

import java.util.List;
import java.util.Set;

public interface HomeDeviceService {

    Result<String> addDevice(HomeDeviceDto homeDeviceDto);

    Result<Set<String>> getAllDeviceType();

    Result<DeviceInfoListVo> getDeviceInfoList(String roomId);

    List<?> getDeviceInfo(DeviceInfoDto deviceInfoDto);

    Result<String> updateDeviceName(UpdateDeviceDto updateDeviceDto);

    Result<String> updateDeviceRoom(UpdateDeviceDto updateDeviceDto);

    Result<String> deleteDevice(DeleteDeviceDto deleteDeviceDto);
}
