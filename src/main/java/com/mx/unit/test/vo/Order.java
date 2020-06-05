package com.mx.unit.test.vo;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * @author qiqi
 * @date 2020-05-31 15:23
 */
@Data
public class Order {

    private long orderNo;
    private BigDecimal amount;
    private Date time;
}
