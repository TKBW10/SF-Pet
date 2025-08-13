package com.pet.controller;

import com.pet.dto.PetDto;
import com.pet.result.Result;
import com.pet.service.PetService;
import com.pet.vo.PetVo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/pet/pet")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping("/{roomId}")
    public Result<List<PetVo>> getPet(@PathVariable String roomId) {
        return Result.success(petService.getPet(roomId));
    }

    @PostMapping("/add")
    public Result<String> addPet(@RequestBody PetDto petDto) {
        return petService.addPet(petDto);
    }

    @GetMapping("/petType")
    public Result<Map<String,Set<String>>> getPetType() {
        return Result.success(petService.getPetType());
    }

    @GetMapping("/{petId}")
    public Result<PetVo> petDetail(@PathVariable String petId) {
        PetVo petVo = petService.petDetail(petId);
        if (petVo == null) {
            return Result.error("获取失败");
        }
        return Result.success(petVo);
    }
}
