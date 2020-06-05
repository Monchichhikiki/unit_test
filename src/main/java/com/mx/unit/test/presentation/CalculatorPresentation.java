package com.mx.unit.test.presentation;

/**
 * @author qiqi
 * @date 2020-06-03 00:01
 */
public class CalculatorPresentation {
    private int sumXX(int a, int b) {
        System.out.println("sumXX");
        return a + b;
    }

    public int callSumXX(int a, int b) {
        System.out.println("callSumXX");
        return sumXX(a, b);
    }

    /**
     * @return
     */
    public boolean testStatic() {
        return OrderPresentation.test(1234L);
    }

}
