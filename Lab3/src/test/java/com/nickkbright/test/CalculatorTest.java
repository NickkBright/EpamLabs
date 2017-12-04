package com.nickkbright.test;

import com.nickkbright.epamlab3.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeClass
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void testAddition() {
        Assert.assertEquals(calculator.calculate("13 + 8"), 21.0);
    }

    @Test
    public void testSubtraction() {
        Assert.assertEquals(calculator.calculate("13 - 8"), 5.0);
    }

    @Test
    public void testMultiplication() {
        Assert.assertEquals(calculator.calculate("13 * 8"), 104.0);
    }

    @Test
    public void testDivision() {
        Assert.assertEquals(calculator.calculate("16 / 8"), 2.0);
    }

    @Test(expectedExceptions = java.lang.ArithmeticException.class)
    public void testDivideByZero() {
        calculator.calculate("13 / 0");
    }

    @Test
    public void testComplexExpression() {
        double result = calculator.calculate("26 / (15 - 2) * 10 + 15/3");
        double answer = 25.0;
        Assert.assertEquals(result, answer);
    }
}