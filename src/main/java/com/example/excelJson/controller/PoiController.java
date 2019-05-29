package com.example.excelJson.controller;

import com.sun.deploy.net.HttpResponse;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ve
 * @date 2018/10/15 17:00
 */
@RestController
public class PoiController {
    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public Object readExcel(@NotBlank @RequestParam("url") String url) throws IOException {
        File file = new File(url);
        return PoiUtil.readExcel(file);
    }

    /**
     * 导出excel.xlsx
     * @param res
     * @throws IOException
     */
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void export(HttpServletResponse res) throws IOException {
        // demo data
        List<List> arrayLists = new ArrayList<>();
        arrayLists.add(Stream.of("number", "name", "age").collect(Collectors.toList()));
        arrayLists.add(Stream.of("1", "张三", 25).collect(Collectors.toList()));
        arrayLists.add(Stream.of("2", "李四", 30).collect(Collectors.toList()));
        PoiUtil.writeIntoResponse(res, arrayLists);
    }
}