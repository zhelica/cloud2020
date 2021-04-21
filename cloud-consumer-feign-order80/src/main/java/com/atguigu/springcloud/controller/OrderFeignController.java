package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author lizhe
 * @date 2021-04-05 13:29
 */
@RestController
@RequestMapping("/consumer/payment")
@Slf4j
public class OrderFeignController {
    //private final String PAYMENT_URL = "http://localhost:8001";
    private final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping( "/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return paymentFeignService.getInfo(id);
    }
    @GetMapping( "/feign/timeout")
    public String paymentFeignTimeout(){
        //客户端默认等待1秒钟
        return paymentFeignService.paymentFeignTimeout();
    }
}
