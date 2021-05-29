package lz77;

public class Buffer {
    private final int searchSize;
    private int lookAheadSize;
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
        shift();
        arr[arr.length - 1] = character;
        lookAheadSize += 1;
    }

    public char at(int i) {
        return arr[i];
    }

    public boolean shift() {
        if (lookAheadSize > 0) {
            for (int i = 1; i < arr.length; i++) {
                arr[i - 1] = arr[i];
            }
            lookAheadSize--;
            return true;
        } else {
            return false;
        }
    }

    public Prefix longestPrefix() {
        int length = 0;
        int position = 0;

        int sbi=getSearchSize()-1;
        int lbi=getSearchSize();

        if (arr[sbi] == arr[lbi]) {
            length++;
            position = getSearchSize() - sbi;
        }

        return new Prefix(length, position);
    }
}
