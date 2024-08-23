package com.situ.stadium.mobile.dao;

import com.situ.stadium.mobile.model.AreaMobile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CoachMobileDao {
    List<AreaMobile> findBySpId(Integer spId);
}
