package com.situ.stadium.mobile.service.impl;


import com.situ.stadium.mobile.dao.SportsMobileDao;
import com.situ.stadium.mobile.model.SportsMobile;
import com.situ.stadium.mobile.service.SportsMobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportsMobileServiceImpl implements SportsMobileService {
    private SportsMobileDao sportsMobileDao;

    @Autowired
    public void setSportsMobileDao(SportsMobileDao sportsMobileDao) {
        this.sportsMobileDao = sportsMobileDao;
    }

    @Override
    public List<SportsMobile> getList() {
        return this.sportsMobileDao.getList();
    }
}
