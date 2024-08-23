package com.situ.stadium.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Area {
    private Integer id;
    private String areaName;
    private Integer spId;
    private Character status;
    private String description;

    //所属运动项目
    private Sports sports;
}
