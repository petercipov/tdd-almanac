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
            arr[arr.length-1] = '\uFFFF';
            lookAheadSize--;
            return true;
        } else {
            return false;
        }
    }

    public Prefix longestPrefix() {
        int maxLength = 0;
        int maxPosition = 0;

        for (int sbi=getSearchSize()-1; sbi >= 0; sbi--) {
            int length = 0;
            int maxSBToLookAt = getSearchSize() - sbi;

            for (int lbi = getSearchSize(); lbi < getSearchSize() + maxSBToLookAt; lbi++) {
                if (arr[sbi + length] == arr[lbi]) {
                    length++;
                } else {
                    break;
                }
            }

            if (length > maxLength) {
                maxLength = length;
                maxPosition = getSearchSize() - sbi;
            }
        }

        return new Prefix(maxLength, maxPosition);
    }
}
