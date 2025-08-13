package com.pet.service.deviceOperate.deviceOperateService.impl;

import com.pet.service.deviceOperate.deviceOperateService.DeviceFeederService;
import com.pet.dto.deviceDto.OperateDto;
import com.pet.mapper.deviceMapper.DeviceFeederMapper;
import com.pet.result.Result;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DeviceFeederServiceImpl implements DeviceFeederService {

    private final DeviceFeederMapper deviceFeederMapper;

    public DeviceFeederServiceImpl(DeviceFeederMapper deviceFeederMapper) {
        this.deviceFeederMapper = deviceFeederMapper;
    }

    @Override
    public Result<String> operateFeed(OperateDto operateDto) {
        Boolean success = deviceFeederMapper.updateLastFeedTime(operateDto.getRoomId(), operateDto.getDeviceId(), LocalDateTime.now());
        if (success) {
            return Result.success();
        } else {
            return Result.error("操作失败");
        }
    }

    @Override
    public Result<String> operateFoodLevel(OperateDto operateDto) {
        Boolean success = deviceFeederMapper.updateFoodLevel(operateDto.getRoomId(), operateDto.getDeviceId(), Double.parseDouble(operateDto.getValue()));
        if (success) {
            return Result.success();
        } else {
            return Result.error("操作失败");
        }
    }
}