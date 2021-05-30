package lz77;

public class LengthDistancePair {

    private final char next;
    private final int offset;
    private final int length;

    public LengthDistancePair(char next, int offset, int length) {
        this.next = next;
        this.offset = offset;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public int getOffset() {
        return offset;
    }

    public char getNext() {
        return next;
    }
}
