package com.pet.service.Impl;

import com.github.promeg.pinyinhelper.Pinyin;
import com.pet.context.BaseContext;
import com.pet.dto.PetDto;
import com.pet.entity.Pet;
import com.pet.entity.PetType;
import com.pet.mapper.PetMapper;
import com.pet.result.Result;
import com.pet.service.PetService;
import com.pet.vo.PetVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;

@Service
public class PetServiceImpl implements PetService {

    private final PetMapper petMapper;

    public PetServiceImpl(PetMapper petMapper) {
        this.petMapper = petMapper;
    }

    @Override
    public List<PetVo> getPet(String roomId) {
        return petMapper.selectPetsInfo(roomId);
    }

    @Override
    public Result<String> addPet(PetDto petDto) {
        Boolean species = petMapper.selectSpecies(petDto.getSpecies());
        if (!species.equals(Boolean.TRUE)) {
            Boolean insert = petMapper.insertSpecies(petDto.getSpecies());
            if (!insert.equals(Boolean.TRUE)) {
                return Result.error("添加失败");
            }
        }
        Boolean breed = petMapper.selectBreed(petDto.getSpecies(),petDto.getBreed());
        if (!breed.equals(Boolean.TRUE)) {
            Boolean insert = petMapper.insertBreed(petDto.getSpecies(),petDto.getBreed());
            if (!insert.equals(Boolean.TRUE)) {
                return Result.error("添加失败");
            }
        }
        Pet pet = new Pet();
        BeanUtils.copyProperties(petDto,pet);
        pet.setUserId(BaseContext.getCurrentId());
        pet.setPetId(Pinyin.toPinyin(petDto.getSpecies(),"") + "_" + Instant.now().toEpochMilli());
        Boolean success = petMapper.insert(pet);
        if (!success.equals(Boolean.TRUE)) {
            return Result.error("添加失败");
        }
        return Result.success();
    }

    @Override
    public Map<String, Set<String>> getPetType() {
        List<PetType> typeList = petMapper.selectPetType();
        Map<String,Set<String>> petTypeMap = new HashMap<>();
        typeList.forEach(petType -> {
            String species = petType.getSpecies();
            String breed = petType.getBreed();
            Set<String> breedSet = petTypeMap.getOrDefault(species,new HashSet<>());
            breedSet.add(breed);
            petTypeMap.put(species,breedSet);
        });
        return petTypeMap;
    }

    @Override
    public PetVo petDetail(String petId) {
        return petMapper.selectPetDetail(BaseContext.getCurrentId(), petId);
    }
}
