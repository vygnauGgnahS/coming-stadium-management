package com.situ.stadium.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.situ.stadium.dao.AreaDao;
import com.situ.stadium.mobile.model.dto.UsableArea;
import com.situ.stadium.model.Area;
import com.situ.stadium.model.search.AreaSearchBean;
import com.situ.stadium.model.search.OrderSearchBean;
import com.situ.stadium.model.search.PaginateInfo;
import com.situ.stadium.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    private AreaDao areaDao;

    @Autowired
    public void setAreaDao(AreaDao areaDao) {
        this.areaDao = areaDao;
    }

    @Override
    public List<Area> getAreaList(PaginateInfo pi, AreaSearchBean asb) {
        try (Page<?> __ = PageHelper.startPage(pi.getPageNo(), pi.getPageSize())) {
            return this.areaDao.getList(asb);
        }
    }

    @Override
    public Area findById(Integer id) {
        return this.areaDao.findById(id);
    }

    @Override
    public int add(Area area) {
        int spId = area.getSpId();
        AreaSearchBean asb = new AreaSearchBean();
        asb.setSpId(spId);
        List<Area> list = this.areaDao.getList(asb);
        int count = 0;
        if (list != null && !list.isEmpty()) {
            count = list.size();
        }
        String areaName = area.getAreaName();
        area.setAreaName(count + 1 + "号" + areaName);
        return this.areaDao.insert(area);
    }

    @Override
    public List<Area> findAll() {
        return this.areaDao.findAll();
    }

    @Override
    public int edit(Area area) {
        return this.areaDao.update(area);
    }

    @Override
    public int deleteByIds(Integer[] ids) {
        return this.areaDao.deleteByIds(ids);
    }

    @Override
    public List<UsableArea> getUsableArea(OrderSearchBean osb) {
        return this.areaDao.getUsableArea(osb);
    }
}
