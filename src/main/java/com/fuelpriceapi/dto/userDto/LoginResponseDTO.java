package com.fuelpriceapi.dto.userDto;

import com.fuelpriceapi.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginResponseDTO {
    private User user;
    private String token;
}