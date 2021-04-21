package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

import java.util.List;

/**
 * @author lizhe
 * @date 2021-04-05 12:13
 */
public interface IPaymentService {
    /**
     * 查询订单
     *
     * @param id 订单ID
     * @return 订单
     */
    public String payment_ok(Long id);
    public String payment_timeout(Long id);
    public String paymentInfo_TimeoutHandler(Long id);
    public String paymentCircuitBreaker(Integer id);
    public String paymentCircuitBreaker_fallback(Integer id);
}
