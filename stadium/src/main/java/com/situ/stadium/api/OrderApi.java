package com.situ.stadium.api;

import com.github.pagehelper.PageInfo;
import com.situ.stadium.model.Order;
import com.situ.stadium.model.search.OrderSearchBean;
import com.situ.stadium.model.search.PaginateInfo;
import com.situ.stadium.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/orders", produces = "application/json;charset=utf-8")
public class OrderApi {
    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public Map<String, Object> getOrderList(@RequestParam(defaultValue = "1") Integer pageNo,
                                            @RequestParam(defaultValue = "2147483647") Integer pageSize,
                                            OrderSearchBean osb) {
        if (pageNo == null || pageNo < 1) {
            pageNo = 1;
        }
        if (pageSize == null || pageSize < 1) {
            pageSize = Integer.MAX_VALUE;
        }
        System.out.println(osb.getTimeFrom() +  " - " + osb.getTimeTo());
        PaginateInfo pi = new PaginateInfo(pageNo, pageSize);
        List<Order> list = orderService.getOrderList(pi, osb);
        PageInfo<Order> pif = new PageInfo<>(list);
        Map<String, Object> pageInfo = Map.of("total", pif.getTotal(), "pageNo", pif.getPageNum(), "pageSize", pif.getPageSize());
        return Map.of("success", true, "data", list, "pi", pageInfo);
    }

    @PostMapping
    public Map<String, Object> submitOrder(@RequestBody Order order) {
        int num = this.orderService.add(order);
        if (num > 0) {
            return Map.of("success", true);
        } else if (num == 0) {
            return Map.of("success", false, "msg", "提交失败，请重试");
        } else if (num == -1) {
            return Map.of("success", false, "msg", "仍有未完成订单，请修改或取消后操作");
        } else if (num == -2) {
            return Map.of("success", false, "msg", "时间冲突");
        }
        return Map.of("success", false, "msg", "未知错误");
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

    @DeleteMapping
    public Map<String, Object> deleteByIds(@RequestBody Integer[] ids) {
        int rows = this.orderService.deleteByIds(ids);
        return Map.of("success", rows > 0, "data", rows);
    }
}
