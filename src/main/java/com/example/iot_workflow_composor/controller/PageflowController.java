package com.example.iot_workflow_composor.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageflowController {

    /**
     * 本地访问内容地址 ：http://localhost:8080/pageflow
     * @param map
     * @return
     */
    @RequestMapping("/pageflow")
    public String pageflowHtml(HashMap<String, Object> map) {
        return "/pageflow";
    }
}