package com.pet.mapper.deviceMapper;

import com.pet.vo.deviceVo.deviceInfoVo.DeviceFeederVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface DeviceFeederMapper {
    @Update("update feeder_data set food_level = #{value}, update_time = now() where room_id = #{roomId} and device_id = #{deviceId}")
    Boolean updateFoodLevel(String roomId, String deviceId, double foodLevel);

    @Update("update feeder_data set last_feed_time = #{now}, update_time = now() where room_id = #{roomId} and device_id = #{deviceId}")
    Boolean updateLastFeedTime(String roomId, String deviceId, LocalDateTime now);

    @Select("select device_id, device_name, device_type, food_level, last_feed_time, online from feeder_data where room_id = #{roomId}")
    List<DeviceFeederVo> selectInfo(String roomId);

    @Select("select device_id, device_name, device_type, food_level, auto_feed_time, auto_feed_weight, last_feed_time, online from feeder_data where room_id = #{roomId} and device_id = #{deviceId}")
    DeviceFeederVo selectInfoPro(String roomId, String deviceId);
}
