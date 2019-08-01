package com.example.excelJson.controller;

import com.example.excelJson.entry.AreaEntry;
import io.swagger.annotations.Api;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ve
 * @date 2018/10/15 17:00
 */
@RestController
@Api(value = "poi-controller", tags = "表格")
@Validated
public class PoiController {

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping(value = "/read")
    public void readExcel(@NotBlank @RequestParam("url") String url) throws IOException {
        File file = new File(url);
//        return PoiUtil.readExcel(file);
        ArrayList<ArrayList<Object>> lists = PoiUtil.readExcel(file);
        // 去除首航标题
        lists.remove(0);
        lists.forEach(objects -> {
            mongoTemplate.save(
                    new AreaEntry(String.valueOf(objects.get(0)),
                            String.valueOf(objects.get(1)),
                            String.valueOf(objects.get(2))));
        });
    }

    /**
     * 导出excel.xlsx
     *
     * @param res
     * @throws IOException
     */
    @GetMapping(value = "/export")
    public void export(HttpServletResponse res) throws IOException {
        // demo data
        List<List> arrayLists = new ArrayList<>();
        arrayLists.add(Stream.of("number", "name", "age").collect(Collectors.toList()));
        arrayLists.add(Stream.of("1", "张三", 25).collect(Collectors.toList()));
        arrayLists.add(Stream.of("2", "李四", 30).collect(Collectors.toList()));
        PoiUtil.writeIntoResponse(res, arrayLists);
    }

}