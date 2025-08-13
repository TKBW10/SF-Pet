package com.pet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserHome {
    private Long id;
    private String userId;
    private String roomId;
    private String roomName;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
