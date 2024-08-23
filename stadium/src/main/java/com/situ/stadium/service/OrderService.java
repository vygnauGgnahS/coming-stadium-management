package com.situ.stadium.service;

import com.situ.stadium.model.Order;
import com.situ.stadium.model.search.OrderSearchBean;
import com.situ.stadium.model.search.PaginateInfo;

import java.util.List;

public interface OrderService {
    /**
     * 查询订单信息列表
     * @return 订单列表
     */
    List<Order> getOrderList(PaginateInfo pi, OrderSearchBean osb);

    /**
     * 根据id查询
     * @param id 查询id
     * @return 查询到的订单
     */
    Order findById(Integer id);

//    List<Order> findByUserId(Integer id);

    /**
     * 提交订单
     * @param order 订单信息
     * @return 成功提交数量
     */
    int add(Order order);

    /**
     * 修改订单信息
     * @param order 订单信息
     * @return 成功修改条数
     */
    int edit(Order order);

    /**
     * 取消订单
     * @param id 订单id
     * @return 取消条数
     */
    int cancel(Integer id);

    /**
     * 批量删除订单
     * @param ids 待删除订单id数组
     * @return 成功删除条数
     */
    int deleteByIds(Integer[] ids);
}
