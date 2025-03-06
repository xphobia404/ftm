package com.nds.ftm.transactions.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionInput {

    private String accountId;
    private String type;
    private Integer amount;
    private String startDate;
    private String endDate;

}
