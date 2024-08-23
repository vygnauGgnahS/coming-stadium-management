package com.situ.stadium.model.search;

import com.situ.stadium.model.Order;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderSearchBean extends Order {
    private String name;
    private String phone;
    private String timeFrom;
    private String timeTo;
}
