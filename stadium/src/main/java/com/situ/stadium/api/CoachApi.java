package com.situ.stadium.api;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.situ.stadium.model.Coach;
import com.situ.stadium.model.search.CoachSearchBean;
import com.situ.stadium.model.search.PaginateInfo;
import com.situ.stadium.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/coaches", produces = "application/json;charset=utf-8")
public class CoachApi {
    private CoachService coachService;

    @Autowired
    public void setCoachService(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping
    public Map<String, Object> getCoachList(@RequestParam(defaultValue = "1") Integer pageNo,
                                            @RequestParam(defaultValue = "2147483647") Integer pageSize,
                                            CoachSearchBean csb) {
        if (pageNo == null || pageNo < 1) {
            pageNo = 1;
        }
        if (pageSize == null || pageSize < 1) {
            pageSize = Integer.MAX_VALUE;
        }
        PaginateInfo pi = new PaginateInfo(pageNo, pageSize);
        List<Coach> list = this.coachService.getCoachList(pi, csb);
        PageInfo<Coach> pif = new PageInfo<>(list);
        Map<String, Object> pageInfo = Map.of("total", pif.getTotal(),
                "pageNo", pif.getPageNum(),
                "pageSize", pif.getPageSize());
        return Map.of("success", true, "data", list, "pi", pageInfo);
    }

    @PostMapping
    public Map<String, Object> addCoach(@RequestBody Coach coach) {
        return Map.of("success", this.coachService.add(coach) > 0);
    }

    @PutMapping
    public Map<String, Object> editCoach(@RequestBody Coach coach) {
        return Map.of("success", this.coachService.edit(coach) > 0);
    }

    @GetMapping("/find")
    public Map<String, Object> findById(@RequestParam Integer id) {
        return Map.of("success", true, "data", this.coachService.findById(id));
    }

    @DeleteMapping
    public Map<String, Object> deleteByIds(@RequestBody Integer[] ids) {
        int rows = this.coachService.deleteByIds(ids);
        return Map.of("success", rows > 0, "data", rows);
    }

}
