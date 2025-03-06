package com.nds.ftm.accounts.model;

import java.time.LocalDateTime;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountsOutput {

    private String accountId;
    private String userId;
    private Integer balance;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}
