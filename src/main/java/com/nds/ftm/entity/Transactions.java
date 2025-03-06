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
@Table(name = "transactions")
public class Transactions {

    @Id
    @Column(name = "transaction_id", nullable = false)
    private String transactionId;

    @Column(name = "account_id", nullable = false, length = 255)
    private String accountId;

    @Column(name = "type", nullable = false, length = 255)
    private String type;

    @Column(name = "amount", nullable = false, length = 255)
    private Integer amount;

    @CreatedDate
    @Column(name = "timestamp")
    private LocalDateTime timestamp;
}