package com.situ.stadium.service;

import com.situ.stadium.model.Admin;
import com.situ.stadium.model.search.AdminSearchBean;
import com.situ.stadium.model.search.PaginateInfo;

import java.util.List;

public interface AdminService {
    /**
     * 查询管理员信息
     * @return 管理员列表
     */
    List<Admin> getAdminList(PaginateInfo pi, AdminSearchBean asb);

    Admin findByUsername(String username);

    /**
     * 根据id查找
     * @param id 待查找id
     * @return 查到的管理员
     */
    Admin findById(Integer id);

    /**
     * 新增管理员
     * @param admin 管理员信息
     * @return 新增条数
     */
    int add(Admin admin);

    /**
     * 编辑管理员信息
     * @param admin 待编辑管理员信息
     * @return 成功编辑条数
     */
    int edit(Admin admin);

    /**
     * 批量删除
     * @param ids 待删除管理员id
     * @return 成功删除条数
     */
    int deleteByIds(Integer[] ids);
}
