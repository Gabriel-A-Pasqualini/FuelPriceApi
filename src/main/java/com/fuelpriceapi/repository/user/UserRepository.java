package com.fuelpriceapi.repository.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.fuelpriceapi.entity.user.FuelUser;

public interface UserRepository extends JpaRepository<FuelUser, Long> {
    Optional<FuelUser> findByEmail(String email);
}