package com.amway.operation.impl;

import java.math.BigDecimal;

/**
 * @author: tang
 * @date: 2023/12/14
 * @description: 减法操作实现类
 */
public class SubtractOperation extends AbstractOperation {

    public SubtractOperation(BigDecimal original, BigDecimal operand) {
        super(original, operand);
    }

    @Override
    public BigDecimal execute() {
        return original.subtract(operand);
    }

}
