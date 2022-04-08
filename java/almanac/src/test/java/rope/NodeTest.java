package rope;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NodeTest {

    @Test
    public void emptyNodeHasZeroSize() {
        Node node = new Node();
        assertEquals(0, node.size());
    }
}
