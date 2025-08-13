package com.pet.dto.deviceDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperateDto {
    private String roomId;
    private String deviceId;
    private String deviceType;
    private String operation;
    private String value;
}
