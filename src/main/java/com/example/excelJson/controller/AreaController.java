package com.example.excelJson.controller;

import com.example.excelJson.entry.AreaEntry;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ve
 * @date 2019/7/30 14:40
 */
@RequestMapping("/area")
@RestController
public class AreaController {

    @Autowired
    MongoTemplate mongoTemplate;

    @ApiOperation("查询全部省份")
    @GetMapping("/province")
    public List<AreaEntry> provinces() {
        return mongoTemplate.find(Query.query(Criteria.where(AreaEntry.FIELD_PARENT_ID).is("1")), AreaEntry.class);
    }

    @ApiOperation("通过省份id查询市")
    @GetMapping("/city")
    public List<AreaEntry> citys(@RequestParam("provinceId") @NotBlank String provinceId) {
        return mongoTemplate.find(Query.query(Criteria.where(AreaEntry.FIELD_PARENT_ID).is(provinceId)), AreaEntry.class);
    }

    @ApiOperation("通过市id查询所有区")
    @GetMapping("/county")
    public List<AreaEntry> counties(@RequestParam("cityId") @NotBlank String cityId) {
        return mongoTemplate.find(Query.query(Criteria.where(AreaEntry.FIELD_PARENT_ID).is(cityId)), AreaEntry.class);
    }
}
