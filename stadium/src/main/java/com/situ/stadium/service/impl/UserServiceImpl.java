package com.situ.stadium.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.situ.stadium.dao.UserDao;
import com.situ.stadium.model.User;
import com.situ.stadium.model.search.PaginateInfo;
import com.situ.stadium.model.search.UserSearchBean;
import com.situ.stadium.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getUserList(PaginateInfo pi, UserSearchBean usb) {
        //自动分页
        try (Page<?> __ = PageHelper.startPage(pi.getPageNo(), pi.getPageSize())) {
            return this.userDao.getList(usb);
        }
    }

    @Override
    public User getUserById(Integer id) {
        return this.userDao.findById(id);
    }

    @Override
    public User findByUsername(String username) {
        return this.userDao.findByUsername(username);
    }

    @Override
    public int add(User user) {
        return this.userDao.insert(user);
    }

    @Override
    public int edit(User user) {
        return this.userDao.update(user);
    }

    @Override
    public int deleteByIds(Integer[] ids) {
        return this.userDao.deleteByIds(ids);
    }
}
