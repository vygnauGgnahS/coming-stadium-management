package com.situ.stadium.mobile.service.impl;

import com.situ.stadium.mobile.dao.AreaMobileDao;
import com.situ.stadium.mobile.dao.OrderMobileDao;
import com.situ.stadium.mobile.service.OrderMobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderMobileServiceImpl implements OrderMobileService {
    private OrderMobileDao orderMobileDao;
    private AreaMobileDao areaMobileDao;

    @Autowired
    public void setOrderMobileDao(OrderMobileDao orderMobileDao) {
        this.orderMobileDao = orderMobileDao;
    }

    @Autowired
    public void setAreaMobileDao(AreaMobileDao areaMobileDao) {
        this.areaMobileDao = areaMobileDao;
    }

}
