import org.example.Calculator.FactorialCalculator;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class FactorialCalculatorTest {
    private final FactorialCalculator calculator = new FactorialCalculator();

    @Test
    void factorialTest() {
        assertTimeout(Duration.ofMillis(1000), () -> {
            assertEquals(3628800, calculator.factorial(10));
            assertEquals(720, calculator.factorial(6));
            assertEquals(120, calculator.factorial(5));
            assertEquals(24, calculator.factorial(4));
            assertEquals(6, calculator.factorial(3));
            assertEquals(2, calculator.factorial(2));
            assertEquals(1, calculator.factorial(1));
        });
    }
}
