package com.example.iot_workflow_composor.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxController {

    @ResponseBody
    @RequestMapping("/hello")
    public JSONObject doPrintPostRequest(@RequestBody String jsonString) {
        
        System.out.println(jsonString);
        //convert jsonString to json object
        JSONObject json = JSON.parseObject(jsonString);

        System.out.println(json.get("class"));
        return json;
    }
}