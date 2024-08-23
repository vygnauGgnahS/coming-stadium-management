package com.situ.stadium.mobile.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderMobile {
    private Integer id;
    private Integer userId;
    private Integer coId;
    private Integer spId;
    private Integer spaId;
    private String subTime;
    private Character status;
    private String startTime;
    private String endTime;
    private Double payment;
    private String description;

}
