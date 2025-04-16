package math;

import math.ArithmeticOperations;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArithmeticOperationsTest {

    ArithmeticOperations operations = new ArithmeticOperations();

    @Test
    public void testDivide_ValidInputs() {
        assertEquals(2.5, operations.divide(5, 2), 0.0001);
    }

    @Test
    public void testDivide_NegativeNumerator() {
        assertEquals(-2.0, operations.divide(-4, 2), 0.0001);
    }

    @Test
    public void testDivide_NegativeDenominator() {
        assertEquals(-2.0, operations.divide(4, -2), 0.0001);
    }

    @Test
    public void testDivide_BothNegative() {
        assertEquals(2.0, operations.divide(-4, -2), 0.0001);
    }

    @Test
    public void testDivide_NumeratorZero() {
        assertEquals(0.0, operations.divide(0, 5), 0.0001);
    }

    @Test
    public void testDivide_DenominatorZero_ThrowsException() {
        Exception exception = assertThrows(ArithmeticException.class, () ->
            operations.divide(5, 0));
        assertEquals("Cannot divide with zero", exception.getMessage());
    }





    @Test
    public void testMultiply_ValidInputs() {
        assertEquals(20, operations.multiply(4, 5));
    }

    @Test
    public void testMultiply_WithZero() {
        assertEquals(0, operations.multiply(4, 0));
        assertEquals(0, operations.multiply(0, 10));
    }

    @Test
    public void testMultiply_NegativeX_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            operations.multiply(-3, 5);
        });
        assertEquals("x & y should be >= 0", exception.getMessage());
    }

    @Test
    public void testMultiply_NegativeY_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            operations.multiply(5, -2);
        });
        assertEquals("x & y should be >= 0", exception.getMessage());
    }

    @Test
    public void testMultiply_Overflow_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            operations.multiply(Integer.MAX_VALUE, 2);
        });
        assertEquals("The product does not fit in an Integer variable", exception.getMessage());
    }

    @Test
    public void testMultiply_JustBelowOverflow() {
        int max = Integer.MAX_VALUE;
        assertDoesNotThrow(() -> {
            operations.multiply(max / 2, 2);
        });
    }
}
