package com.mx.unit.test.presentation;

import com.mx.unit.test.adapter.OrderAdapter;
import com.mx.unit.test.vo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;


/**
 * @author qiqi
 * @date 2020-05-31 15:35
 */
@Component
public class OrderPresentation {

    @Autowired
    private OrderAdapter orderAdapter;

    /**
     * 获取详情（测试私有方法）
     *
     * @param orderNo
     * @return
     */
    private Order getOrder(long orderNo) {
        if (orderNo <= 0) {
            return null;
        }
        Order order = orderAdapter.getOrderDetail(orderNo);
        return order;
    }

    /**
     * 更新详情
     *
     * @param order
     */
    public void updateDetail(Order order, long userId) {
        if (order == null) {
            return;
        }
        boolean isTrue = orderAdapter.isUser(userId);
        if (isTrue) {
            order.setAmount(new BigDecimal(100));
            order.setOrderNo(123456L);
            order.setTime(new Date());
        }
    }

    /**
     * 测试静态方法
     *
     * @param orderNo
     * @return
     */
    public static boolean test(long orderNo) {
        return orderNo <= 0;
    }

    /**
     * 测试final修饰的方法
     *
     * @param orderNo
     * @return
     */
    public final boolean testFinal(long orderNo) {
        return orderNo <= 0;
    }

    public String testPublic() {
        return "hello";
    }
}
