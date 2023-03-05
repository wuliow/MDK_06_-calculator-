import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class CalculatorTest {

    @Test
    public void testAddition() {
        String input = "2\n+\n3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Calculator.main(new String[]{});
        Assertions.assertEquals("Результат: 5.0\n", getOutput());
    }

    @Test
    public void testSubtraction() {
        String input = "5\n-\n3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Calculator.main(new String[]{});
        Assertions.assertEquals("Результат: 2.0\n", getOutput());
    }

    @Test
    public void testMultiplication() {
        String input = "2\n*\n3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Calculator.main(new String[]{});
        Assertions.assertEquals("Результат: 6.0\n", getOutput());
    }

    @Test
    public void testDivision() {
        String input = "10\n/\n2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Calculator.main(new String[]{});
        Assertions.assertEquals("Результат: 5.0\n", getOutput());
    }

    @Test
    public void testDivisionByZero() {
        String input = "10\n/\n0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Calculator.main(new String[]{});
        Assertions.assertEquals("Ошибка: деление на 0\n", getOutput());
    }

    @Test
    public void testInvalidOperation() {
        String input = "5\n&\n3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Calculator.main(new String[]{});
        Assertions.assertEquals("Ошибка: некорректная операция\n", getOutput());
    }

    @Test
    public void testInvalidNumberInput() {
        String input = "5\n+\nabc\n3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Calculator.main(new String[]{});
        Assertions.assertEquals("Ошибка: введите число\n" +
                "Результат: 8.0\n", getOutput());
    }

    private String getOutput() {
        return outputStreamCaptor.toString();
    }

    private final java.io.ByteArrayOutputStream outputStreamCaptor = new java.io.ByteArrayOutputStream();

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        System.setOut(new java.io.PrintStream(outputStreamCaptor));
    }
}
