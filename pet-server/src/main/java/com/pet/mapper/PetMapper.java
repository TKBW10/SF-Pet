package com.pet.mapper;

import com.pet.annotation.AutoFill;
import com.pet.entity.Pet;
import com.pet.entity.PetType;
import com.pet.enumeration.OperationType;
import com.pet.vo.PetVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PetMapper {

    @Select("select pet_id, pet_name, breed, avatar_url from pet where room_id = #{roomId}")
    List<PetVo> selectPetsInfo(String roomId);

    @Select("select exists(select 1 from pet_species where species = #{species})")
    Boolean selectSpecies(String species);

    @Insert("insert into pet_species (species) values (#{species})")
    Boolean insertSpecies(String species);

    @Select("select exists(select 1 from pet_breed where species = #{species} and breed = #{breed})")
    Boolean selectBreed(String species, String breed);

    @Insert("insert into pet_breed (species,breed) values (#{species},#{breed})")
    Boolean insertBreed(String species, String breed);

    @AutoFill(OperationType.INSERT)
    Boolean insert(Pet pet);

    @Select("select species,breed from pet_breed")
    List<PetType> selectPetType();

    @Select("select pet_id, pet_name, species, breed, gender, birth_date, weight, avatar_url, health_status from pet where user_id = #{userId} and pet_id = #{petId}")
    PetVo selectPetDetail(String userId, String petId);

    @Select("select pet_name from pet where room_id = #{roomId}")
    List<String> selectPetNames(String roomId);
}
