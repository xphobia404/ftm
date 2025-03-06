package com.nds.ftm.transactions.model;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportOutput {

    private String type;
    private Integer totalTransactions;
    private Integer totalAmount;

}
