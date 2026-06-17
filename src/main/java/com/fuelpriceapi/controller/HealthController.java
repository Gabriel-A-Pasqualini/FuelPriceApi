package com.fuelpriceapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import com.fuelpriceapi.model.classes.health.Health;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Health", description = "Endpoints de verificação da API")
@RestController
@RequestMapping("/health")
public class HealthController {

    @Operation(summary = "Verifica se a API está online")
    @GetMapping
    public Health health() {
        Health health =  new Health(
            "ok",
            "API is healthy"
        );

        health.status();
        health.message();
        
        System.out.println(health.status());
        System.out.println(health.message());
        
        return health;
    }   
}