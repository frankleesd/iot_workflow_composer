package com.example.iot_workflow_composor.controller;

import java.text.ParseException;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.iot_workflow_composor.model.CKRService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonController {

    @Resource
    private CKRService ckrService;

    @ResponseBody
    @RequestMapping("/hello")
    public String JsonOperation(@RequestBody String jsonString) throws ParseException {

        // System.out.println(jsonString);

        // convert jsonString to json object
        JSONObject json = JSON.parseObject(jsonString);
        JSONArray resultJsonArray = new JSONArray();

        String ahpResult = "";
        String configResult = "";

        JSONArray nodeDataArray = json.getJSONArray("nodeDataArray");

        System.out.println(nodeDataArray);

        if (nodeDataArray.size() > 0) {
            for (int i = 0; i < nodeDataArray.size(); i++) {
                JSONObject jsonObj = nodeDataArray.getJSONObject(i);
                JSONObject jsonObjOne = new JSONObject();
                if (jsonObj.getString("category").equals("Comment")) {
                } else {
                    AHP ahp = new AHP();
                    ahpResult = ahp.AHPOperation(jsonObj);
                    configResult = ckrService.findCKRByIndex(ahpResult).getConfig();

                    // made resultJsonObj
                    jsonObjOne.put("category", jsonObj.getString("category"));
                    jsonObjOne.put("text", jsonObj.getString("text"));
                    jsonObjOne.put("index", ahpResult);
                    jsonObjOne.put("config", JSON.parse(configResult));

                    // made resultJsonArray
                    resultJsonArray.add(jsonObjOne);

                }
                // System.out.println(resultJsonObj);
                // System.out.println(configResult);
                // System.out.println(jsonObj.get("category"));
            }
        }

        // System.out.println(json.get("class"));
        // json = JSON.parseObject(ahpResult);

        // System.out.println(json);

        return JSONArray.toJSONString(resultJsonArray);
    }
}