package com.pet.service.deviceOperate.deviceOperateService.impl;

import com.pet.constant.ErrorConstants;
import com.pet.dto.deviceDto.OperateDto;
import com.pet.mapper.deviceMapper.DeviceWeightScaleMapper;
import com.pet.entity.device.deviceInfo.DeviceWeightScale;
import com.pet.result.Result;
import org.springframework.stereotype.Service;
import com.pet.service.deviceOperate.deviceOperateService.DeviceWeightScaleService;

@Service
public class DeviceWeightScaleServiceImpl implements DeviceWeightScaleService {

    private final DeviceWeightScaleMapper deviceWeightScaleMapper;

    public DeviceWeightScaleServiceImpl(DeviceWeightScaleMapper deviceWeightScaleMapper) {
        this.deviceWeightScaleMapper = deviceWeightScaleMapper;
    }

    @Override
    public Result<String> operateWeight(OperateDto operateDto) {
        DeviceWeightScale deviceWeightScale = deviceWeightScaleMapper.getInfo(operateDto.getRoomId(), operateDto.getDeviceId());
        Double lastWeight = deviceWeightScale.getWeight();
        double change;
        if (lastWeight != null) {
            change = Double.parseDouble(operateDto.getValue()) - lastWeight;
        } else {
            change = 0.0;
        }
        deviceWeightScale.setWeight(Double.parseDouble(operateDto.getValue()));
        deviceWeightScale.setChange(change);
        Boolean success = deviceWeightScaleMapper.insertWeight(deviceWeightScale);
        if (success) {
            return Result.success();
        } else {
            return Result.error(ErrorConstants.OPERATION_FAILED);
        }
    }
}