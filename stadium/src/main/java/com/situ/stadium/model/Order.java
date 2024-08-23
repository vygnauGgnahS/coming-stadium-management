package com.situ.stadium.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Order {
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

    //预定用户
    private User user;
    //所选教练。可为空
    private Coach coach;
    //所选运动项目
    private Sports sports;
    //所选运动场所
    private Area area;

}
