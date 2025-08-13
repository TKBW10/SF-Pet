package com.pet.service;

import com.pet.vo.UserHomeVo;

import java.util.List;
import java.util.Map;

public interface UserHomeService {
    List<UserHomeVo> selectUserHomeInfo();

    Boolean addRoom(String roomName);

    List<Map<String, String>> getRoomIdRoomNameMap();

    Boolean updateRoomName(String roomId, String roomName);

    Boolean deleteRoom(String roomId);

}
