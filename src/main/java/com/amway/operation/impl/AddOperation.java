package com.amway.operation.impl;

import java.math.BigDecimal;

/**
 * @author: tang
 * @date: 2023/12/14
 * @description: 加法操作实现类
 */
public class AddOperation extends AbstractOperation {

    public AddOperation(BigDecimal original, BigDecimal operand) {
        super(original, operand);
    }

    @Override
    public BigDecimal execute() {
        return original.add(operand);
    }

}
