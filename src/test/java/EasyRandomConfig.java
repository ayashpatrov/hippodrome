import com.github.javafaker.Faker;
import org.jeasy.random.EasyRandomParameters;

public class EasyRandomConfig extends EasyRandomParameters {
    Faker faker = new Faker();
    public EasyRandomConfig() {
        this.stringLengthRange(3, 3)
                .randomize(double.class, () -> faker.number().randomDouble(2, 0, 100))
                .randomize(String.class, () -> faker.rickAndMorty().character())
        ;
    }
}
