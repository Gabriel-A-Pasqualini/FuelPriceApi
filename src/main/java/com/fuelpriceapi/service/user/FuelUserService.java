package com.fuelpriceapi.service.user;

import java.util.List;
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

        List<FuelUser> users = userRepository.findAllMock();

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
    }    
    
    public FuelUserClass createUser(CreateUserDTO request) {

        if (userRepository.findByEmail(request.email()).isPresent()) {
            throw new FuelPriceException(
                    "Email already registered");
        }
      

        FuelUser user = FuelUser.builder()
                .name(request.name())
                .lastName(request.lastName())
                .birthday(request.birthday())
                .documentNumber(request.documentNumber())
                .email(request.email())
                .phone(request.phone())
                .password(passwordEncoder.encode(request.password()))
                .build();

        FuelUser savedUser = userRepository.save(user);

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
}