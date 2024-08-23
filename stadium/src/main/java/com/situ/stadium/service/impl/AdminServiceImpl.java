package com.situ.stadium.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.situ.stadium.dao.AdminDao;
import com.situ.stadium.model.Admin;
import com.situ.stadium.model.search.AdminSearchBean;
import com.situ.stadium.model.search.PaginateInfo;
import com.situ.stadium.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao;

    @Autowired
    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public List<Admin> getAdminList(PaginateInfo pi, AdminSearchBean asb) {
        try (Page<?> __ = PageHelper.startPage(pi.getPageNo(), pi.getPageSize())) {
            return this.adminDao.getList(asb);
        }
    }

    @Override
    public Admin findByUsername(String username) {
        return this.adminDao.findByUsername(username);
    }

    @Override
    public Admin findById(Integer id) {
        return this.adminDao.findById(id);
    }

    @Override
    public int add(Admin admin) {
        return this.adminDao.insert(admin);
    }

    @Override
    public int edit(Admin admin) {
        return this.adminDao.update(admin);
    }

    @Override
    public int deleteByIds(Integer[] ids) {
        return this.adminDao.deleteByIds(ids);
    }
}
