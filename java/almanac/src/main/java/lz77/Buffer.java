package lz77;

public class Buffer {
    private final int searchSize;
    private final int lookAheadSize;
    protected final char[] arr;

    public Buffer(int searchSize, int lookAheadSize) {

        this.searchSize = searchSize;
        this.lookAheadSize = lookAheadSize;
        this.arr = new char[searchSize+lookAheadSize];
    }

    public int getLookAheadSize() {
        return lookAheadSize;
    }

    public int getSearchSize() {
        return searchSize;
    }

    public void append(char character) {
        arr[arr.length - 1] = character;
    }
}
