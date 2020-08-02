package com.ww.controller;

import com.ww.entity.User;
import com.ww.service.IndexService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class IndexController1 {
    @Resource
    private IndexService indexService;

    @RequestMapping("/test06")
    public String test() {
        String result = indexService.test06();
        return "1111111111+"+result;
    }

    @RequestMapping("/test07")
    public String test07() {
        String result = indexService.test07("ls",1001);
        return "------"+result;
    }

    @RequestMapping("/test08")
    public String test08() {

        User user = new User(1001,"str");
        String result = indexService.test08(user);
        return "------"+result;
    }
}

