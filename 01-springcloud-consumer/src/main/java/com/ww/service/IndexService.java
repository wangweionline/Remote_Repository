package com.ww.service;

import com.ww.entity.User;
import com.ww.fallBack.MyFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * FeignClient用于标记当前接口是一个Feign的声明式服务接口
 * */
@FeignClient(name = "01-springcloud-provider",fallbackFactory = MyFallBackFactory.class)
public interface IndexService {
    @RequestMapping("/test06")
    String test06();

    @RequestMapping("/test07")
    String test07(@RequestParam String name, @RequestParam Integer id);

    @RequestMapping("/test08")
    String test08(@RequestBody User user);
}
