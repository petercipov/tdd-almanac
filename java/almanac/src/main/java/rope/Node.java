package rope;
public class Node {
    private int weight;
    private String value;
    private Node left;
    private Node right;

    public static Node leaf(String some) {
        var node =  new Node();
        node.value = some;
        node.weight = some.length();
        return node;
    }

    public static Node connection(Node left, Node right) {
        var node =  new Node();
        node.left = left;
        node.right = right;
        node.weight = left.computeSubtreeWeight();
        return node;
    }

    public int size() {
        return value == null ? 0 : value.length();
    }

    public int weight() {
        return this.weight;
    }

    private int computeSubtreeWeight() {
        if (isLeaf()) {
            return weight;
        } else {
            int w = 0;
            if (left != null) {
                w += this.left.computeSubtreeWeight();
            }
            if (right != null) {
                w += this.right.computeSubtreeWeight();
            }

            return w;
        }
    }

    private boolean isLeaf() {
        return left == null && right == null;
    }
}
