package com.example.iot_workflow_composor.controller;

import java.text.ParseException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonController {

    @ResponseBody
    @RequestMapping("/hello")
    public JSONObject JsonOperation(@RequestBody String jsonString) throws ParseException {
        
        //System.out.println(jsonString);

        //convert jsonString to json object
        JSONObject json = JSON.parseObject(jsonString);

        JSONArray nodeDataArray = json.getJSONArray("nodeDataArray");

        System.out.println(nodeDataArray);

        if(nodeDataArray.size() > 0)
        {
            for(int i = 0; i < nodeDataArray.size(); i++)
            {
                JSONObject jsonObj = nodeDataArray.getJSONObject(i);
                
                AHP ahp = new AHP();
                String ahpResult = ahp.AHPOperation(jsonObj);

                System.out.println(jsonObj.get("category"));
            }    
        }

        //System.out.println(json.get("class"));
        
        return json;
    }
}