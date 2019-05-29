package com.example.excelJson.controller;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

/**
 * @author ve
 * @date 2018/10/15 17:00
 */
@RestController
public class ReadController {
    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public Object readExcel(@NotBlank @RequestParam("url") String url) throws IOException, InvalidFormatException {
        File file = new File(url);
            return PoiUtil.readExcel(file);
    }
}