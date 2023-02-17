package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorEngineTest {


    @Test
    void testAddition() {
        CalculatorEngine calculator = new CalculatorEngine(Operation.ADDITION);
        String output1 = calculator.processNumber(1);
        String output2 = calculator.processNumber(2);
        String output3 = calculator.processNumber(3);
        assertEquals("1", output1);
        assertEquals(" +2 (= 1)", output2);
        assertEquals(" +3 (= 3)", output3);
        assertEquals(6, calculator.getTotal());
    }

    @Test
    void testSubtraction() {
        CalculatorEngine calculator = new CalculatorEngine(Operation.SUBTRACTION);
        String output1 = calculator.processNumber(10);
        String output2 = calculator.processNumber(2);
        String output3 = calculator.processNumber(3);
        assertEquals("10", output1);
        assertEquals(" -2 (= 10)", output2);
        assertEquals(" -3 (= 8)", output3);
        assertEquals(5, calculator.getTotal());
    }

    @Test
    void testMultiplication() {
        CalculatorEngine calculator = new CalculatorEngine(Operation.MULTIPLICATION);
        String output1 = calculator.processNumber(2);
        String output2 = calculator.processNumber(3);
        String output3 = calculator.processNumber(4);
        assertEquals("2", output1);
        assertEquals(" *3 (= 2)", output2);
        assertEquals(" *4 (= 6)", output3);
        assertEquals(24, calculator.getTotal());
    }
}
