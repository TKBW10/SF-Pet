package com.pet.controller;

import com.pet.result.Result;
import com.pet.service.UserHomeService;
import com.pet.vo.UserHomeVo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pet/home")
public class UserHomeController {

    private final UserHomeService userHomeService;

    public UserHomeController(UserHomeService userHomeService) {
        this.userHomeService = userHomeService;
    }

    @GetMapping
    public Result<List<UserHomeVo>> getHome() {
        List<UserHomeVo> userHomeVoList = userHomeService.selectUserHomeInfo();
        System.out.println(userHomeVoList);
        return Result.success(userHomeVoList);
    }

    @PostMapping("/add")
    public Result<String> addRoom(@RequestParam String roomName){
        Boolean success = userHomeService.addRoom(roomName);
        if (success.equals(Boolean.TRUE)){
            return Result.success();
        }
        return Result.error("创建失败");
    }

    @PostMapping("/getRoomIdRoomName")
    public Result<List<Map<String, String>>> getRoomIdRoomName(){
        List<Map<String, String>> roomIdRoomNameMap = userHomeService.getRoomIdRoomNameMap();
        if (roomIdRoomNameMap != null){
            return Result.success(roomIdRoomNameMap);
        }
        return Result.error("查询失败");
    }

    @PostMapping("/updateRoomName")
    public Result<String> updateRoomName(@RequestParam String roomId, @RequestParam String roomName){
        Boolean success = userHomeService.updateRoomName(roomId, roomName);
        if (success.equals(Boolean.TRUE)){
            return Result.success();
        }
        return Result.error("更新失败");
    }

    @PostMapping("/delete")
    public Result<String> deleteRoom(@RequestParam String roomId){
        Boolean success = userHomeService.deleteRoom(roomId);
        if (success.equals(Boolean.TRUE)){
            return Result.success();
        }
        return Result.error("删除失败");
    }
}
