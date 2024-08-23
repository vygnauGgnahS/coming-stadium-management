package com.situ.stadium.mobile.service;

import com.situ.stadium.mobile.model.dto.UsableArea;
import com.situ.stadium.mobile.model.search.OrderMobileSearchBean;

import java.util.List;

public interface AreaMobileService {
    List<UsableArea> getUsableArea(OrderMobileSearchBean omsb);
}
