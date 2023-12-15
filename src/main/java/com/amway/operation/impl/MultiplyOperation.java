package com.amway.operation.impl;

import java.math.BigDecimal;

/**
 * @author: tang
 * @date: 2023/12/14
 * @description: 乘法操作实现类
 */
public class MultiplyOperation extends AbstractOperation {

    public MultiplyOperation(BigDecimal original, BigDecimal operand) {
        super(original, operand);
    }

    @Override
    public BigDecimal execute() {
        return original.multiply(operand);
    }

}
