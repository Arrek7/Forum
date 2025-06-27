package com.comarch.szkolenia.forum.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
    private int id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private Role role;

    public enum Role {
        USER,
        ADMIN
    }
}
