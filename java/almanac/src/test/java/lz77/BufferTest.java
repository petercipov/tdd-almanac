package lz77;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BufferTest {

    private Buffer buffer;

    @BeforeEach
    public void before() {
        buffer = new Buffer(10, 5);
    }

    @Test
    public void bufferHasSearchAndLookAhead() {
        assertEquals(10, buffer.getSearchSize());
        assertEquals(5, buffer.getLookAheadSize());
    }

    @Test
    public void singleAppendWillResideAtTheEnd() {
        buffer.append('a');

        assertEquals('a', buffer.at(14));
    }

    @Test
    public void charactersInBufferAreShiftedWhenAppend() {
        buffer.append('a');
        buffer.append('b');
        buffer.append('c');

        assertEquals('a', buffer.at(12));
        assertEquals('b', buffer.at(13));
        assertEquals('c', buffer.at(14));
    }

    @Test
    public void buffercanBeshiftedIfNoCharactersareLeftAndLBWillDecrement() {
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