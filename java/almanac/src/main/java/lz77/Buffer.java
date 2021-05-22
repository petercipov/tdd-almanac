package lz77;

public class Buffer {
    private final int searchSize;
    private final int lookAheadSize;
    private final char[] arr;

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
        for (int i=1; i < arr.length; i++) {
            arr[i-1] = arr[i];
        }
        arr[arr.length - 1] = character;
    }

    public char at(int i) {
        return arr[i];
    }
}
