package com.fuelpriceapi.controller.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fuelpriceapi.model.dto.authDto.LoginRequestDto;
import com.fuelpriceapi.model.dto.authDto.LoginResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Auth", description = "Endpoint de login")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Operation(summary = "Realiza o Login")
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto request) {
        LoginResponseDto response = new LoginResponseDto("mock-jwt-token-123456");
        return ResponseEntity.ok(response);
    }
}