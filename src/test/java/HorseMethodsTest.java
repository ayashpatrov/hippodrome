import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HorseMethodsTest extends BaseTest {

    @Test
    @DisplayName("getName() возвращает имя лощади")
    @Description("Метод возвращает строку, которая была передана первым параметром в конструктор")
    public void getNameTest() {
        String expectedName = DEFAULT_NAME;
        Horse horse = new Horse(expectedName, DEFAULT_SPEED);
        assertEquals(expectedName, horse.getName());
    }

    @Test
    @DisplayName("getSpeed() возвращает скорость лощади")
    @Description("Метод возвращает число, которое было передано вторым параметром в конструктор")
    public void getSpeedTest() {
        double expectedSpeed = DEFAULT_SPEED;
        Horse horse = new Horse(DEFAULT_NAME, expectedSpeed);
        assertEquals(expectedSpeed, horse.getSpeed());
    }

    @Test
    @DisplayName("getDistance() возвращает расстояние, которое прошла лощадь")
    @Description("Метод возвращает число, которое было передано третьим параметром в конструктор")
    public void getDistanceTest() {
        double expectedDistance = DEFAULT_DISTANCE;
        Horse horse = new Horse(DEFAULT_NAME, DEFAULT_SPEED, expectedDistance);
        assertEquals(expectedDistance, horse.getDistance());
    }

    @Test
    @DisplayName("getDistance() возвращает расстояние, которое прошла лощадь")
    @Description("Метод возвращает ноль, если объект был создан с помощью конструктора с двумя параметрами")
    public void getDistanceDefaultTest() {
        double expectedDistance = 0;
        Horse horse = new Horse(DEFAULT_NAME, DEFAULT_SPEED);
        assertEquals(expectedDistance, horse.getDistance());
    }

    @Test
    @DisplayName("Метод move() вызывает getRandomDouble()")
    @Description("Метод вызывает внутри метод getRandomDouble с параметрами 0.2 и 0.9")
    public void moveTest() {
        try (MockedStatic<Horse> utilities =  Mockito.mockStatic(Horse.class)) {
            Horse horse = new Horse(DEFAULT_NAME, DEFAULT_SPEED);
            horse.move();
            utilities.verify(() -> Horse.getRandomDouble(0.2, 0.9));
        }
    }

    @Test
    @DisplayName("Метод move() расчёт пройденной дистанции")
    @Description("Метод move() присваивает дистанции значение высчитанное по формуле: distance + speed * getRandomDouble(0.2, 0.9)")
    public void moveCalculationTest() {
        double distance = faker.number().randomDouble(2, 0, 100);
        double speed = faker.number().randomDouble(2, 0, 100);
        double randomDoubleMock = (Math.random() * (0.9 - 0.2)) + 0.2;

        try (MockedStatic<Horse> utilities =  Mockito.mockStatic(Horse.class)) {
            utilities.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(randomDoubleMock);
            Horse horse = new Horse(DEFAULT_NAME, speed, distance);
            horse.move();
            assertEquals(distance + speed * randomDoubleMock, horse.getDistance());
        }
    }
}
