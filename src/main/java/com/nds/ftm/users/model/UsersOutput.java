package com.nds.ftm.users.model;

import java.time.LocalDateTime;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersOutput {

    private String UserId;
    private String name;
    private String email;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}
