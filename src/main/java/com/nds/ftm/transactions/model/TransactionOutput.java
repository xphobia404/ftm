package com.nds.ftm.transactions.model;

import java.time.LocalDateTime;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionOutput {

    private String accountId;
    private String transactionId;
    private String type;
    private Integer amount;
    private LocalDateTime timestamp;

}
