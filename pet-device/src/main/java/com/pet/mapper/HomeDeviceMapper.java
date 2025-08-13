package com.pet.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.pet.annotation.AutoFill;
import com.pet.constant.DataSourceConstants;
import com.pet.entity.device.HomeDevice;
import com.pet.enumeration.OperationType;
import com.pet.vo.deviceVo.HomeDeviceVo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Set;

@Mapper
public interface HomeDeviceMapper {

    @AutoFill(OperationType.INSERT)
    @Insert("INSERT INTO home_device (user_id, room_id, device_id, device_name, device_type, online, ip_address, create_time, update_time) " +
            "VALUE (#{userId}, #{roomId}, #{deviceId}, #{deviceName}, #{deviceType}, #{online}, #{ipAddress}, #{createTime}, #{updateTime})")
    Boolean insert1(HomeDevice homeDevice);

    @Insert("insert into ${tableName} (user_id, room_id, device_id, device_name, device_type) " +
            "values (#{userId}, #{roomId}, #{deviceId}, #{deviceName}, #{deviceType})")
    Boolean insert2(String tableName, String userId, String roomId, String deviceId, String deviceName, String deviceType);

    @Select("select type_name from device_type")
    Set<String> getAllDeviceType();

    @Update("update home_device set online = #{online}, update_time = now() " +
            "where room_id = #{roomId} and device_id = #{deviceId}")
    Boolean updateOnline(String roomId, String deviceId, boolean online);

    @Select("select device_name from home_device where room_id = #{roomId}")
    @DS(DataSourceConstants.DEVICE)
    List<String> selectDeviceNames(String roomId);

    @Select("select device_type from home_device where room_id = #{roomId}")
    @DS(DataSourceConstants.DEVICE)
    Set<String> getDeviceTypeByRoomId(String roomId);

    @Update("update ${tableName} set room_id = NULL " +
            "where user_id = #{userId} and room_id = #{roomId}")
    @DS(DataSourceConstants.DEVICE)
    void deleteRoomIdOfDeviceToDeviceDataTable(String tableName, String userId, String roomId);

    @Update("update home_device set room_id = NULL " +
            "where user_id = #{userId} and room_id = #{roomId}")
    @DS(DataSourceConstants.DEVICE)
    void deleteRoomIdOfDevice(String userId, String roomId);

    @Select("select online from home_device where room_id = #{roomId} and device_id = #{deviceId}")
    Boolean selectOnline(String roomId, String deviceId);

    @Update("update home_device set device_name = #{deviceName} where room_id = #{roomId} and device_id = #{deviceId}")
    Boolean updateDeviceFromHomeDevice(String roomId, String deviceId, String deviceName);

    @Update("update ${tableName} set device_name = #{deviceName} where room_id = #{roomId} and device_id = #{deviceId}")
    Boolean updateDeviceFromDeviceDataTable(String tableName, String roomId, String deviceId, String deviceName);

    @Update("update home_device set room_id = #{newRoomId} where room_id = #{roomId} and device_id = #{deviceId}")
    Boolean updateDeviceRoomFromHomeDevice(String roomId, String deviceId, String newRoomId);

    @Update("update ${tableName} set room_id = #{newRoomId} where room_id = #{roomId} and device_id = #{deviceId}")
    Boolean updateDeviceRoomFromDeviceDataTable(String tableName, String roomId, String deviceId, String newRoomId);

    @Delete("delete from home_device where room_id = #{roomId} and device_id = #{deviceId}")
    Boolean deleteDeviceFromHomeDevice(String roomId, String deviceId);

    @Delete("delete from ${tableName} where room_id = #{roomId} and device_id = #{deviceId}")
    Boolean deleteDeviceFromDeviceDataTable(String tableName, String roomId, String deviceId);
}
