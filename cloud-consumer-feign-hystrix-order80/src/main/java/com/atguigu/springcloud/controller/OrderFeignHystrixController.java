package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
public class OrderFeignHystrixController {
    @Autowired
    private PaymentFeignHystrixService hystrixService;

    @GetMapping( "/payment_ok/{id}")
    public String getPayment(@PathVariable("id") Long id){
        return hystrixService.payment_ok(id);
    }
    /**
     * 超时访问
     */
    @GetMapping( "/payment_timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
//    })
    public String payment_timeout(@PathVariable("id")Long id)
    {
//        int age = 10/0;
        return hystrixService.payment_timeout(id);
    }
    /**
     * 兜底接口
     */
    public String paymentInfo_TimeoutHandler(Long id){
        return "消费端80 paymentInfo_TimeoutHandler:对方异常，请稍后再试"+id+"\t"+"，兜底访问";
    }
}
