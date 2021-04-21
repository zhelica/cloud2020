package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.PaymentFeignHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author lizhe
 * @date 2021-04-14 19:55
 */
@Component
public class PaymentFeignHystrixServiceImpl implements PaymentFeignHystrixService {
    @Override
    public String payment_ok(Long id) {
        return "payment_ok：服务端繁忙，请稍后再试";
    }

    @Override
    public String payment_timeout(Long id) {
        return "payment_timeout：服务端繁忙，请稍后再试";
    }
}
