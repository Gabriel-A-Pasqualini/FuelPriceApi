package com.fuelpriceapi.controller.users;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fuelpriceapi.dto.userDto.LoginResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Users", description = "User Endpoints")
@RestController
@RequestMapping("/users")
public class UsersContoller {
    
    @Operation(summary = "Get all users")
    @GetMapping
    public ResponseEntity<LoginResponseDTO> getUsers() {
        return null;
    }
}

