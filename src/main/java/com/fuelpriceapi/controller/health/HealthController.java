package com.fuelpriceapi.controller.health;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import com.fuelpriceapi.model.classes.health.HealthClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Health", description = "Endpoints de verificação da API")
@RestController
@RequestMapping("/health")
public class HealthController {

    private static final Logger log =
            LoggerFactory.getLogger(HealthController.class);

    @Operation(summary = "Verifica se a API está online")    
    @GetMapping
    public HealthClass health() {
        HealthClass health =  new HealthClass(
            "ok",
            "API is healthy"
        );
        log.info(
                "\nStatus: {} | Mensagem: {}",
                health.status(),
                health.message()
        );
        
        return health;
    }   
}