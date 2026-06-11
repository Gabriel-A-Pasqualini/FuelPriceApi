package com.fuelpriceapi.dto.userDto;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDTO {

    private Long id;
    private String name;
    private String lastName;
    private Date birthday;
    private Long documentNumber;
    private String email;
    private String phone;
    private String password;
}