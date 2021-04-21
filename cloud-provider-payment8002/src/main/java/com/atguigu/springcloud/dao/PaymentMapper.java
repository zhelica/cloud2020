package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lizhe
 * @date 2021-04-05 12:04
 */
@Mapper
public interface PaymentMapper {
    /**
     * 查询订单
     *
     * @param id 订单ID
     * @return 订单
     */
    public Payment selectPaymentById(Long id);

    /**
     * 查询订单列表
     *
     * @param payment 订单
     * @return 订单集合
     */
    public List<Payment> selectPaymentList(Payment payment);

    /**
     * 新增订单
     *
     * @param payment 订单
     * @return 结果
     */
    public int insertPayment(Payment payment);

    /**
     * 修改订单
     *
     * @param payment 订单
     * @return 结果
     */
    public int updatePayment(Payment payment);

    /**
     * 删除订单
     *
     * @param id 订单ID
     * @return 结果
     */
    public int deletePaymentById(Long id);

    /**
     * 批量删除订单
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePaymentByIds(Long[] ids);
}
