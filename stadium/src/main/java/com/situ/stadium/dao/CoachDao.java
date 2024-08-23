package com.situ.stadium.dao;

import com.situ.stadium.mobile.model.dto.UsableCoach;
import com.situ.stadium.model.Coach;
import com.situ.stadium.model.search.CoachSearchBean;
import com.situ.stadium.model.search.OrderSearchBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CoachDao {
    List<Coach> getList(CoachSearchBean csb);

    Coach findById(Integer id);

    int insert(Coach coach);

    int update(Coach coach);

    int deleteByIds(Integer[] ids);

    List<UsableCoach> getUsableCoach(OrderSearchBean osb);

}
