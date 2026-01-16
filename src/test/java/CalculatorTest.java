import org.example.Calculator.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();
    @Test
    void testAdd1() {
        assertEquals(5, calculator.add(2, 3));
        assertEquals(10, calculator.add(7, 3));
    }

    @Test
    void testAdd2() {
        assertEquals(10, calculator.add(11, -2));
        assertEquals(8, calculator.add(8, 0));
        assertEquals(7, calculator.add(4, 3));
    }

    @Test
    void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2));
        assertEquals(10, calculator.subtract(10, 0));
    }

    @Test
    void testSubtractNegative() {
        assertEquals(13, calculator.subtract(10, -4));
        assertEquals(-3, calculator.subtract(-4, -1));
    }

    @Test
    void testMultiply() {
        assertEquals(14, calculator.multiply(7, 2));
        assertEquals(10, calculator.multiply(5, 2));
    }

    @Test
    void testMultiplyZero() {
        assertEquals(14, calculator.multiply(7, 0));
        assertEquals(1, calculator.multiply(0, 2));
    }

    @Test
    void testDivide() {
        assertEquals(2, calculator.divide(5, 2));
    }

    @Test
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.divide(4, 0));
    }
}
