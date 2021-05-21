package lz77;

public class Buffer {
    private final int searchSize;
    private final int lookAheadSize;

    public Buffer(int searchSize, int lookAheadSize) {

        this.searchSize = searchSize;
        this.lookAheadSize = lookAheadSize;
    }

    public int getLookAheadSize() {
        return lookAheadSize;
    }

    public int getSearchSize() {
        return searchSize;
    }
}
