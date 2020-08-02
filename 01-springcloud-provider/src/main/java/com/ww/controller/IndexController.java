package com.ww.controller;

import com.ww.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IndexController {

    @RequestMapping("/getForEntity")
    public Object test(){
       User user = new User(001,"zs");
       System.out.println(10/0);
       return user;
    }

    @RequestMapping("/getForEntity01")
    public Object test01(){
        List<User> list = new ArrayList<>();
        User user = new User(001,"zs");
        User user01 = new User(002,"ls");
        User user02 = new User(003,"ww");
        list.add(user);
        list.add(user01);
        list.add(user02);
        return list;
    }
    @RequestMapping("/getForEntity02")
    public Object test02(User user){
        user.setName("zzzzzz");
        return user;
    }

    @RequestMapping("/postForEntity03")
    public Object test03(User user){
        user.setName("zz");
        return user;
    }

    @RequestMapping("/getForEntity04")
    public Object test04(){
        User user = new User(001,"zs");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return user;
    }
    @RequestMapping("/getForEntity05")
    public Object test05(){
        User user = new User(001,"zs");
        System.out.println(10/0);
        return user;
    }

    @RequestMapping("/test06")
    public Object test06(){
        User user = new User(001,"zs");
        System.out.println(10/0);
        return user;
    }

   @RequestMapping("/test07")
    public Object test07(String name,Integer id){
        return "name="+name+",id="+id;
    }

    @RequestMapping("/test08")
    public Object test08(@RequestBody User user){
        return "name="+user.getName()+",id="+user.getId();
    }

    @RequestMapping("/test09")
    public Object test09(){
        User user = new User(001,"zs");
        return user;
    }

}
