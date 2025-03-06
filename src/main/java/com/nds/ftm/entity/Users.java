package com.nds.ftm.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class Users {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime created_at;

    @CreatedDate
    @Column(name = "updated_at")
    private LocalDateTime updated_at;
}