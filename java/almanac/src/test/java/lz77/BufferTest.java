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

        assertEquals('a', buffer.at(14));
    }

    @Test
    public void charactersInBufferAreShiftedWhenAppend() {
        Buffer buffer = new Buffer(10, 5);
        buffer.append('a');
        buffer.append('b');
        buffer.append('c');

        assertEquals('a', buffer.at(12));
        assertEquals('b', buffer.at(13));
        assertEquals('c', buffer.at(14));
    }

    @Test
    public void buffercanBeshiftedIfNoCharactersareLeftAndLBWillDecrement() {
        Buffer buffer = new Buffer(10, 5);

        buffer.append('a');
        buffer.append('b');
        buffer.append('c');

        buffer.shift();

        assertEquals('a', buffer.at(11));
        assertEquals('b', buffer.at(12));
        assertEquals('c', buffer.at(13));

        assertEquals(4, buffer.getLookAheadSize());
    }

    @Test
    public void LBcanBeDecrementByShiftingUntillItHasSomeSize() {
        Buffer buffer = new Buffer(10, 5);

        buffer.append('a');
        buffer.append('b');
        buffer.append('c');

        int iterations = 0;
        while(buffer.shift()) {
            iterations++;
        }

        assertEquals(0, buffer.getLookAheadSize());
        assertEquals(5, iterations);
    }
}