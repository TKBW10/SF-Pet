package com.pet.dto.deviceDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteDeviceDto {
    private String deviceType;
    private String roomId;
    private String deviceId;
}
