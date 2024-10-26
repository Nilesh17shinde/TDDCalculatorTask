package TDDCalculatorTask;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    @Test
    public void testEmptyString() {
        assertEquals(0, new StringCalculator().add("0"));
    }

    @Test
    public void testSingleNumber() {
        assertEquals(1, new StringCalculator().add("1"));
    }

    @Test
    public void testTwoNumbers() {
        assertEquals(6, new StringCalculator().add("1,5"));
    }

    @Test
    public void testMultipleNumbers() {
        assertEquals(15, new StringCalculator().add("1,2,3,4,5"));
    }

    @Test
    public void testNewlineDelimiter() {
        assertEquals(6, new StringCalculator().add("1\n2,3"));
    }

    @Test
    public void testCustomDelimiter() {
        assertEquals(3, new StringCalculator().add("//;\n1;2"));
    }

    @Test
    public void testNegativeNumbersException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new StringCalculator().add("1,-2,-3");
        });
        assertEquals("negative numbers not allowed -2, -3", exception.getMessage());
    }
}
