import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HippodromeMethodsTest extends BaseTest {
    @Test
    @DisplayName("getHorses возвращает тот же список, что был передан при создании")
    @Description("Метод возвращает список, который содержит те же объекты и в той же последовательности, что и список который был передан в конструктор")
    public void getHorsesTest() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            horses.add(easyRandom.nextObject(Horse.class));
        }

        Hippodrome hippodrome = new Hippodrome(horses);
        assertEquals(horses, hippodrome.getHorses(), "message");
    }

    @Test
    @DisplayName("Метод move вызывает метод move у всех лошадей")
    @Description("Метод move вызывает метод move у всех лошадей")
    public void moveTest() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            horses.add(Mockito.mock(Horse.class));
        }

        Hippodrome hippodrome = new Hippodrome(horses);
        hippodrome.move();

        for (Horse horse : horses) {
            Mockito.verify(horse, Mockito.times(1)).move();
        }
    }

    @Test
    @DisplayName("Определение победителя")
    @Description("Метод возвращает лошадь с самым большим значением distance")
    public void getWinnerTest() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            horses.add(easyRandom.nextObject(Horse.class));
        }

        Hippodrome hippodrome = new Hippodrome(horses);
        hippodrome.move();

        Horse fastestHorse = horses.stream()
                .max(Comparator.comparingDouble(Horse::getDistance))
                .orElse(null);

        assertEquals(fastestHorse, hippodrome.getWinner(), "Подбедитель определён не верно.");
    }
}
