package com.pet.mapper.deviceMapper;

import com.pet.vo.deviceVo.deviceInfoVo.DeviceWaterDispenserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface DeviceWaterDispenserMapper {
    @Update("update water_dispenser_data set water_level = #{waterLevel}, update_time = now() where room_id = #{roomId} and device_id = #{deviceId}")
    Boolean updateWaterLevel(String roomId, String deviceId, Double waterLevel);

    @Update("update water_dispenser_data set flow = #{flow}, update_time = now() where room_id = #{roomId} and device_id = #{deviceId}")
    Boolean updateFlow(String roomId, String deviceId, Integer flow);

    @Update("update water_dispenser_data set filter = #{filter}, update_time = now() where room_id = #{roomId} and device_id = #{deviceId}")
    Boolean updateFilter(String roomId, String deviceId, Double filter);

    @Update("update water_dispenser_data set temperature = #{temperature}, update_time = now() where room_id = #{roomId} and device_id = #{deviceId}")
    Boolean updateTemperature(String roomId, String deviceId, Double temperature);

    @Select("select device_id, device_name, device_type, water_level, temperature, flow, filter, last_refill_time, online from water_dispenser_data where room_id = #{roomId}")
    List<DeviceWaterDispenserVo> selectInfo(String roomId);

    @Select("select device_id, device_name, device_type, water_level, temperature, flow, filter, last_refill_time, online from water_dispenser_data where room_id = #{roomId} and device_id = #{deviceId}")
    DeviceWaterDispenserVo selectInfoPro(String roomId, String deviceId);
}
