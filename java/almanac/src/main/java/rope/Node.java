package rope;
public class Node {
    private int weight;
    private String value;
    private Node left;
    private Node Right;

    public static Node leaf(String some) {
        var node =  new Node();
        node.value = some;
        node.weight = some.length();
        return node;
    }

    public int size() {
        return value == null ? 0 : value.length();
    }

    public int weight() {
        return this.weight;
    }
}
