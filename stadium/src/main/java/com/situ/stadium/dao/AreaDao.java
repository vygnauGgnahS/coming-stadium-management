package com.situ.stadium.dao;

import com.situ.stadium.mobile.model.dto.UsableArea;
import com.situ.stadium.mobile.model.search.OrderMobileSearchBean;
import com.situ.stadium.model.Area;
import com.situ.stadium.model.search.AreaSearchBean;
import com.situ.stadium.model.search.OrderSearchBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AreaDao {

    List<Area> getList(AreaSearchBean asb);

    Area findById(Integer id);

    int insert(Area area);

    int update(Area area);

    List<Area> findAll(AreaSearchBean asb);

    int deleteByIds(Integer[] ids);

    List<Area> findAll();

    List<UsableArea> getUsableArea(OrderSearchBean osb);
}
