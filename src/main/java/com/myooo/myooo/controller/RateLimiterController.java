package com.myooo.myooo.controller;


import com.alibaba.fastjson.JSONObject;
import com.myooo.myooo.controller.model.UserInfo;
import com.myooo.myooo.controller.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/test")
public class RateLimiterController {

    @RequestMapping(value = "/oom", method = RequestMethod.POST)
    @ResponseBody
    public void limit(@RequestBody JSONObject req) {
        List<UserInfo> list = new ArrayList<>();
        CommonResult<String> succcccccc = CommonResult.success("succcccccc");
    }


    @RequestMapping(value = "/jconsole", method = RequestMethod.GET)
    @ResponseBody
    public void jconsole(@RequestParam Integer count) {
        List<UserInfo> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new UserInfo());
        }
    }
}

