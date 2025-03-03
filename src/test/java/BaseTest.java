import com.github.javafaker.Faker;
import org.jeasy.random.EasyRandom;

public class BaseTest {
    public static final double DEFAULT_SPEED = 1.0;
    public static final double DEFAULT_DISTANCE = 1.0;
    public static final String DEFAULT_NAME = "Horse";
    public static final String NAME_CANNOT_BE_NULL = "Name cannot be null.";
    public static final String NAME_CANNOT_BE_BLANK = "Name cannot be blank.";
    public static final String SPEED_CANNOT_BE_NEGATIVE = "Speed cannot be negative.";
    public static final String DISTANCE_CANNOT_BE_NEGATIVE = "Distance cannot be negative.";
    public static final String HORSES_CANNOT_BE_NULL = "Horses cannot be null.";
    public static final String HORSES_CANNOT_BE_EMPTY = "Horses cannot be empty.";

    public Faker faker = new Faker();
    EasyRandom easyRandom = new EasyRandom(new EasyRandomConfig());
}
