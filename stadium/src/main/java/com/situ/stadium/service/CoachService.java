package com.situ.stadium.service;

import com.situ.stadium.mobile.model.dto.UsableCoach;
import com.situ.stadium.model.Coach;
import com.situ.stadium.model.search.CoachSearchBean;
import com.situ.stadium.model.search.OrderSearchBean;
import com.situ.stadium.model.search.PaginateInfo;

import java.util.List;

public interface CoachService {
    /**
     * 查询教练信息
     * @return 教练列表
     */
    List<Coach> getCoachList(PaginateInfo pi, CoachSearchBean csb);

    /**
     * 根据id查找
     * @param id 待查找id
     * @return 查到的教练
     */
    Coach findById(Integer id);

    /**
     * 新增教练
     * @param coach 教练信息
     * @return 新增条数
     */
    int add(Coach coach);

    /**
     * 编辑教练信息
     * @param coach 待编辑教练信息
     * @return 成功编辑条数
     */
    int edit(Coach coach);

    /**
     * 批量删除
     * @param ids 待删除的教练id
     * @return 成功删除条数
     */
    int deleteByIds(Integer[] ids);


    List<UsableCoach> getUsableCoach(OrderSearchBean osb);

}
