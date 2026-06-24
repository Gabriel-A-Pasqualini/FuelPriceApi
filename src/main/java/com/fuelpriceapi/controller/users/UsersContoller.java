package com.fuelpriceapi.controller.users;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fuelpriceapi.model.classes.user.FuelUserClass;
import com.fuelpriceapi.model.dto.user.CreateUserDTO;
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
    @GetMapping("/email")
    public ResponseEntity<FuelUserClass> getUserByEmail(String email) {
        
        FuelUserClass user = fuelUserService.getUsersByEmail(email);
        return ResponseEntity.ok(user);
    }        

    @PostMapping
    public  ResponseEntity<?>  createUser(@RequestBody CreateUserDTO user) {

        if (user.email() == null|| 
            user.name() == null || 
            user.lastName() == null || 
            user.birthday() == null || 
            user.documentNumber() == null || 
            user.phone() == null || 
            user.password() == null
        ) {
            return ResponseEntity
                    .badRequest()
                    .body("Fields cannot be null, please check the request body: " + HttpStatus.BAD_REQUEST);
        }

        FuelUserClass createdUser = fuelUserService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
}
