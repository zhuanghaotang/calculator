package com.amway.operation.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * @author: tang
 * @date: 2023/12/14
 * @description: 除法操作实现类
 */
public class DivideOperation extends AbstractOperation {

    public DivideOperation(BigDecimal original, BigDecimal operand) {
        super(original, operand);
        if (Objects.equals(operand, BigDecimal.ZERO)) { // 校验操作数合法性
            throw new ArithmeticException("除法操作数不允许为0");
        }
    }

    @Override
    public BigDecimal execute() {
        return original.divide(operand, 5, RoundingMode.HALF_DOWN);
    }

}
