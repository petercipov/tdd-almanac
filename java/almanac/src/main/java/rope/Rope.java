package rope;

public class Rope {
    private int size = 0;
    private String buff = "";

    public int size() {
        return size;
    }

    public void insert(String value) {
        size += value.length();
        buff = value + buff;
    }

    @Override
    public String toString() {
        return buff;
    }
}
