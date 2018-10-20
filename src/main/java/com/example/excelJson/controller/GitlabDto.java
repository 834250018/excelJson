package com.example.excelJson.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * @author ve
 * @date 2018/10/15 17:00
 */

public class GitlabDto {

    private String object_kind;

    private String event_name;

    private String before;

    private String after;

    private String ref;

    private String checkout_sha;

    private String message;

    private String user_id;

    private String user_name;

    private String user_email;

    private String user_avatar;

    private String project_id;

    private String project;

    public GitlabDto() {

    }
}