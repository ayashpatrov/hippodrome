import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HorseConstructorTest extends BaseTest {
    @Test
    @DisplayName("IllegalArgumentException, если name = null")
    @Description("При передаче в конструктор первым параметром null, будет выброшено IllegalArgumentException")
    public void HorseConstructorNullNameExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> new Horse(null, DEFAULT_SPEED, DEFAULT_DISTANCE));
    }

    @Test
    @DisplayName("Проверка сообщения об ошибке, если name = null")
    @Description("При передаче в конструктор первым параметром null, сообщение об ошибке: " + NAME_CANNOT_BE_NULL)
    public void HorseConstructorNullNameExceptionMessageTest() {
        try {
            new Horse(null, DEFAULT_SPEED, DEFAULT_DISTANCE);
        } catch (IllegalArgumentException e) {
            assertEquals(NAME_CANNOT_BE_NULL, e.getMessage());
        }
    }

    @ParameterizedTest
    @DisplayName("IllegalArgumentException, если name состоит из пробельных символов")
    @Description("При передаче в конструктор первым параметром пустой строки или строки содержащей только пробельные символы (пробел, табуляция и т.д.), будет выброшено IllegalArgumentException")
    @ValueSource(strings = {" ", "  ", "\t", "\t ", "\n", "&nbsp;"})
    public void HorseConstructorEmptyNameExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> new Horse(null, DEFAULT_SPEED, DEFAULT_DISTANCE));
    }

    @ParameterizedTest
    @DisplayName("Проверка сообщения об ошибке, если name состоит из пробельных символов")
    @Description("При передаче в конструктор первым параметром пустой строки или строки содержащей только пробельные символы (пробел, табуляция и т.д.), сообщение об ошибке " + NAME_CANNOT_BE_BLANK)
    @ValueSource(strings = {" ", "  ", "\t", "\t ", "\n", "&nbsp;"})
    public void HorseConstructorEmptyNameExceptionMessageTest(String name) {
        try {
            new Horse(name, DEFAULT_SPEED, DEFAULT_DISTANCE);
        } catch (IllegalArgumentException e) {
            assertEquals(NAME_CANNOT_BE_BLANK, e.getMessage());
        }
    }

    @Test
    @DisplayName("IllegalArgumentException, если speed < 0")
    @Description("При передаче в конструктор вторым параметром отрицательного числа, будет выброшено IllegalArgumentException")
    public void HorseConstructorNegativeSpeedExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> new Horse(DEFAULT_NAME, -1, DEFAULT_DISTANCE));
    }

    @Test
    @DisplayName("Проверка сообщения об ошибке, если speed < 0")
    @Description("При передаче в конструктор вторым параметром отрицательного числа, сообщение об ошибке " + SPEED_CANNOT_BE_NEGATIVE)
    public void HorseConstructorNegativeSpeedExceptionMessageTest() {
        try {
            new Horse(DEFAULT_NAME, -1, DEFAULT_DISTANCE);
        } catch (IllegalArgumentException e) {
            assertEquals(SPEED_CANNOT_BE_NEGATIVE, e.getMessage());
        }
    }

    @Test
    @DisplayName("IllegalArgumentException, если distance < 0")
    @Description("При передаче в конструктор третьим параметром отрицательного числа, будет выброшено IllegalArgumentException")
    public void HorseConstructorNegativeDistanceExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> new Horse(DEFAULT_NAME, DEFAULT_SPEED, -1));
    }

    @Test
    @DisplayName("Проверка сообщения об ошибке, если distance < 0")
    @Description("При передаче в конструктор третьим параметром отрицательного числа, сообщение об ошибке " + DISTANCE_CANNOT_BE_NEGATIVE)
    public void HorseConstructorNegativeDistanceExceptionMessageTest() {
        try {
            new Horse(DEFAULT_NAME, DEFAULT_SPEED, -1);
        } catch (IllegalArgumentException e) {
            assertEquals(DISTANCE_CANNOT_BE_NEGATIVE, e.getMessage());
        }
    }
}
