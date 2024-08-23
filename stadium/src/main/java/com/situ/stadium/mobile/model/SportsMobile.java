package com.situ.stadium.mobile.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SportsMobile {
    private Integer id;
    private String spName;
    private Double price;
    private String description;

    private List<AreaMobile> areaList;
    private List<CoachMobile> coachList;

}
