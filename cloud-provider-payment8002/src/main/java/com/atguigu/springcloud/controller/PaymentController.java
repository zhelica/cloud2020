package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Autowired
    private DiscoveryClient discoveryClient;
    /**
     * 获取订单详细信息
     */
    @GetMapping(value = "/get/{id}")
    public CommonResult getInfo(@PathVariable("id") Long id)
    {
        Payment payment = paymentService.selectPaymentById(id);
        log.info("编号："+id+"，订单详细信息:"+payment);
        if (payment!=null){
            return new CommonResult(200,"查询成功,serverPort"+serverPort,payment);
        }else {
            return new CommonResult(200,"查询ID"+id+"为空,serverPort"+serverPort,null);
        }
    }

    /**
     * 新增订单
     */
    @PostMapping(value = "add")
    public CommonResult add(@RequestBody Payment payment)
    {
        int result = paymentService.insertPayment(payment);
        log.info("订单add："+result);
        if (result>0){
            return new CommonResult(200,"插入订单成功,serverPort"+serverPort,result);
        }else{
            return new CommonResult(444,"插入订单失败,serverPort"+serverPort,null);
        }
    }
    @GetMapping( "/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping( "/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
