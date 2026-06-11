package com.fuelpriceapi.controller.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fuelpriceapi.dto.userDto.LoginRequestDTO;
import com.fuelpriceapi.dto.userDto.LoginResponseDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Auth", description = "Endpoint de login")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Operation(summary = "Realiza o Login")
    @GetMapping
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO request) {
        return null;
    }
}
