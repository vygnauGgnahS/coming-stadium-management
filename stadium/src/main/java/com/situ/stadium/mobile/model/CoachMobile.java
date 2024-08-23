package com.situ.stadium.mobile.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CoachMobile {
    private Integer id;
    private String coName;
    private String photo;
    private Integer spId;
    private String sex;
    private String phone;
    private Double price;
    private LocalDate birthday;
    private String description;


}
