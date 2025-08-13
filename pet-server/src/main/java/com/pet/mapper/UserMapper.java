package com.pet.mapper;

import com.pet.annotation.AutoFill;
import com.pet.entity.User;
import com.pet.enumeration.OperationType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    @AutoFill(OperationType.INSERT)
    Boolean insert(User user);

    @Select("select user_id, username, password from user where phone_number = #{phoneNumber}")
    User selectUser(String phoneNumber);

    @Select("select password from user where phone_number = #{phoneNumber}")
    String selectPassword(String phoneNumber);

    @Update("update user set password = #{newPassword} , update_time = now() where phone_number = #{phoneNumber}")
    Boolean updatePassword(String phoneNumber, String newPassword);
}