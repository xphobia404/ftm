package com.nds.ftm.users.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersInput {

    private String id;
    private String name;
    private String password;
    private String email;

}
