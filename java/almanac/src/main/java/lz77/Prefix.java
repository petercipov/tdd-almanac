package lz77;

public class Prefix {

    private final int length;
    private final int position;

    public Prefix(int length, int position) {
        this.length = length;
        this.position = position;
    }

    public int getLength() {
        return length;
    }

    public int getPosition() {
        return position;
    }
}
