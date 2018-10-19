package com.example.excelJson.controller;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.Date;

/**
 * @author ve
 * @date 2018/10/15 17:00
 */
@RestController
public class TestController {
    @RequestMapping("/rb")
    public Boolean doSome() {
        System.out.println("调用了什么什么,打印出什么" + new Date());
        return true;
    }
}