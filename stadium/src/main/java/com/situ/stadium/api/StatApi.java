package com.situ.stadium.api;

import com.situ.stadium.service.StatService;
import com.situ.stadium.util.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/stats", produces = "application/json;charset=utf-8")
public class StatApi {
    private StatService statService;

    @Autowired
    public void setStatService(StatService statService) {
        this.statService = statService;
    }

    @GetMapping("/sportsTypeOfOrders")
    public Map<String, Object> getSportsTypeOfOrders() {
        List<Tuple.KV<String, Long>> list = this.statService.statOfSportsTypeOfOrders();
        return Map.of("success", true, "data", list);
    }

    @GetMapping("/coachOfOrders")
    public Map<String, Object> getCoachOfOrders() {
        List<Tuple.KV<String, Long>> list = this.statService.statOfCoachOfOrders();
        return Map.of("success", true, "data", list);
    }
}
