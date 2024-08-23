package com.situ.stadium.mobile.api;

import com.situ.stadium.model.Admin;
import com.situ.stadium.model.User;
import com.situ.stadium.model.dto.Account;
import com.situ.stadium.service.UserService;
import com.situ.stadium.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v2/login")
public class UserLogin {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Map<String, Object> login(@RequestBody Account account) {
        if (!StringUtils.hasText(account.getUsername())) {
            return Map.of("success", false, "msg", "用户名不可为空");
        }

        User user = this.userService.findByUsername(account.getUsername());
        if (user == null) {
            Map<String, Object> res = Map.of("success", false, "msg", "无此用户");
            return Map.of("success", true, "res", res);
        }

        Map<String, Object> res = Map.of("success", true, "data", user);

        return Map.of("success", true, "res", res);
    }
}
