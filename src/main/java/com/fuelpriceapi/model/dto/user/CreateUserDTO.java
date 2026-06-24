package com.fuelpriceapi.model.dto.user;

import java.util.Date;

public record CreateUserDTO(
    String name,
    String lastName,
    Date birthday,
    Long documentNumber,
    String email,
    String phone,
    String password
) {}