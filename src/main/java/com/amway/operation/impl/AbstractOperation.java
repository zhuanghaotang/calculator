package com.amway.operation.impl;

import com.amway.operation.Operation;

import java.math.BigDecimal;

/**
 * @author: tang
 * @date: 2023/12/14
 * @description: 抽象操作类
 */
public abstract class AbstractOperation implements Operation {

    /**
     * 维护操作前的值（原始值）
     */
    protected BigDecimal original;

    /**
     * 操作数
     */
    protected BigDecimal operand;

    public AbstractOperation(BigDecimal original, BigDecimal operand) {
        this.original = original;
        this.operand = operand;
    }

    /**
     * 撤销时直接返回操作前的值
     */
    @Override
    public BigDecimal undo() {
        return original;
    }

    /**
     * 回退撤销时，直接按原始值进行运算
     */
    @Override
    public BigDecimal redo() {
        return execute();
    }

}
