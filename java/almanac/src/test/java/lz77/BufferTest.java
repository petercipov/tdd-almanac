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

    @Test
    public void singleAppendWillResideAtTheEnd() {
        Buffer buffer = new Buffer(10, 5);
        buffer.append('a');

        assertEquals('a', buffer.arr[14]);
    }

    @Test
    public void charactersInBufferAreShiftedWhenAppend() {
        Buffer buffer = new Buffer(10, 5);
        buffer.append('a');
        buffer.append('b');
        buffer.append('c');

        assertEquals('a', buffer.arr[12]);
        assertEquals('b', buffer.arr[13]);
        assertEquals('c', buffer.arr[14]);
    }
}