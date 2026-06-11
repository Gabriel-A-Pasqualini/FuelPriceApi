package com.fuelpriceapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Health", description = "Endpoints de verificação da API")
@RestController
@RequestMapping("/health")
public class HealthController {

    @Operation(summary = "Verifica se a API está online")
    @GetMapping
    public Map<String, String> health() {
        return Map.of("status", "ok");
    }
    //http://localhost:8080/swagger-ui.html
}