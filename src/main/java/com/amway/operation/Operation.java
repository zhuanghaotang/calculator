package com.amway.operation;

import java.math.BigDecimal;

/**
 * @author: tang
 * @date: 2023/12/14
 * @description: 操作接口，每种操作都有其对应的执行、撤销、回退撤销逻辑
 */
public interface Operation {

    /**
     * 执行操作
     */
    BigDecimal execute();

    /**
     * 撤销操作
     */
    BigDecimal undo();

    /**
     * 回退撤销
     */
    BigDecimal redo();

}
