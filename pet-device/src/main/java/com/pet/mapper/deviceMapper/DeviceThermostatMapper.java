package com.pet.mapper.deviceMapper;

import com.pet.vo.deviceVo.deviceInfoVo.DeviceThermostatVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface DeviceThermostatMapper {

    @Update("update thermostat_data set target_temperature = #{value}, update_time = now() where room_id = #{roomId} and device_id = #{deviceId}")
    Boolean updateTargetTemperature(String roomId, String deviceId, double value);

    @Update("update thermostat_data set mode = #{value}, update_time = now() where room_id = #{roomId} and device_id = #{deviceId}")
    Boolean updateType(String roomId, String deviceId, String value);

    @Update("update thermostat_data set speed = #{value}, update_time = now() where room_id = #{roomId} and device_id = #{deviceId}")
    Boolean updateSpeed(String roomId, String deviceId, int value);

    @Update("update thermostat_data set sweep = #{value}, update_time = now() where room_id = #{roomId} and device_id = #{deviceId}")
    Boolean updateSweep(String roomId, String deviceId, Boolean value);

    @Select("select device_id, device_name, device_type, current_temperature, mode, speed, sweep, online from thermostat_data where room_id = #{roomId}")
    List<DeviceThermostatVo> selectInfo(String roomId);

    @Select("select device_id, device_name, device_type, current_temperature, target_temperature, mode, speed, sweep, online from thermostat_data where room_id = #{roomId} and device_id = #{deviceId}")
    DeviceThermostatVo selectInfoPro(String roomId, String deviceId);
}
