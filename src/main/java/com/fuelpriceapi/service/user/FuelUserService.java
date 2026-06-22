package com.fuelpriceapi.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.fuelpriceapi.entity.user.FuelUser;
import com.fuelpriceapi.model.classes.user.FuelUserClass;
import com.fuelpriceapi.repository.user.UserRepository;

@Service
public class FuelUserService {

    private final UserRepository userRepository;

    public FuelUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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

    public List<FuelUserClass> getUsersByEmail(String email) {

        Optional<FuelUser> users = userRepository.findByEmail(email);

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
}