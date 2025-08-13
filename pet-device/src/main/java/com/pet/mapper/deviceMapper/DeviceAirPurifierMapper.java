package com.pet.mapper.deviceMapper;

import com.pet.vo.deviceVo.deviceInfoVo.DeviceAirPurifierVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface DeviceAirPurifierMapper {
    @Update("update air_purifier_data set wind_speed = #{value}, update_time = now() where room_id = #{roomId} and device_id = #{deviceId}")
    Boolean updateWindSpeed(String roomId, String deviceId, String value);

    @Update("update air_purifier_data set anion = #{value}, update_time = now() where room_id = #{roomId} and device_id = #{deviceId}")
    Boolean updateAnion(String roomId, String deviceId, Boolean value);

    @Update("update air_purifier_data set mode = #{value}, update_time = now() where room_id = #{roomId} and device_id = #{deviceId}")
    Boolean updateMode(String roomId, String deviceId, String value);

    @Update("update air_purifier_data set filter = #{value}, update_time = now() where room_id = #{roomId} and device_id = #{deviceId}")
    Boolean updateScreen(String roomId, String deviceId, Double value);

    @Select("select device_id, device_name, device_type, pm25, wind_speed, anion, mode, filter, online from air_purifier_data where room_id = #{roomId}")
    List<DeviceAirPurifierVo> selectInfo(String roomId);

    @Select("select device_id, device_name, device_type, pm25, wind_speed, anion, mode, filter, online from air_purifier_data where room_id = #{roomId} and device_id = #{deviceId}")
    DeviceAirPurifierVo selectInfoPro(String roomId, String deviceId);
}
