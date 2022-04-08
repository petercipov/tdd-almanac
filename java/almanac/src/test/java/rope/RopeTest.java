package rope;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RopeTest {

    private Rope rope;

    @BeforeEach
    void before() {
        rope = new Rope();
    }

    @Test
    public void emptyRopeHasEmptySize() {
        Rope rope = new Rope();
        assertEquals(0, rope.size());
    }

    public void insertingAtBeginningWillIncreaseSize() {
        rope.insert("text");
        assertEquals(4, rope.size());
    }
}