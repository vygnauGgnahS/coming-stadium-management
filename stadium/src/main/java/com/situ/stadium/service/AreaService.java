package com.situ.stadium.service;

import com.situ.stadium.mobile.model.dto.UsableArea;
import com.situ.stadium.model.Area;
import com.situ.stadium.model.search.AreaSearchBean;
import com.situ.stadium.model.search.OrderSearchBean;
import com.situ.stadium.model.search.PaginateInfo;

import java.util.List;

public interface AreaService {
    /**
     * 查询场地信息
     * @return 运动场地数据列表
     */
    List<Area> getAreaList(PaginateInfo pi, AreaSearchBean asb);

    /**
     * 根据id查询
     * @param id 查询id
     * @return 查询到的场地信息
     */
    Area findById(Integer id);

    /**
     * 新增场地
     * @param area 新增场地信息
     * @return 成功新增条数
     */
    int add(Area area);

    List<Area> findAll();

    /**
     * 编辑场地信息
     * @param area 待编辑场地
     * @return 成功编辑条数
     */
    int edit(Area area);

    /**
     * 批量删除场地
     * @param ids 待删除场地id数组
     * @return 成功删除条数
     */
    int deleteByIds(Integer[] ids);


    List<UsableArea> getUsableArea(OrderSearchBean osb);

}
