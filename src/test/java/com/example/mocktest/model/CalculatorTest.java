package com.example.mocktest.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void sum() {
        Calculator calculator = new Calculator();
        int result = calculator.sum(10, 20);
        assertEquals(30, result);
    }
}