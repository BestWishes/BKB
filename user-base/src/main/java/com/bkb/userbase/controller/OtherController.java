package com.bkb.userbase.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "other")
public class OtherController {

    @GetMapping(value = "info")
    public String getInfo(@RequestHeader(value = "userId") String userId) {
        return userId;
    }
}
