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
    public Long id;
    public String name;
    public String lastName;
    public Date birthday;
    public Long documentNumber;
    @Column(unique = true)
    public String email;
    public String phone;
    public String password;

    public User(String name, String lastName, Date birthday, Long documentNumber, String email, String phone, String password) {
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.documentNumber = documentNumber;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
}