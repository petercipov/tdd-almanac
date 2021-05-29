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
        for (int lbi=getSearchSize(); lbi < getLookAheadSize()+getSearchSize(); lbi++) {
            if (arr[sbi-length] == arr[lbi]) {
                position = getSearchSize() - sbi + length;
                length++;
            } else {
                break;
            }
        }

        return new Prefix(length, position);
    }
}
