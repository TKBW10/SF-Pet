package com.pet.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.pet.constant.DataSourceConstants;
import com.pet.dto.deviceDto.*;
import com.pet.vo.deviceVo.DeviceInfoListVo;
import com.pet.service.deviceOperate.dispatcher.DeviceOperateStrategyDispatcher;
import com.pet.result.Result;
import com.pet.service.HomeDeviceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/pet/homeDevice")
@DS(DataSourceConstants.DEVICE)
public class HomeDeviceController {

    private final HomeDeviceService homeDeviceService;
    private final DeviceOperateStrategyDispatcher deviceOperateStrategyDispatcher;

    public HomeDeviceController(HomeDeviceService homeDeviceService, DeviceOperateStrategyDispatcher deviceOperateDispatcher) {
        this.homeDeviceService = homeDeviceService;
        this.deviceOperateStrategyDispatcher = deviceOperateDispatcher;
    }

    @PostMapping("/addDevice")
    public Result<String> addDevice(@RequestBody HomeDeviceDto homeDeviceDto) {
        return homeDeviceService.addDevice(homeDeviceDto);
    }

    @GetMapping("/deviceTypeSet")
    public Result<Set<String>> getAllDeviceType() {
        return homeDeviceService.getAllDeviceType();
    }

    @PostMapping("/operate")
    public Result<String> operate(@RequestBody OperateDto operateDto) {
        return deviceOperateStrategyDispatcher.dispatch(operateDto);
    }

    @PostMapping("/deviceInfoList/{roomId}")
    public Result<DeviceInfoListVo> getDeviceInfoList(@PathVariable String roomId) {
        return homeDeviceService.getDeviceInfoList(roomId);
    }

    @PostMapping("/deviceInfo")
    public Result<List<?>> getDeviceInfo(@RequestBody DeviceInfoDto deviceInfoDto){
        List<?> deviceInfo = homeDeviceService.getDeviceInfo(deviceInfoDto);
        if (deviceInfo != null) {
            return Result.success(deviceInfo);
        }
        return Result.error("获取设备信息失败");
    }

    @PostMapping("/updateDeviceName")
    public Result<String> updateDeviceName(@RequestBody UpdateDeviceDto updateDeviceDto) {
        return homeDeviceService.updateDeviceName(updateDeviceDto);
    }

    @PostMapping("/updateDeviceRoom")
    public Result<String> updateDeviceRoom(@RequestBody UpdateDeviceDto updateDeviceDto) {
        return homeDeviceService.updateDeviceRoom(updateDeviceDto);
    }

    @PostMapping("/deleteDevice")
    public Result<String> deleteDevice(@RequestBody DeleteDeviceDto deleteDeviceDto) {
        return homeDeviceService.deleteDevice(deleteDeviceDto);
    }
}
