package com.situ.stadium.service.impl;

import com.situ.stadium.dao.StatDao;
import com.situ.stadium.service.StatService;
import com.situ.stadium.util.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatServiceImpl implements StatService {
    StatDao statDao;

    @Autowired
    public void setStatDao(StatDao statDao) {
        this.statDao = statDao;
    }

    @Override
    public List<Tuple.KV<String, Long>> statOfSportsTypeOfOrders() {
        return this.statDao.statOfSportsTypeOfOrders();
    }

    @Override
    public List<Tuple.KV<String, Long>> statOfCoachOfOrders() {
        return this.statDao.statOfCoachOfOrders();
    }
}
