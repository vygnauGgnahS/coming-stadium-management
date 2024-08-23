package com.situ.stadium.api;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.situ.stadium.model.Area;
import com.situ.stadium.model.search.AreaSearchBean;
import com.situ.stadium.model.search.PaginateInfo;
import com.situ.stadium.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/areas", produces = "application/json;charset=utf-8")
public class AreaApi {
    private AreaService areaService;

    @Autowired
    public void setAreaService(AreaService areaService) {
        this.areaService = areaService;
    }

    @GetMapping
    public Map<String, Object> getAreaList(@RequestParam(defaultValue = "1") Integer pageNo,
                                           @RequestParam(defaultValue = "2147483647") Integer pageSize,
                                           AreaSearchBean asb) {
        if (pageNo == null || pageNo < 1) {
            pageNo = 1;
        }
        if (pageSize == null || pageSize < 1) {
            pageSize = Integer.MAX_VALUE;
        }
        PaginateInfo pi = new PaginateInfo(pageNo, pageSize);
        List<Area> list = this.areaService.getAreaList(pi, asb);
        PageInfo<Area> pif = new PageInfo<>(list);
        Map<String, Object> pageInfo = Map.of("total", pif.getTotal(), "pageNo", pif.getPageNum(), "pageSize", pif.getPageSize());
        return Map.of("success", true, "data", list, "pi", pageInfo);
    }

    @PostMapping
    public Map<String, Object> addArea(@RequestBody Area area) {
        return Map.of("success", this.areaService.add(area) > 0);
    }

    @GetMapping("/findAll")
    public Map<String, Object> findAll() {
        return Map.of("success", true, "data", this.areaService.findAll());
    }

    @PutMapping
    public Map<String, Object> editArea(@RequestBody Area area) {
        return Map.of("success", this.areaService.edit(area) > 0);
    }

    @DeleteMapping
    public Map<String, Object> deleteByIds(@RequestBody Integer[] ids) {
        int rows = this.areaService.deleteByIds(ids);
        return Map.of("success", rows > 0, "data", rows);
    }
}
