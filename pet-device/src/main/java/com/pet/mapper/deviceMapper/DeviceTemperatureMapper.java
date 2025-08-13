package com.pet.mapper.deviceMapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.pet.constant.DataSourceConstants;
import com.pet.vo.deviceVo.deviceInfoVo.DeviceTemperatureVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
@DS(DataSourceConstants.DEVICE)
public interface DeviceTemperatureMapper {
    @Update("update temperature_data set temperature = #{value}, update_time = now() where room_id = #{roomId} and device_id = #{deviceId}")
    Boolean updateTemperature(String roomId, String deviceId, Double value);

    @Select("select temperature from temperature_data where room_id = #{roomId}")
    String selectTemperature(String roomId);

    @Select("select device_id, device_name, device_type, temperature, online from temperature_data where room_id = #{roomId}")
    List<DeviceTemperatureVo> selectInfo(String roomId);

    @Select("select device_id, device_name, device_type, temperature, online from temperature_data where room_id = #{roomId} and device_id = #{deviceId}")
    DeviceTemperatureVo selectInfoPro(String roomId, String deviceId);
}
