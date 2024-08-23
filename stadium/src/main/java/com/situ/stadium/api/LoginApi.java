package com.situ.stadium.api;

import com.situ.stadium.model.Admin;
import com.situ.stadium.model.dto.Account;
import com.situ.stadium.service.AdminService;
import com.situ.stadium.util.JwtUtils;
import com.wf.captcha.SpecCaptcha;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.jasypt.util.password.PasswordEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/login", produces = "application/json;charset=utf-8")
public class LoginApi {
    @Value("${jwt.secret.key}")
    private String jwtSecretKey;

    //密码加密
    private static final PasswordEncryptor encryptor = new StrongPasswordEncryptor();

    private AdminService adminService;

    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    public Map<String, Object> login(@RequestBody Account account) {
        if (!StringUtils.hasText(account.getUsername())) {
            return Map.of("success", false, "msg", "用户名不可为空");
        }

        Admin admin = this.adminService.findByUsername(account.getUsername());
        if (admin == null) {
            return Map.of("success", false, "msg", "无此用户");
        }

        if (!encryptor.checkPassword(account.getPassword(), admin.getPassword())) {
            return Map.of("success", false, "msg", "密码错误");
        }

        Map<String, Object> data = Map.of("username", account.getUsername());
        String jwt = JwtUtils.encode(account.getUsername(), data, jwtSecretKey);

        return Map.of("success", true, "admin", admin, "jwt", jwt);
    }

    @GetMapping("/captcha")
    public void captcha(HttpServletResponse resp, HttpSession session) throws IOException {
        //生成验证码
        SpecCaptcha cap = new SpecCaptcha(120, 35, 4);

        //设置响应头
        resp.setContentType("image/gif");
        resp.setHeader("Pragma", "No-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", 0);

        //将答案存储到session中
        session.setAttribute("captcha", cap.text().toLowerCase());
        cap.out(resp.getOutputStream());
    }
}
