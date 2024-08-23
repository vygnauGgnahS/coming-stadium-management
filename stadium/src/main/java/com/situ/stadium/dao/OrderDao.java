package com.situ.stadium.dao;

import com.situ.stadium.model.Order;
import com.situ.stadium.model.search.OrderSearchBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDao {
    List<Order> getList(OrderSearchBean osb);

    Order findById(Integer id);

    List<Integer> findByTime(Order order);

    List<Order> findByUserId(Integer userId);

    int insert(Order order);

    int update(Order order);

    int cancel(Integer id);

    int deleteByIds(Integer[] ids);
}
