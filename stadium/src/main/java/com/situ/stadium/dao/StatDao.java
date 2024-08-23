package com.situ.stadium.dao;

import com.situ.stadium.util.Tuple;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StatDao {
    List<Tuple.KV<String, Long>> statOfSportsTypeOfOrders();

    List<Tuple.KV<String, Long>> statOfCoachOfOrders();

}