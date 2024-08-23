package com.situ.stadium.mobile.service.impl;

import com.situ.stadium.mobile.dao.AreaMobileDao;
import com.situ.stadium.mobile.dao.OrderMobileDao;
import com.situ.stadium.mobile.model.dto.UsableArea;
import com.situ.stadium.mobile.model.search.OrderMobileSearchBean;
import com.situ.stadium.mobile.service.AreaMobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaMobileServiceImpl implements AreaMobileService {
    private AreaMobileDao areaMobileDao;

    @Autowired
    public void setAreaMobileDao(AreaMobileDao areaMobileDao) {
        this.areaMobileDao = areaMobileDao;
    }

    @Override
    public List<UsableArea> getUsableArea(OrderMobileSearchBean omsb) {
        return this.areaMobileDao.getUsableArea(omsb);
    }
}
