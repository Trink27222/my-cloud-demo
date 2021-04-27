package com.trink.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/clent")
public class TestConfigController {
    @Value("${user.name}") //获取配置文件中对应属性的值
    private String userName;


    @GetMapping("/getName")
    public String getUserName() {
        return userName;
    }
    
    @PostMapping("/postName")
    public String postName(@RequestBody Map<String,String> param){
        return param.get("name") + "   " + userName;
    }
}