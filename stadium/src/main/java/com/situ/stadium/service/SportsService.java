package com.situ.stadium.service;

import com.situ.stadium.mobile.model.SportsMobile;
import com.situ.stadium.model.Sports;
import com.situ.stadium.model.search.PaginateInfo;
import com.situ.stadium.model.search.SportsSearchBean;

import java.util.List;

public interface SportsService {

    /**
     * 查询运动项目信息
     * @return 运动项目信息列表
     */
    List<Sports> getSportsList(PaginateInfo pi, SportsSearchBean ssb);

    List<SportsMobile> findAll();

    /**
     * 根据id查找
     * @param id 待查找id
     * @return 带查找运动项目
     */
    Sports findById(Integer id);

    /**
     * 新增运动项目
     * @param sports 运动项目信息
     * @return 成功新增条数
     */
    int add(Sports sports);

    /**
     * 编辑运动项目信息
     * @param sports 待编辑运动
     * @return 成功编辑条数
     */
    int edit(Sports sports);

    /**
     * 批量删除运动信息
     * @param ids 待删除运动id数组
     * @return 成功删除条数
     */
    int deleteByIds(Integer[] ids);
}
