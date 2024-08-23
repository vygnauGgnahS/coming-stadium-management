package com.situ.stadium.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class User {
    private Integer id;
    private String name;
    private String nickname;
    private String username;
    private String password;
    private String sex;
    private LocalDate birthday;
    private String phone;
    private String avatar;
    private String wechat;
    private String qq;
    private String description;
}
