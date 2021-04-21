package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentMapper;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lizhe
 * @date 2021-04-05 12:13
 */
@Service
public class PaymentServiceImpl implements IPaymentService {
    @Autowired
    private PaymentMapper paymentMapper;
    /**
     * 查询订单
     *
     * @param id 订单ID
     * @return 订单
     */
    @Override
    public Payment selectPaymentById(Long id)
    {
        return paymentMapper.selectPaymentById(id);
    }

    /**
     * 查询订单列表
     *
     * @param payment 订单
     * @return 订单
     */
    @Override
    public List<Payment> selectPaymentList(Payment payment)
    {
        return paymentMapper.selectPaymentList(payment);
    }

    /**
     * 新增订单
     *
     * @param payment 订单
     * @return 结果
     */
    @Override
    public int insertPayment(Payment payment)
    {
        return paymentMapper.insertPayment(payment);
    }

    /**
     * 修改订单
     *
     * @param payment 订单
     * @return 结果
     */
    @Override
    public int updatePayment(Payment payment)
    {
        return paymentMapper.updatePayment(payment);
    }

    /**
     * 批量删除订单
     *
     * @param ids 需要删除的订单ID
     * @return 结果
     */
    @Override
    public int deletePaymentByIds(Long[] ids)
    {
        return paymentMapper.deletePaymentByIds(ids);
    }

    /**
     * 删除订单信息
     *
     * @param id 订单ID
     * @return 结果
     */
    @Override
    public int deletePaymentById(Long id)
    {
        return paymentMapper.deletePaymentById(id);
    }
}
