package com.myooo.controller;


import com.alibaba.fastjson.JSONObject;
import com.myooo.util.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/rateLimiter")
public class RateLimiterController {

    @RequestMapping(value = "/limit", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage<String> limit(@RequestParam JSONObject req) {
        log.info("req {}", req.toJSONString());
        return ResponseMessage.success("成功");
    }
}
