package rope;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RopeTest {

    @Test
    public void emptyRopeHasEmptySize() {
        Rope rope = new Rope();
        assertEquals(0, rope.size());
    }
}
