package com.situ.stadium.mobile.dao;

import com.situ.stadium.mobile.model.SportsMobile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SportsMobileDao {
    List<SportsMobile> getList();
}
