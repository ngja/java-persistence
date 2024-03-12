package com.hansol.javapersistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "USERS")
@Getter
@ToString
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Setter
    private String username;

    @Setter
    private LocalDate registrationDate;

    @Setter
    private String email;

    @Setter
    private int level;

    @Setter
    private boolean active;

    public User(String username, LocalDate registrationDate) {
        this.username = username;
        this.registrationDate = registrationDate;
    }
}
