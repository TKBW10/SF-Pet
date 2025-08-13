package com.pet.mapper.deviceMapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BaseDeviceOperateMapper {

    @Update("UPDATE ${tableName} SET online = #{online} WHERE room_id = #{roomId} AND device_id = #{deviceId}")
    Boolean updateOnline(String tableName, String roomId, String deviceId, boolean online);
}
