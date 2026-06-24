package com.fuelpriceapi.service.user;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.fuelpriceapi.entity.user.FuelUser;
import com.fuelpriceapi.exception.user.FuelPriceException;
import com.fuelpriceapi.model.classes.user.FuelUserClass;
import com.fuelpriceapi.model.dto.user.CreateUserDTO;
import com.fuelpriceapi.repository.user.UserRepository;

@Service
public class FuelUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public FuelUserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<FuelUserClass> getAllUsers() {

        List<FuelUser> users = userRepository.findAll();

        return users.stream()
            .map(user -> new FuelUserClass(
                user.getId(),
                user.getName(),
                user.getLastName(),
                user.getBirthday(),
                user.getDocumentNumber(),
                user.getEmail(),
                user.getPhone()
            ))
            .toList();
    }

    public FuelUserClass getUsersByEmail(String email) {
        try{
            FuelUser user =
                userRepository.findByEmail(email)
                    .orElseThrow(() ->
                        new FuelPriceException(
                            "User not found with email: " + email
                        )
                    );

            return new FuelUserClass(
                user.getId(),
                user.getName(),
                user.getLastName(),
                user.getBirthday(),
                user.getDocumentNumber(),
                user.getEmail(),
                user.getPhone()
            );
        }catch(Exception e){
            throw new FuelPriceException(
                "Error retrieving user by email: " + e.getMessage()
            );
        }
    }    
    
    public FuelUserClass createUser(CreateUserDTO user) {

        if (userRepository.findByEmail(user.email()).isPresent()) {
            throw new FuelPriceException(
                    "Email already registered");
        }

        System.out.println(user);
      
        FuelUser userCreate = FuelUser.builder()
                .name(user.name())
                .lastName(user.lastName())
                .birthday(user.birthday())
                .documentNumber(user.documentNumber())
                .email(user.email())
                .phone(user.phone())
                .password(passwordEncoder.encode(user.password()))
                .build();

        FuelUser savedUser = userRepository.save(userCreate);

        return new FuelUserClass(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getLastName(),
                savedUser.getBirthday(),
                savedUser.getDocumentNumber(),
                savedUser.getEmail(),
                savedUser.getPhone()
        );
    }   

    public void deleteUser(Long id) {

        if (!userRepository.existsById(id)) {
            throw new FuelPriceException(
                "User not found: " + HttpStatus.NOT_FOUND
            );
        }

        userRepository.deleteById(id);
    }    
}