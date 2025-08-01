package com.pet.mapper;

import com.pet.annotation.AutoFill;
import com.pet.entity.User;
import com.pet.enumeration.OperationType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @AutoFill(OperationType.INSERT)
    Boolean insert(User user);

    @Select("select password from user where phone_number = #{phoneNumber}")
    User selectUser(String phoneNumber);
}