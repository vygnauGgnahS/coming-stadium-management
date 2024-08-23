package com.situ.stadium.api;

import com.github.pagehelper.PageInfo;
import com.situ.stadium.model.Sports;
import com.situ.stadium.model.search.PaginateInfo;
import com.situ.stadium.model.search.SportsSearchBean;
import com.situ.stadium.service.SportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "api/v1/sports", produces = "application/json;charset=utf-8")
public class SportsApi {
    private SportsService sportsService;

    @Autowired
    public void setSportsService(SportsService sportsService) {
        this.sportsService = sportsService;
    }

    @GetMapping
    public Map<String, Object> getSportsList(@RequestParam(defaultValue = "1") Integer pageNo,
                                             @RequestParam(defaultValue = "2147483647") Integer pageSize,
                                             SportsSearchBean ssb) {
        if (pageNo == null || pageNo < 1) {
            pageNo = 1;
        }
        if (pageSize == null || pageSize < 1) {
            pageSize = Integer.MAX_VALUE;
        }
        PaginateInfo pi = new PaginateInfo(pageNo, pageSize);
        List<Sports> list = this.sportsService.getSportsList(pi, ssb);
        PageInfo<Sports> pif = new PageInfo<>(list);
        Map<String, Object> pageInfo = Map.of("total", pif.getTotal(), "pageNo", pif.getPageNum(), "pageSize", pif.getPageSize());
        return Map.of("success", true, "data", list, "pi", pageInfo);
    }

    @PostMapping
    public Map<String, Object> addSports(@RequestBody Sports sports) {
        return Map.of("success", this.sportsService.add(sports) > 0);
    }

    @PutMapping
    public Map<String, Object> editSports(@RequestBody Sports sports) {
        return Map.of("success", this.sportsService.edit(sports) > 0);
    }

    @DeleteMapping
    public Map<String, Object> deleteByIds(@RequestBody Integer[] ids) {
        int rows = this.sportsService.deleteByIds(ids);
        return Map.of("success", rows > 0, "data", rows);
    }
}
