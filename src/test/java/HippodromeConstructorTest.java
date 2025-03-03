import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HippodromeConstructorTest extends BaseTest {
    @Test
    @DisplayName("IllegalArgumentException если не передан список лошадей")
    @Description("При передаче в конструктор null, будет выброшено IllegalArgumentException")
    public void HippodromeConstructorNullHorsesExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
    }

    @Test
    @DisplayName("Проверка сообщения об ошибке если не передан список лошадей")
    @Description("При передаче в конструктор null, сообщение об ошибке: " + HORSES_CANNOT_BE_NULL)
    public void HippodromeConstructorNullHorsesExceptionMessageTest() {
        try {
            new Hippodrome(null);
        } catch (IllegalArgumentException e) {
            assertEquals(HORSES_CANNOT_BE_NULL, e.getMessage());
        }
    }

    @Test
    @DisplayName("IllegalArgumentException если передан пустой список лошадей")
    @Description("При передаче в конструктор пустого списка, будет выброшено IllegalArgumentException")
    public void HippodromeConstructorEmptyHorsesExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(new ArrayList<>()));
    }

    @Test
    @DisplayName("Проверка сообщения об ошибке если передан пустой список лошадей")
    @Description("При передаче в конструктор пустого списка лошадей, сообщение об ошибке: " + HORSES_CANNOT_BE_EMPTY)
    public void HippodromeConstructorEmptyHorsesExceptionMessageTest() {
        try {
            new Hippodrome(new ArrayList<>());
        } catch (IllegalArgumentException e) {
            assertEquals(HORSES_CANNOT_BE_EMPTY, e.getMessage());
        }
    }
}
