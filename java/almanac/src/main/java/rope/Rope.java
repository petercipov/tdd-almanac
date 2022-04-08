package rope;

public class Rope {
    private int size = 0;

    public int size() {
        return size;
    }

    public void insert(String value) {
        size += value.length();
    }
}
