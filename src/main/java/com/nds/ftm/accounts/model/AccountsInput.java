package com.nds.ftm.accounts.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountsInput {

    private String accountId;
    private String userId;
    private Integer balance;

}
