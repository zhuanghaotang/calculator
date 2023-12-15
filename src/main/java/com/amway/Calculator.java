package com.amway;

import com.amway.operation.Operation;
import com.amway.operation.impl.AddOperation;
import com.amway.operation.impl.DivideOperation;
import com.amway.operation.impl.MultiplyOperation;
import com.amway.operation.impl.SubtractOperation;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * @author: tang
 * @date: 2023/12/14
 * @description: 计算器
 */
public class Calculator {

    /**
     * 计算器当前值
     */
    private BigDecimal current;
    /**
     * 操作历史
     */
    private final Stack<Operation> operationStack = new Stack<>();
    /**
     * 撤销历史
     */
    private final Stack<Operation> redoStack = new Stack<>();

    /**
     * 加法运算
     *
     * @param operand 操作数
     */
    public Calculator add(BigDecimal operand) {
        Operation operation = new AddOperation(current, operand);
        current = doOperate(operation);
        return this;
    }

    /**
     * 减法运算
     */
    public Calculator subtract(BigDecimal operand) {
        Operation operation = new SubtractOperation(current, operand);
        current = doOperate(operation);
        return this;
    }

    /**
     * 乘法运算
     */
    public Calculator multiply(BigDecimal operand) {
        Operation operation = new MultiplyOperation(current, operand);
        current = doOperate(operation);
        return this;
    }

    /**
     * 除法运算
     */
    public Calculator divide(BigDecimal operand) {
        Operation operation = new DivideOperation(current, operand);
        current = doOperate(operation);
        return this;
    }

    /**
     * 撤销上一步操作
     * 如果没有可撤销的操作，则不作提示
     */
    public Calculator undo() {
        if (!operationStack.isEmpty()) {
            Operation operation = operationStack.pop();
            current = operation.undo();
            redoStack.push(operation);
        }
        return this;
    }

    /**
     * 回退上一步撤销
     * 如果没有可回退的操作，则不作提示
     */
    public Calculator redo() {
        if (!redoStack.isEmpty()) {
            Operation operation = redoStack.pop();
            current = operation.redo();
            operationStack.push(operation);
        }
        return this;
    }

    /**
     * 获取计算结果
     */
    public Double getResult() {
        return current.doubleValue();
    }

    private BigDecimal doOperate(Operation operation) {
        BigDecimal result = operation.execute();
        operationStack.push(operation); // 执行成功，操作入栈
        redoStack.clear(); // 每执行一次新操作，都需要清空redoStack中的操作，避免混淆、简化逻辑、节省内存
        return result;
    }

    public Calculator() {
        this.current = BigDecimal.ZERO; // 计算器默认初始值是0
    }

    public Calculator(BigDecimal initValue) {
        this.current = initValue;
    }

}
