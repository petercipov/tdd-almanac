package lz77;

public class LengthDistancePair {

    private final char next;
    private final Prefix prefix;

    public LengthDistancePair(char next, Prefix prefix) {
        this.next = next;
        this.prefix = prefix;
    }

    public Prefix getPrefix() {
        return prefix;
    }

    public char getNext() {
        return next;
    }
}
