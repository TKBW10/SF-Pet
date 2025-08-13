package com.pet.mapper;

import com.pet.annotation.AutoFill;
import com.pet.entity.UserHome;
import com.pet.enumeration.OperationType;
import com.pet.vo.UserHomeVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Mapper
public interface UserHomeMapper {
    @Select("select room_id, room_name from user_home where user_id = #{userId}")
    List<UserHomeVo> selectUserHomeInfo(String userId);

    @AutoFill(OperationType.INSERT)
    Boolean addRoom(UserHome userHome);

    @Select("select room_id from user_home where user_id = #{userId}")
    HashSet<String> selectRoomIds(String userId);

    @Select("select room_id, room_name from user_home where user_id = #{userId}")
    List<Map<String, String>> getRoomIdRoomNameMap(String userId);

    @Update("update user_home set room_name = #{roomName} where room_id = #{roomId}")
    Boolean updateRoomName(String roomId, String roomName);

    @Delete("delete from user_home where user_id = #{userId} and room_id = #{roomId}")
    Boolean deleteRoom(String userId, String roomId);
}
