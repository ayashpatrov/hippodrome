import jdk.jfr.Description;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;


public class MainTest {
    @Test
    @DisplayName("Метод main() выполняется не дольше 22 секунд")
    @Description("Метод main() выполняется не дольше 22 секунд")
    @Disabled
    public void mainTest() {
        assertTimeout(Duration.ofSeconds(22), () -> Main.main(null));
    }
}
