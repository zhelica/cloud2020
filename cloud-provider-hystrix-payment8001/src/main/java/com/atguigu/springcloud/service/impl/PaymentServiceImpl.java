package com.atguigu.springcloud.service.impl;
import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.service.IPaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author lizhe
 * @date 2021-04-05 12:13
 */
@Service
public class PaymentServiceImpl implements IPaymentService {
    /**
     * 正常访问
     *
     * @param id 订单ID
     * @return 订单
     */
    //服务降级
    @Override
    public String payment_ok(Long id)
    {
        return "payment_ok,id="+id+"\t"+"正常访问";
    }
    /**
     * 超时访问
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    @Override
    public String payment_timeout(Long id)
    {
//        try {
//            TimeUnit.MILLISECONDS.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        int age = 10/0;
        return "payment_timeout,id="+id+"\t"+"未发生异常";
    }
    /**
     * 降级接口
     */
    @Override
    public String paymentInfo_TimeoutHandler(Long id){
        return "paymentInfo_TimeoutHandler,id="+id+"\t"+"系统繁忙，请稍后再试";
    }
    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "5000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率多少次关闭
    })
    @Override
    public String paymentCircuitBreaker(Integer id) {
        if(id<0){
            throw new RuntimeException("*******id 不能小于0");
        }
        String serialNumber = IdUtil.simpleUUID();
        return "paymentCircuitBreaker调用成功，流水号："+serialNumber;
    }
    @Override
    public String paymentCircuitBreaker_fallback(Integer id) {
        return "id 不能为负数，请稍后再试，"+id;
    }
}
