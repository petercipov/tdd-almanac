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

    @Test
    public void insertingAtBeginningWillIncreaseSize() {
        rope.insert("text");
        assertEquals(4, rope.size());
    }

    @Test
    public void multiInsertWillAddToSize() {
        rope.insert("text");
        rope.insert("other");
        assertEquals(9, rope.size());
    }

    @Test
    public void multiInsertWillPrependValues() {
        rope.insert("text");
        rope.insert("other");
        assertEquals("othertext", rope.toString());
    }
}
