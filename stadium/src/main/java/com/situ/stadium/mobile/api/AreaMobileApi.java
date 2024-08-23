package com.situ.stadium.mobile.api;

import com.situ.stadium.mobile.model.dto.UsableArea;
import com.situ.stadium.model.search.OrderSearchBean;
import com.situ.stadium.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v2/areas")
public class AreaMobileApi {
    private AreaService areaService;

    @Autowired
    public void setAreaService(AreaService areaService) {
        this.areaService = areaService;
    }

    @GetMapping
    public Map<String, Object> getUsableAreaList(OrderSearchBean osb) {
        List<UsableArea> list = this.areaService.getUsableArea(osb);

        return Map.of("success", true, "data", list);
    }
}
