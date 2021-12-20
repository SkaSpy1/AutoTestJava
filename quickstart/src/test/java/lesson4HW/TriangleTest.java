package lesson4HW;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class TriangleTest {

    AreaTriangle calcTheAreaOfTriangle = new AreaTriangle();
    private static Logger logger = LoggerFactory.getLogger(AreaTriangle.class);

    @Test
    void CalculatingSquare() throws ArithmeticException {
        double result = calcTheAreaOfTriangle.calcTheAreaOfTriangle(12, 10, 12);
        Assertions.assertEquals(54.543560573178574, result);
    }

    @Test
    void CalculatingSquareException() {
        assertThatExceptionOfType(ArithmeticException.class).isThrownBy(
                () -> calcTheAreaOfTriangle.calcTheAreaOfTriangle(-7, 12, 12));
}
    @ParameterizedTest
    @CsvSource({", , ", "12, , ", ", 10, ", ", , 12"})
    void testExceptionNullSides(Integer a, Integer b, Integer c) {
        logger.error("Стороны треугольника: " + a + "," + b + "," + c + ", ожидается NullPointerException");
        assertThatNullPointerException().isThrownBy(() -> AreaTriangle.calcTheAreaOfTriangle(a, b, c));
    }

}
