package com.myooo.myooo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class MyoooApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyoooApplication.class, args);
        log.info("ooo start 启动啦～");
    }

}
