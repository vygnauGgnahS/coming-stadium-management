package com.situ.stadium.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.situ.stadium.dao.CoachDao;
import com.situ.stadium.mobile.model.dto.UsableCoach;
import com.situ.stadium.model.Coach;
import com.situ.stadium.model.search.CoachSearchBean;
import com.situ.stadium.model.search.OrderSearchBean;
import com.situ.stadium.model.search.PaginateInfo;
import com.situ.stadium.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachServiceImpl implements CoachService {
    private CoachDao coachDao;

    @Autowired
    public void setCoachDao(CoachDao coachDao) {
        this.coachDao = coachDao;
    }

    @Override
    public List<Coach> getCoachList(PaginateInfo pi, CoachSearchBean csb) {
        try (Page<?> __ = PageHelper.startPage(pi.getPageNo(), pi.getPageSize())) {
            return this.coachDao.getList(csb);
        }
    }

    @Override
    public Coach findById(Integer id) {
        return this.coachDao.findById(id);
    }

    @Override
    public int add(Coach coach) {
        return this.coachDao.insert(coach);
    }

    @Override
    public int edit(Coach coach) {
        return this.coachDao.update(coach);
    }

    @Override
    public int deleteByIds(Integer[] ids) {
        return this.coachDao.deleteByIds(ids);
    }


    @Override
    public List<UsableCoach> getUsableCoach(OrderSearchBean osb) {
        return this.coachDao.getUsableCoach(osb);
    }
}
