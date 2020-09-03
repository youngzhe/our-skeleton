/**
 * Copyright (C), 2015-2020
 * FileName: DemoController
 * Author:   yangz
 * Date:     2020/8/21 22:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.our.controller;

import com.our.common.base.Result;
import com.our.common.base.Results;
import com.our.repository.entity.Sys;
import com.our.repository.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/skeleton")
public class DemoController {

    @Autowired
    private SysService sysService;

    @GetMapping("/test")
    public Result getTest(String param){
        HashMap<String, String> map = new HashMap<>();
        map.put("test",param);
        List<Sys> allSys = sysService.getAllSys();
        return Results.successWithData(allSys);
    }

    @GetMapping("/define/exception")
    public Result getDefineException(String param){
        HashMap<String, String> map = new HashMap<>();
        map.put("test",param);
        List<Sys> allSys = sysService.getAllSys();
        return  Results.successWithData(map);
    }

    @GetMapping("/exception")
    public Result getException(String param){
        HashMap<String, String> map = new HashMap<>();
        map.put("test",param);
        List<Sys> allSys = sysService.getAllSys();
        return Results.successWithData(map);
    }

}
