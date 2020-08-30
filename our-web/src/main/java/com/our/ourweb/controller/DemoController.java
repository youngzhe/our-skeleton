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
package com.our.ourweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/test")
    public Object getTest(String param){
        HashMap<String, String> map = new HashMap<>();
        map.put("test",param);
        return map;
    }
}
