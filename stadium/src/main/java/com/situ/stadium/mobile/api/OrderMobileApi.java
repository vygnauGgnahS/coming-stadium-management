package com.situ.stadium.mobile.api;

import com.situ.stadium.model.Order;
import com.situ.stadium.model.search.OrderSearchBean;
import com.situ.stadium.model.search.PaginateInfo;
import com.situ.stadium.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v2/orders", produces = "application/json;charset=utf-8")
public class OrderMobileApi {
    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public Map<String, Object> getOrderList(OrderSearchBean osb) {
        PaginateInfo pi = new PaginateInfo(1, Integer.MAX_VALUE);
        List<Order> list = this.orderService.getOrderList(pi, osb);
        return Map.of("success", true, "data", list);
    }

    @PostMapping
    public Map<String, Object> submitOrder(@RequestBody Order order) {
        System.out.println(order.getSpId());
        System.out.println(order.getUserId());
        System.out.println(order.getCoId());
        System.out.println(order.getSpaId());
        System.out.println("haohfoashid");

        int num = this.orderService.add(order);
        if (num > 0) {
            Map<String, Object> res = Map.of("success", true, "msg", "提交成功");
            return Map.of("success", true, "res", res);
        } else if (num == 0) {
            Map<String, Object> res = Map.of("success", false, "msg", "提交失败，请重试");
            return Map.of("success", true, "res", res);
        } else if (num == -1) {
            Map<String, Object> res = Map.of("success", false, "msg", "仍有未完成订单，请修改或取消后操作");
            return Map.of("success", true, "res", res);
        } else if (num == -2) {
            Map<String, Object> res = Map.of("success", false, "msg", "时间冲突");
            return Map.of("success", true, "res", res);
        }
        Map<String, Object> res = Map.of("success", false, "msg", "未知错误");
        return Map.of("success", true, "res", res);
    }

    @PutMapping
    public Map<String, Object> editOrder(@RequestBody Order order) {
        int num = this.orderService.edit(order);
        if (num > 0) {
            return Map.of("success", true);
        } else if (num == 0) {
            return Map.of("success", false, "msg", "提交失败，请重试");
        } else if (num == -1) {
            return Map.of("success", false, "msg", "查找错误");
        } else if (num == -2) {
            return Map.of("success", false, "msg", "时间冲突");
        }
        return Map.of("success", false, "msg", "未知错误");
    }

    @PutMapping("/cancel")
    public Map<String, Object> cancelOrder(@RequestBody Integer orderId) {
        int rows = this.orderService.cancel(orderId);
        return Map.of("success", rows > 0);
    }



}
