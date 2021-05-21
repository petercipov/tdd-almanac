package lz77;

public class LengthDistancePair {

    private final char next;

    public LengthDistancePair(char next) {
        this.next = next;
    }

    public int getOffset() {
        return 0;
    }

    public int getLength() {
        return 0;
    }

    public char getNext() {
        return next;
    }
}
