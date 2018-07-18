package com.bkb.userbase.controller;


import com.bkb.userbase.entity.User;
import com.bkb.userbase.model.BaseResponse;
import com.bkb.userbase.util.JwtUtil;
import io.jsonwebtoken.Jwts;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.HashMap;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author bkb
 * @since 2018-07-18
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping(value = "/login")
    public BaseResponse<String> login(@RequestBody User user) {
        BaseResponse<String> response = new BaseResponse<>();
        if ("bkb".equals(user.getName())) {
            String jwt = JwtUtil.generateToken(user.getId());
            response.setCode(200);
            response.setData(jwt);
            response.setMsg("login success");
        } else {
            response.setCode(300);
            response.setData(null);
            response.setMsg("login failed");
        }
        return response;
    }
}

