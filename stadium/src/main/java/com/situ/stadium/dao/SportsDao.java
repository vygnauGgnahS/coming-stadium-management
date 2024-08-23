package com.situ.stadium.dao;

import com.situ.stadium.mobile.model.SportsMobile;
import com.situ.stadium.model.Sports;
import com.situ.stadium.model.search.SportsSearchBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SportsDao {

    List<Sports> getList(SportsSearchBean ssb);

    List<SportsMobile> findAll();

    Sports findById(Integer id);

    int insert(Sports sports);

    int update(Sports sports);

    int deleteByIds(Integer[] ids);

}
