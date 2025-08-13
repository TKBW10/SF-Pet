package com.pet.mapper.deviceMapper;

import com.pet.vo.deviceVo.deviceInfoVo.DeviceLightVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface DeviceLightMapper {

    @Update("update light_data set brightness = #{brightness}, update_time = now() where room_id = #{roomId} and device_id = #{deviceId}")
    Boolean updateBrightness(String roomId, String deviceId, int brightness);

    @Update("update light_data set color_tem = #{colorTem}, update_time = now() where room_id = #{roomId} and device_id = #{deviceId}")
    Boolean updateColorTem(String roomId, String deviceId, int colorTem);

    @Update("update light_data set color = #{color}, update_time = now() where room_id = #{roomId} and device_id = #{deviceId}")
    Boolean updateColor(String roomId, String deviceId, String color);

    @Select("select device_id, device_name, device_type, brightness, color_tem, color, online from light_data where room_id = #{roomId}")
    List<DeviceLightVo> selectInfo(String roomId);

    @Select("select device_id, device_name, device_type, brightness, color_tem, color, online from light_data where room_id = #{roomId} and device_id = #{deviceId}")
    DeviceLightVo selectInfoPro(String roomId, String deviceId);
}
