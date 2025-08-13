package com.pet.dto.deviceDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomeDeviceDto {
    private String roomId;
    private String deviceName;
    private String deviceType;
}
