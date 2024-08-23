package com.situ.stadium.dao;

import com.situ.stadium.model.User;
import com.situ.stadium.model.search.UserSearchBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    List<User> getList(UserSearchBean usb);

    User findById(Integer id);

    User findByUsername(String username);

    int insert(User user);

    int update(User user);

    int deleteByIds(Integer[] ids);
}
