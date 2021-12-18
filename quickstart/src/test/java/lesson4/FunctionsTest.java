package lesson4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FunctionsTest {
    private static Logger logger = LoggerFactory.getLogger(FunctionsTest.class);
    //TRACE, DEBUG, INFO, WARN, ERROR
    @BeforeAll
    static void beforeAll() {
        System.out.println("Метод выполнился перед всеми тестами 1 раз");
        logger.info("Метод выполнился перед всеми тестами 1 раз");
        logger.trace("trace lvl log");
        logger.error("ERROR lvl log");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Метод выполнился перед каждым тестом");
        //  WebDriver driver = new ChromeDriver();
    }

    @Test
    @DisplayName("Проверка метода isPrime с простым числом")
    public void givenPrimeNumberWhenIsPrimeThenTrue() {
        //Цаг тест кейса = вызвать метод с числом 7
        boolean result = Functions.isPrime(7);
        //Ожидаемый результат
        assertTrue(result); //Проверить что result == true

    }

    //  @Test
    //  void isPalindromeTest() {
    //      Assertions.assertTrue(Functions.isPalindrome("123321"));
    //  }

    // @Test
    // void isPalindrome2Test() {
    //     Assertions.assertTrue(Functions.isPalindrome("12321"));
    // }

    @ParameterizedTest
    @ValueSource(strings = {"123321", "12321"})
    void isPalindromeTest(String word) {
        assertTrue(Functions.isPalindrome(word));
    }

    @Test
    public void isNotPalindromeTest() {
        Assertions.assertEquals(false, Functions.isPalindrome("12"));
    }

    @ParameterizedTest
    @CsvSource({"123321, true", "12, false"})
    public void isNotPalindrome2Test(String word, boolean result) {
        Assertions.assertEquals(result, Functions.isPalindrome(word));

    }

    @ParameterizedTest
    @MethodSource("CatDataProvider")
    void parametrizdByObjectTest(Cat testCat) {
        Assertions.assertEquals(10, testCat.getAge());

    }

    private static List<Cat> catsDataProvider() {
        return Arrays.asList(new Cat("Moris", 13), new Cat("Barsik", 10));
    }

    @ParameterizedTest
    @MethodSource("CatAtBooleanDataProvider")
    void parametrizdByAnyObjectTest(Cat testCat, Boolean result) {
        Assertions.assertEquals(10, testCat.getAge());
    }

    private static List<Arguments> catAtBooleanDataProvider() {
        return Arrays.asList(
                Arguments.of(new Cat("Moris", 13), true),
                Arguments.of(new Cat("Barsik", 10), false));
    }
    @Test
    void  assuptionTest(){
        Assumptions.assumeTrue(1==2);
        Assumptions.assumeTrue(1==1);
    }
    @Test
    void assertAllTest(){
        Assertions.assertAll(
                ()->assertTrue(1==1),
                ()->assertTrue(1==2),
                ()->assertTrue(1==3),
                ()->assertTrue(1==1)
        );
    }

    @AfterEach
    void afterEach() {
        //driver.quit()
        System.out.println("Метод выполнился после каждого тестом");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Метод выполнился после всех тестов");
    }
}
// <configuration>
// <variable>name="LOG_LEVEL"</variable>
// <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
// <encoder>
// <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
// </encoder>
// </appender>
//
// <root level="${LOG_LEVEL}">
// <appender-ref ref="STDOUT" />
// </root>
// </configuration>