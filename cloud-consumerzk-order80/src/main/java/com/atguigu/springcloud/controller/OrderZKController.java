package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author lizhe
 * @date 2021-04-05 13:29
 */
@RestController
@RequestMapping("/consumer/payment")
@Slf4j
public class OrderZKController {
    //private final String PAYMENT_URL = "http://localhost:8001";
    private final String INVOKE_URL = "http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/zk")
    public String add(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
    }
}
