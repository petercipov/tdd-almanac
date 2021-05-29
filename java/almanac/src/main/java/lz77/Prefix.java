package lz77;

public class Prefix {

    private final int length;
    private final int offset;

    public Prefix(int length, int offset) {
        this.length = length;
        this.offset = offset;
    }

    public int getLength() {
        return length;
    }

    public int getOffset() {
        return offset;
    }
}
