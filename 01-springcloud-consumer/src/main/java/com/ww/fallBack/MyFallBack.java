package com.ww.fallBack;

import com.ww.entity.User;
import com.ww.service.IndexService;
import org.springframework.stereotype.Component;

@Component
public class MyFallBack implements IndexService {
    @Override
    public String test06() {
        return "请稍后再试";
    }

    @Override
    public String test07(String name, Integer id) {
        return "请稍后再试";
    }

    @Override
    public String test08(User user) {
        return "请稍后再试";
    }
}
