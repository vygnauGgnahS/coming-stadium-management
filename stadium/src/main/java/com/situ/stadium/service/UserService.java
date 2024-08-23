package com.situ.stadium.service;

import com.situ.stadium.model.User;
import com.situ.stadium.model.search.PaginateInfo;
import com.situ.stadium.model.search.UserSearchBean;

import java.util.List;

public interface UserService {

    /**
     * 查询用户
     * @return  用户列表
     */
    List<User> getUserList(PaginateInfo pi, UserSearchBean usb);

    /**
     * 根据id查询用户
     * @param id 查询id
     * @return 被查询用户
     */
    User getUserById(Integer id);

    User findByUsername(String username);

    /**
     * 新增用户
     * @param user 用户信息
     * @return 新增数
     */
    int add(User user);

    /**
     * 编辑信息
     * @param user 被编辑用户信息
     * @return 新增数
     */
    int edit(User user);

    /**
     * 批量删除
     * @param ids 被删除用户id数组
     * @return 删除行数
     */
    int deleteByIds(Integer[] ids);
}
