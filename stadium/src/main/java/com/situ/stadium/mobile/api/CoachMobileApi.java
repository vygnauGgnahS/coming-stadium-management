package com.situ.stadium.mobile.api;

import com.situ.stadium.mobile.model.dto.UsableCoach;
import com.situ.stadium.model.Coach;
import com.situ.stadium.model.search.OrderSearchBean;
import com.situ.stadium.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v2/coaches")
public class CoachMobileApi {
    private CoachService coachService;

    @Autowired
    public void setCoachService(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping
    public Map<String, Object> getUsableCoach(OrderSearchBean obs) {
        List<UsableCoach> list = this.coachService.getUsableCoach(obs);
        return Map.of("success", true, "data", list);
    }

}
