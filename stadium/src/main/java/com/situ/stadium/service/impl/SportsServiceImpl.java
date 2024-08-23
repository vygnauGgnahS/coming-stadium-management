package com.situ.stadium.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.situ.stadium.dao.SportsDao;
import com.situ.stadium.mobile.model.SportsMobile;
import com.situ.stadium.model.Sports;
import com.situ.stadium.model.search.PaginateInfo;
import com.situ.stadium.model.search.SportsSearchBean;
import com.situ.stadium.service.SportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportsServiceImpl implements SportsService {
    private SportsDao sportsDao;

    @Autowired
    public void setSportsDao(SportsDao sportsDao) {
        this.sportsDao = sportsDao;
    }

    @Override
    public List<Sports> getSportsList(PaginateInfo pi, SportsSearchBean ssb) {
        try (Page<?> __ = PageHelper.startPage(pi.getPageNo(), pi.getPageSize())) {
            return this.sportsDao.getList(ssb);
        }
    }

    @Override
    public List<SportsMobile> findAll() {
        return this.sportsDao.findAll();
    }

    @Override
    public Sports findById(Integer id) {
        return this.sportsDao.findById(id);
    }

    @Override
    public int add(Sports sports) {
        return this.sportsDao.insert(sports);
    }

    @Override
    public int edit(Sports sports) {
        return this.sportsDao.update(sports);
    }

    @Override
    public int deleteByIds(Integer[] ids) {
        return this.sportsDao.deleteByIds(ids);
    }
}
