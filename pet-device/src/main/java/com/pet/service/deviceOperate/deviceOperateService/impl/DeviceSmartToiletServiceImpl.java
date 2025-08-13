package com.pet.service.deviceOperate.deviceOperateService.impl;

import com.pet.constant.ErrorConstants;
import com.pet.service.deviceOperate.deviceOperateService.DeviceSmartToiletService;
import com.pet.dto.deviceDto.OperateDto;
import com.pet.mapper.deviceMapper.DeviceSmartToiletMapper;
import com.pet.result.Result;
import org.springframework.stereotype.Service;

@Service
public class DeviceSmartToiletServiceImpl implements DeviceSmartToiletService {

    private final DeviceSmartToiletMapper deviceSmartToiletMapper;

    public DeviceSmartToiletServiceImpl(DeviceSmartToiletMapper deviceSmartToiletMapper) {
        this.deviceSmartToiletMapper = deviceSmartToiletMapper;
    }

    @Override
    public Result<String> operateClean(OperateDto operateDto) {
        Boolean success = deviceSmartToiletMapper.updateCleanStatus(operateDto.getRoomId(), operateDto.getDeviceId(), "清理中");
        if (success) {
            return Result.success();
        } else {
            return Result.error(ErrorConstants.OPERATION_FAILED);
        }
    }

    @Override
    public Result<String> operateStopClean(OperateDto operateDto) {
        Boolean success = deviceSmartToiletMapper.updateCleanStatus(operateDto.getRoomId(), operateDto.getDeviceId(), "清理完成");
        if (success) {
            return Result.success();
        } else {
            return Result.error(ErrorConstants.OPERATION_FAILED);
        }
    }

    @Override
    public Result<String> operateAutoClear(OperateDto operateDto) {
        Boolean success = deviceSmartToiletMapper.updateAutoClear(operateDto.getRoomId(), operateDto.getDeviceId(), operateDto.getValue());
        if (success) {
            return Result.success();
        } else {
            return Result.error(ErrorConstants.OPERATION_FAILED);
        }
    }

    @Override
    public Result<String> operateDeodorization(OperateDto operateDto) {
        Boolean success = deviceSmartToiletMapper.updateDeodorization(operateDto.getRoomId(), operateDto.getDeviceId(), operateDto.getValue());
        if (success) {
            return Result.success();
        } else {
            return Result.error(ErrorConstants.OPERATION_FAILED);
        }
    }

    @Override
    public Result<String> operateCatLitter(OperateDto operateDto) {
        Boolean success = deviceSmartToiletMapper.updateCatLitter(operateDto.getRoomId(), operateDto.getDeviceId(), operateDto.getValue());
        if (success) {
            return Result.success();
        } else {
            return Result.error(ErrorConstants.OPERATION_FAILED);
        }
    }
}
