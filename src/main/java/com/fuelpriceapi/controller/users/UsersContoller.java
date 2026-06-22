package com.fuelpriceapi.controller.users;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fuelpriceapi.model.classes.user.FuelUserClass;
import com.fuelpriceapi.service.user.FuelUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Users", description = "User Endpoints")

@RestController
@RequestMapping("/users")
public class UsersContoller {
    
    private final FuelUserService fuelUserService;

    public UsersContoller(FuelUserService fuelUserService) {
        this.fuelUserService = fuelUserService;
    }

    @Operation(summary = "Get all users")
    @GetMapping
    public ResponseEntity<List<FuelUserClass>> getUsers() {
        
        List<FuelUserClass> user = fuelUserService.getAllUsers();
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "Get user by email")
    @GetMapping
    public ResponseEntity<List<FuelUserClass>> getUserByEmail(String email) {
        
        List<FuelUserClass> user = fuelUserService.getUsersByEmail(email);
        return ResponseEntity.ok(user);
    }        
}
