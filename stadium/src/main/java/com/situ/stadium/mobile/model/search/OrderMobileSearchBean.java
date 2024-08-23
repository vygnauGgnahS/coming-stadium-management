package com.situ.stadium.mobile.model.search;

import com.situ.stadium.mobile.model.OrderMobile;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderMobileSearchBean extends OrderMobile {
    private String timeFrom;
    private String timeTo;
}
