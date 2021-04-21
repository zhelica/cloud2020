package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author lizhe
 * @date 2021-04-05 12:37
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;
    /**
     * 获取订单详细信息
     */
    @GetMapping(value = "/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Long id)
    {
        String result = paymentService.payment_ok(id);
        log.info("*****result:"+result);
        return result;
    }


    @GetMapping(value = "/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Long id)
    {
        String result = paymentService.payment_timeout(id);
        log.info("*****result:"+result);
        return result;
    }

    //服务熔断
    @GetMapping(value = "/hystrix/paymentCircuitBreaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("*****result:"+result);
        return result;
    }
}
