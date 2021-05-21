package lz77;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BufferTest {

    @Test
    public void bufferHasSearchAndLookAhead() {
        Buffer buffer = new Buffer(10, 5);

        assertEquals(10, buffer.getSearchSize());
        assertEquals(5, buffer.getLookAheadSize());
    }

    public void singleAppendWillResideAtTheEnd() {
        Buffer buffer = new Buffer(10, 5);
        buffer.append('a');

        assertEquals('a', buffer.arr[14]);
    }
}