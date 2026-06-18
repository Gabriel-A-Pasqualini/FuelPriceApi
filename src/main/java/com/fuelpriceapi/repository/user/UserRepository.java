package com.fuelpriceapi.repository.user;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.fuelpriceapi.entity.user.FuelUser;

public interface UserRepository extends JpaRepository<FuelUser, Long> {
    Optional<FuelUser> findByEmail(String email);
    List<FuelUser> findAll();    
    
    default List<FuelUser> findAllMock(){
        FuelUser user = new FuelUser(
            1L, 
            "Gabriel", 
            "Pasqualini", 
            java.sql.Date.valueOf(LocalDate.of(2000, 5, 22)), 
            42782152823L, 
            "gabrielpasqualini2@gmail.com", 
            "5519991059618", 
            "Lalinha123<3" 
        );        

        return List.of(user);
    };    
}