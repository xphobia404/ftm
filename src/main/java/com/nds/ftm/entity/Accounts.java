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
@Table(name = "accounts")
public class Accounts {

    @Id
    @Column(name = "account_id", nullable = false)
    private String accountId;

    @Column(name = "user_id", nullable = false, length = 255)
    private String userId;

    @Column(name = "balance", nullable = false, length = 255)
    private Integer balance;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime created_at;

    @CreatedDate
    @Column(name = "updated_at")
    private LocalDateTime updated_at;
}