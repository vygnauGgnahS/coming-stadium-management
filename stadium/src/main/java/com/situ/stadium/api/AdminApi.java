package com.situ.stadium.api;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.situ.stadium.model.Admin;
import com.situ.stadium.model.search.AdminSearchBean;
import com.situ.stadium.model.search.PaginateInfo;
import com.situ.stadium.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/admins", produces = "application/json;charset=utf-8")
public class AdminApi {
    private AdminService adminService;

    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public Map<String, Object> getAdminList(@RequestParam(defaultValue = "1") Integer pageNo,
                                            @RequestParam(defaultValue = "2147483647") Integer pageSize,
                                            AdminSearchBean asb) {
        if (pageNo == null || pageNo < 1) {
            pageNo = 1;
        }
        if (pageSize == null || pageSize < 1) {
            pageSize = Integer.MAX_VALUE;
        }
        PaginateInfo pi = new PaginateInfo(pageNo, pageSize);
        List<Admin> list = this.adminService.getAdminList(pi, asb);
        PageInfo<Admin> pif = new PageInfo<>(list);
        Map<String, Object> pageInfo = Map.of("total", pif.getTotal(),
                "pageNo", pif.getPageNum(),
                "pageSize", pif.getPageSize());
        return Map.of("success", true, "data", list, "pi", pageInfo);
    }

    @PostMapping
    public Map<String, Object> addAdmin(@RequestBody Admin admin) {
        return Map.of("success", this.adminService.add(admin) > 0);
    }

    @PutMapping
    public Map<String, Object> editAdmin(@RequestBody Admin admin) {
        return Map.of("success", this.adminService.edit(admin) > 0);
    }

    @GetMapping("/find")
    public Map<String, Object> findById(@RequestParam Integer id) {
        return Map.of("success", true, "data", this.adminService.findById(id));
    }

    @DeleteMapping
    public Map<String, Object> deleteByIds(@RequestBody Integer[] ids) {
        int rows = this.adminService.deleteByIds(ids);
        return Map.of("success", rows > 0, "data", rows);
    }
}
