package com.fuelpriceapi.entity.user;
import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private Date birthday;
    private Long documentNumber;
    @Column(unique = true)
    private String email;
    private String phone;
    private String password;
}