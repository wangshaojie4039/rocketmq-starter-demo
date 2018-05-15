package com.aqlu.rocketmq.demo.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author wangshaojie
 */
@Data
@AllArgsConstructor
public class OrderPaidEvent implements Serializable {
    private String orderId;

    private String action;
}
