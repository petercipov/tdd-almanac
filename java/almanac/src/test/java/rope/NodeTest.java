package rope;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NodeTest {

    @Test
    public void emptyNodeHasZeroSize() {
        var node = new Node();
        assertEquals(0, node.size());
    }

    @Test
    public void leafNodeIsSizeOfValue() {
        var node = Node.leaf("some");
        assertEquals(4, node.size());
    }

    @Test
    public void leafNodeIsWeightOfValue() {
        var node = Node.leaf("some");
        assertEquals(4, node.weight());
    }

    @Test
    public void connectionNodeHasEmptySize() {
        var node = Node.connection(Node.leaf("left"), Node.leaf("right"));
        assertEquals(0, node.size());
    }

    @Test
    public void connectionNodeHasWeightOfLeftSubNode() {
        var node = Node.connection(Node.leaf("left"), Node.leaf("right"));
        assertEquals(4, node.weight());
    }

    @Test
    public void connectionNodeHasWeightOfAllLefLeafNodes() {
        var node =
                Node.connection(
                    Node.connection(Node.leaf("left"), Node.leaf("right")),
                    null);
        assertEquals(9, node.weight());
    }
}
