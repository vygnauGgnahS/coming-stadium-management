package com.situ.stadium.mobile.dao;

import com.situ.stadium.mobile.model.AreaMobile;
import com.situ.stadium.mobile.model.dto.UsableArea;
import com.situ.stadium.mobile.model.search.OrderMobileSearchBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AreaMobileDao {

    List<AreaMobile> findBySpId(Integer spId);

    AreaMobile findById(Integer id);

    List<UsableArea> getUsableArea(OrderMobileSearchBean omsb);
}
