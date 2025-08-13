package com.pet.service;

import com.pet.dto.PetDto;
import com.pet.result.Result;
import com.pet.vo.PetVo;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface PetService {

    List<PetVo> getPet(String roomId);

    Result<String> addPet(PetDto petDto);

    Map<String, Set<String>> getPetType();

    PetVo petDetail(String petId);
}
