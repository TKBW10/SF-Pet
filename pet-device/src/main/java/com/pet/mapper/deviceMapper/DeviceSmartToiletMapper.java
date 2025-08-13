package com.pet.mapper.deviceMapper;

import com.pet.vo.deviceVo.deviceInfoVo.DeviceSmartToiletVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface DeviceSmartToiletMapper {

    @Update("update smart_toilet_data set clean_status = #{cleaning}, last_clean_time = now(), update_time = now() where room_id = #{roomId} and device_id = #{deviceId}")
    Boolean updateCleanStatus(String roomId, String deviceId, String cleaning);

    @Update("update smart_toilet_data set auto_clear = #{value}, update_time = now() where room_id = #{roomId} and device_id = #{deviceId}")
    Boolean updateAutoClear(String roomId, String deviceId, String value);

    @Update("update smart_toilet_data set deodorization = #{value}, update_time = now() where room_id = #{roomId} and device_id = #{deviceId}")
    Boolean updateDeodorization(String roomId, String deviceId, String value);

    @Update("update smart_toilet_data set cat_litter = #{value}, update_time = now() where room_id = #{roomId} and device_id = #{deviceId}")
    Boolean updateCatLitter(String roomId, String deviceId, String value);

    @Update("update smart_toilet_data set last_clean_time = #{value}, update_time = now() where room_id = #{roomId} and device_id = #{deviceId}")
    Boolean updateLastCleanTime(String roomId, String deviceId, LocalDateTime value);

    @Select("select device_id, device_name, device_type, last_clean_time, cat_litter, online from smart_toilet_data where room_id = #{roomId}")
    List<DeviceSmartToiletVo> selectInfo(String roomId);

    @Select("select device_id, device_name, device_type, clean_status, last_clean_time, auto_clear, deodorization, cat_litter, online from smart_toilet_data where room_id = #{roomId} and device_id = #{deviceId}")
    DeviceSmartToiletVo selectInfoPro(String roomId, String deviceId);
}
