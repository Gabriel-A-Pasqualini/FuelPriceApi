package com.fuelpriceapi.model.classes.user;

import java.util.Date;

public record FuelUserClass (
    Long id,
    String name,
    String lastName,
    Date birthday,
    Long documentNumber,
    String email,   
    String phone,
    String password
) {}