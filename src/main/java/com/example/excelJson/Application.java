package com.example.excelJson;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ve
 * @date 2018/10/15 17:05
 */

//@EnableZuulProxy
//@EnableEurekaServer
@SpringBootApplication
public class Application implements CommandLineRunner {

    private static DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
    }

}
