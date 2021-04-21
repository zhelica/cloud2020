package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

/**
 * @author lizhe
 * @date 2021-04-05 12:37
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/zk")
    public String  paymentzk()
    {
        return "spring cloud with zookeeper："+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
