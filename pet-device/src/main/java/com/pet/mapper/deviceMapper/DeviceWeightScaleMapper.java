package com.pet.mapper.deviceMapper;

import com.pet.entity.device.deviceInfo.DeviceWeightScale;
import com.pet.vo.deviceVo.deviceInfoVo.DeviceWeightScaleVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeviceWeightScaleMapper {

    @Select("select user_id, room_id,device_id, device_name, device_type, weight, `change` from weight_scale_data where room_id = #{roomId} and device_id = #{deviceId} order by create_time desc limit 1")
    DeviceWeightScale getInfo(String roomId, String deviceId);

    @Insert("insert into weight_scale_data (user_id, room_id, device_id, device_name, device_type, weight, `change`, create_time) values (#{userId}, #{roomId}, #{deviceId}, #{deviceName}, #{deviceType}, #{weight}, #{change}, now())")
    Boolean insertWeight(DeviceWeightScale deviceWeightScale);

    @Select("SELECT device_id, device_name, device_type, weight, `change`, create_time " +
            "FROM ( " +
            "    SELECT device_id, device_name, device_type, weight, `change`, create_time, " +
            "           ROW_NUMBER() OVER (PARTITION BY device_id ORDER BY create_time DESC) AS rn " +
            "    FROM weight_scale_data " +
            "    WHERE room_id = #{roomId} " +
            ") t " +
            "WHERE rn = 1")
    List<DeviceWeightScaleVo> selectInfo(String roomId);

    @Select("select device_id, device_name, device_type, weight, `change`, create_time from weight_scale_data where room_id = #{roomId} and device_id = #{deviceId} order by create_time desc")
    List<DeviceWeightScaleVo> selectInfoPro(String roomId, String deviceId);
}