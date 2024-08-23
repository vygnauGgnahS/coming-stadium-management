package com.situ.stadium.model;

import com.situ.stadium.mobile.model.AreaMobile;
import com.situ.stadium.mobile.model.CoachMobile;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Sports {
    private Integer id;
    private String spName;
    private Double price;
    private String description;

    private List<AreaMobile> areaList;
    private List<CoachMobile> coachList;
}
