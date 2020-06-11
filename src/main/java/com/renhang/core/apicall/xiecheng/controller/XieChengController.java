package com.renhang.core.apicall.xiecheng.controller;

import com.renhang.core.apicall.xiecheng.service.XieChengService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class XieChengController {


    @Autowired
    XieChengService xieChengService;

    @RequestMapping
    public String query(){
        try {

        }catch (Exception e){

        }
        return null;
    }
}
