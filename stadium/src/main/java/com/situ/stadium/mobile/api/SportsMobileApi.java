package com.situ.stadium.mobile.api;

import com.situ.stadium.mobile.model.SportsMobile;
import com.situ.stadium.service.SportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v2/sports")
public class SportsMobileApi {
    private SportsService sportsService;

    @Autowired
    public void setSportsMobileService(SportsService sportsService) {
        this.sportsService = sportsService;
    }

    @GetMapping
    public Map<String, Object> getSportsList() {
        List<SportsMobile> list = this.sportsService.findAll();
        return Map.of("success", true, "data", list);
    }
}
