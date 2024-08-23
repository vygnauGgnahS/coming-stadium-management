package com.situ.stadium.api;

import com.github.pagehelper.PageInfo;
import com.situ.stadium.model.User;
import com.situ.stadium.model.search.PaginateInfo;
import com.situ.stadium.model.search.UserSearchBean;
import com.situ.stadium.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/users", produces = "application/json;charset=utf-8")
public class UserApi {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Map<String, Object> getUserList(@RequestParam(defaultValue = "1") Integer pageNo,
                                           @RequestParam(defaultValue = "2147483647") Integer pageSize,
                                           UserSearchBean usb) {
        if (pageNo == null || pageNo < 1) {
            pageNo = 1;
        }
        if (pageSize == null || pageSize < 1) {
            pageSize = Integer.MAX_VALUE;
        }
        PaginateInfo pi = new PaginateInfo(pageNo, pageSize);
        List<User> list = this.userService.getUserList(pi, usb);
        PageInfo<User> pif = new PageInfo<>(list);
        Map<String, Object> pageInfo = Map.of("total", pif.getTotal(),
                "pageNo", pif.getPageNum(),
                "pageSize", pif.getPageSize());

        return Map.of("success", true, "data", list, "pi", pageInfo);
    }

    @PostMapping
    public Map<String, Object> addUser(@RequestBody User user) {
        return Map.of("success", this.userService.add(user) > 0);
    }

    @PutMapping
    public Map<String, Object> editUserInfo(@RequestBody User user) {
        return Map.of("success", this.userService.edit(user) > 0);
    }

    @GetMapping("/one")
    public Map<String, Object> getUserById(@RequestBody Integer id) {
        return Map.of("success", true, "data", this.userService.getUserById(id));
    }

    @DeleteMapping
    public Map<String, Object> deleteUserByIds(@RequestBody Integer[] ids) {
        int rows = this.userService.deleteByIds(ids);
        return Map.of("success", rows > 0, "data", rows);
    }

}
