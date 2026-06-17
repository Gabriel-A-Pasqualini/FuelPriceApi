package com.fuelpriceapi.controller.users;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fuelpriceapi.model.classes.log.LogApplication;
import com.fuelpriceapi.model.classes.user.FuelUserClass;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Users", description = "User Endpoints")

@RestController
@RequestMapping("/users")
public class UsersContoller {

    @Operation(summary = "Get all users")
    @GetMapping
    public ResponseEntity<FuelUserClass> getUsers() {
        FuelUserClass user = new FuelUserClass(
            1L, 
            "Gabriel", 
            "Pasqualini", 
            java.sql.Date.valueOf(LocalDate.of(2000, 5, 22)), 
            42782152823L, 
            "gabrielpasqualini2@gmail.com", 
            "5519991059618", 
            "Lalinha123<3"
        );

        //new LogApplication("Users retrieved successfully", user.getClass());

        return ResponseEntity.ok(user);
    }
}

