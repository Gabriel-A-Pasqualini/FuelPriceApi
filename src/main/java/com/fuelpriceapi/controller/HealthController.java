package com.fuelpriceapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import com.fuelpriceapi.entity.health.Health;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Health", description = "Endpoints de verificação da API")
@RestController
@RequestMapping("/health")
public class HealthController {

    @Operation(summary = "Verifica se a API está online")
    @GetMapping
    public Health health() {
        return new Health(
            "ok",
            "API is healthy"
        );
    }   
}