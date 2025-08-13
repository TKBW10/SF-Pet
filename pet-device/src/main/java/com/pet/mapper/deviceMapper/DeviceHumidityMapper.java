package com.pet.mapper.deviceMapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.pet.constant.DataSourceConstants;
import com.pet.vo.deviceVo.deviceInfoVo.DeviceHumidityVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
@DS(DataSourceConstants.DEVICE)
public interface DeviceHumidityMapper {

    @Update("update humidity_data set humidity = #{humidity}, update_time = now() where room_id = #{roomId} and device_id = #{deviceId}")
    Boolean updateHumidity(String roomId, String deviceId, Double humidity);

    @Select("select humidity from humidity_data where room_id = #{roomId}")
    String selectHumidity(String roomId);

    @Select("select device_id, device_name, device_type, humidity, online from humidity_data where room_id = #{roomId}")
    List<DeviceHumidityVo> selectInfo(String roomId);

    @Select("select device_id, device_name, device_type, humidity, online from humidity_data where room_id = #{roomId} and device_id = #{deviceId}")
    DeviceHumidityVo selectInfoPro(String roomId, String deviceId);
}