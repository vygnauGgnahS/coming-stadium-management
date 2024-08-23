package com.situ.stadium.dao;

import com.situ.stadium.model.Admin;
import com.situ.stadium.model.search.AdminSearchBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminDao {

    List<Admin> getList(AdminSearchBean asb);

    Admin findByUsername(String username);

    Admin findById(Integer id);

    int insert(Admin admin);

    int update(Admin admin);

    int deleteByIds(Integer[] ids);
}
