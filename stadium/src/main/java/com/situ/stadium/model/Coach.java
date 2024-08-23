package com.situ.stadium.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Coach {
    private Integer id;
    private String coName;
    private String photo;
    private Integer spId;
    private String sex;
    private String phone;
    private Double price;
    private LocalDate birthday;
    private String description;


    //陪练运动项目
    private Sports sports;
}
