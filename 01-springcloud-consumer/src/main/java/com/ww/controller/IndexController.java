package com.ww.controller;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ww.entity.User;
import com.ww.hystrix.MyHystrix;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class IndexController {

    @Resource
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "error")
    @RequestMapping("/test")
    public String test(){
        ResponseEntity<User> result = restTemplate.getForEntity("http://01-SPRINGCLOUD-PROVIDER/getForEntity", User.class);
        return "服务消费者："+result.getBody();
    }

    @HystrixCommand(fallbackMethod = "error")
    @RequestMapping("/test01")
    public String test01(){
        ResponseEntity<List> result = restTemplate.getForEntity("http://01-SPRINGCLOUD-PROVIDER/getForEntity01", List.class);
        List<User> body = result.getBody();

        return "服务消费者："+result.getBody();
    }

    @HystrixCommand(fallbackMethod = "error")
    @RequestMapping("/test02")
    public String test02(){


        String url="http://01-SPRINGCLOUD-PROVIDER/getForEntity02?id={id}&name={name}";
        Map<String,Object> map = new HashMap<>();
        map.put("id",01);
        map.put("name","ls");
        ResponseEntity<User> result = restTemplate.getForEntity(url, User.class,map);

        return "服务消费者："+result.getBody();
    }

    @HystrixCommand(fallbackMethod = "error")
    @RequestMapping("/test03")
    public String test03(){
        String url="http://01-SPRINGCLOUD-PROVIDER/postForEntity03";
        LinkedMultiValueMap param = new LinkedMultiValueMap();
        param.add("id",01);
        param.add("name","ls");
        ResponseEntity<User> result = restTemplate.postForEntity(url,param,User.class);

        return "服务消费者："+result.getBody();
    }

    public String error(){
        return "error";
    }

    @HystrixCommand(fallbackMethod = "error",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })

    @RequestMapping("/test04")
    public String test04(){
        ResponseEntity<User> result = restTemplate.getForEntity("http://01-SPRINGCLOUD-PROVIDER/getForEntity04", User.class);
        return "服务消费者："+result.getBody();
    }

    @HystrixCommand(fallbackMethod = "error")
    @RequestMapping("/test05")
    public String test05(){
        MyHystrix myHystrix = new MyHystrix(
                com.netflix.hystrix.HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("")),
                restTemplate,"http://01-SPRINGCLOUD-PROVIDER/getForEntity05");
        return "服务消费者："+(String)myHystrix.execute();
    }

    @RequestMapping("/test09")
    public String test09(){
        User user = restTemplate.getForObject("http://01-SPRINGCLOUD-ZUUL/api-zuul/test09?token=123", User.class);
        return "服务消费者："+user.getId()+","+user.getName();
    }
}
