package com.amway;

import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;

/**
 * @author: tang
 * @date: 2023/12/14
 * @description:
 */
public class CalculatorTest {

    /**
     * case：基本加减乘除
     */
    @Test
    public void test1() {
        Double result = new Calculator(BigDecimal.ZERO)
                .add(BigDecimal.valueOf(10))
                .subtract(BigDecimal.valueOf(5))
                .multiply(BigDecimal.valueOf(20))
                .divide(BigDecimal.valueOf(10))
                .getResult();
        assertEquals(10d, result);
    }

    /**
     * case：undo操作
     */
    @Test
    public void test2() {
        Double result = new Calculator(BigDecimal.ZERO)
                .add(BigDecimal.valueOf(10))
                .subtract(BigDecimal.valueOf(5))
                .multiply(BigDecimal.valueOf(20))
                .undo()
                .divide(BigDecimal.valueOf(10))
                .getResult();
        assertEquals(0.5d, result);
    }

    /**
     * case：redo操作
     */
    @Test
    public void test3() {
        Double result = new Calculator(BigDecimal.ZERO)
                .add(BigDecimal.valueOf(10))
                .subtract(BigDecimal.valueOf(5))
                .multiply(BigDecimal.valueOf(20))
                .undo()
                .redo()
                .divide(BigDecimal.valueOf(10))
                .getResult();
        assertEquals(10d, result);
    }

    /**
     * case: 边界操作，分母为0，期望错误提示
     */
    @Test(expected = ArithmeticException.class)
    public void test4() {
        Double result = new Calculator(BigDecimal.ZERO)
                .add(BigDecimal.valueOf(10))
                .divide(BigDecimal.valueOf(0))
                .getResult();
    }

    /**
     * case：边界操作，乘以0，再undo，期望返回原有值
     */
    @Test
    public void test5() {
        Double result = new Calculator(BigDecimal.ZERO)
                .add(BigDecimal.valueOf(10))
                .multiply(BigDecimal.valueOf(0))
                .undo()
                .getResult();
        assertEquals(10d, result);
    }

    /**
     * case: 边界操作，除不尽再undo，期望返回原有值
     */
    @Test
    public void test6() {
        Double result = new Calculator(BigDecimal.ZERO)
                .add(BigDecimal.valueOf(10))
                .divide(BigDecimal.valueOf(3))
                .undo()
                .getResult();
        assertEquals(10d, result);
    }

    /**
     * case，大杂烩场景
     * 10 / 2 x 7 + 12 undo x 2 + 4 x 3 undo undo redo + 5 = 79
     */
    @Test
    public void test7() {
        Double result = new Calculator(BigDecimal.valueOf(10))
                .divide(BigDecimal.valueOf(2))
                .multiply(BigDecimal.valueOf(7))
                .add(BigDecimal.valueOf(12))
                .undo()
                .multiply(BigDecimal.valueOf(2))
                .add(BigDecimal.valueOf(4))
                .multiply(BigDecimal.valueOf(3))
                .undo()
                .undo()
                .redo()
                .add(BigDecimal.valueOf(5))
                .getResult();
        System.out.println(result);
        assertEquals(79d, result);
    }

    /**
     * case：小数场景
     */
    @Test
    public void test8() {
        Double result = new Calculator(BigDecimal.ZERO)
                .add(BigDecimal.valueOf(0.6))
                .divide(BigDecimal.valueOf(2))
                .getResult();
        assertEquals(0.3d, result);
    }


}
