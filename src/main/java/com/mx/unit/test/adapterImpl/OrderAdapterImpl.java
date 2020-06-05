package com.mx.unit.test.adapterImpl;

import com.mx.unit.test.adapter.OrderAdapter;
import com.mx.unit.test.vo.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author qiqi
 * @date 2020-05-31 15:27
 */
@Component
public class OrderAdapterImpl implements OrderAdapter {

    @Override
    public Order getOrderDetail(long orderNo){
        if(orderNo<=0){
            return  null;
        }
        Order order = new Order();
        order.setOrderNo(123456789L);
        order.setAmount(new BigDecimal(200));
        order.setTime(new Date());
        return order;
    }
    @Override
    public boolean isUser(long userId){
        return userId<=0;
    }
}
