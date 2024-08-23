package com.situ.stadium.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.situ.stadium.dao.*;
import com.situ.stadium.model.*;
import com.situ.stadium.model.search.OrderSearchBean;
import com.situ.stadium.model.search.PaginateInfo;
import com.situ.stadium.service.OrderService;
import com.situ.stadium.util.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;
    private CoachDao coachDao;
    private SportsDao sportsDao;

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
    @Autowired
    public void setCoachDao(CoachDao coachDao) {
        this.coachDao = coachDao;
    }
    @Autowired
    public void setSportsDao(SportsDao sportsDao) {
        this.sportsDao = sportsDao;
    }

    @Override
    public List<Order> getOrderList(PaginateInfo pi, OrderSearchBean osb) {
        List<Order> orderList = this.orderDao.getList(osb);
        for (Order order : orderList) {
            LocalDateTime endTime =  DateTimeUtils.parseDateTime(order.getEndTime());
            if (LocalDateTime.now().isAfter(endTime)) {//当前时间比订单结束时间晚，表示订单已过期
                order.setStatus('1');//订单状态设为完成
                this.orderDao.update(order);
            }
        }

        try (Page<?> __ = PageHelper.startPage(pi.getPageNo(), pi.getPageSize())) {
            return this.orderDao.getList(osb);
        }
    }

    @Override
    public Order findById(Integer id) {
        return this.orderDao.findById(id);
    }


    //判断是否已有订单
    private boolean canAddOrder(Order order) {
        List<Order> orders =  this.orderDao.findByUserId(order.getUserId());
        return orders == null || orders.isEmpty();
    }
    //判断时间是否冲突
    private boolean isTimeOk(Order order) {
        List<Integer> orderIds = this.orderDao.findByTime(order);
        return orderIds != null && !orderIds.isEmpty();
    }

    //计算花费
    private Double getPayment(Order order, Double sportsPrice, Double coachPrice) {
        LocalDateTime st = DateTimeUtils.parseDateTime(order.getStartTime());
        LocalDateTime et = DateTimeUtils.parseDateTime(order.getEndTime());
        //计算时长
        double minutes = DateTimeUtils.duration(st, et);
        //总花费
        return (sportsPrice + coachPrice) * minutes / 60.0;
    }

    @Override
    @Transactional
    public int add(Order order) {
        //判断是否已有订单
        if (!canAddOrder(order)) {
            return -1;
        }
        //判断是否时间冲突
        if (isTimeOk(order)) {
            return -2;
        }
        Coach coach = this.coachDao.findById(order.getCoId());
        Sports sports = this.sportsDao.findById(order.getSpId());

//        System.out.println(order.getSpId());

        Double coachPrice = 0.00;
        if (coach != null) {
            order.setCoach(coach);
            coachPrice = coach.getPrice();
        }
        order.setSports(sports);
        Double sportsPrice = sports.getPrice();

        order.setStatus('0');
        //总花费
        Double payment = getPayment(order, sportsPrice, coachPrice);
        order.setPayment(payment);
        //设置提交时间
        order.setSubTime(String.valueOf(LocalDateTime.now()));
        return this.orderDao.insert(order);
    }

    @Override
    @Transactional
    public int edit(Order order) {
        Coach coach = this.coachDao.findById(order.getCoId());
        Sports sports = this.sportsDao.findById(order.getSpId());

        List<Order> orders =  this.orderDao.findByUserId(order.getUserId());
        Order oldOrder = null;
        for (Order o : orders) {
            if (order.getId().equals(o.getId())) {
                oldOrder = o;
                System.out.println(oldOrder.getId());
                break;
            }
        }
        if (oldOrder == null) {
            return -1;
        }
        if (isTimeOk(order)) {
            return -2;
        }

        Double coachPrice = 0.00;
        if (coach != null) {
            order.setCoach(coach);
            coachPrice = coach.getPrice();
        }
        order.setSports(sports);
        Double sportsPrice = sports.getPrice();
        //总花费
        Double payment = getPayment(order, sportsPrice, coachPrice);

        //设置提交时间
        order.setSubTime(String.valueOf(LocalDateTime.now()));
        order.setPayment(payment);
        return this.orderDao.update(order);
    }

    @Override
    public int cancel(Integer id) {
        return this.orderDao.cancel(id);
    }

    @Override
    public int deleteByIds(Integer[] ids) {
        return this.orderDao.deleteByIds(ids);
    }
}
