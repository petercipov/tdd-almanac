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
        appendString("a");

        assertEquals('a', buffer.at(14));
    }

    @Test
    public void charactersInBufferAreShiftedWhenAppend() {
        appendString("abc");

        assertEquals('a', buffer.at(12));
        assertEquals('b', buffer.at(13));
        assertEquals('c', buffer.at(14));
    }

    @Test
    public void buffercanBeshiftedIfNoCharactersareLeftAndLBWillDecrement() {
        appendString("abc");

        buffer.shift();

        assertEquals('a', buffer.at(11));
        assertEquals('b', buffer.at(12));
        assertEquals('c', buffer.at(13));

        assertEquals(4, buffer.getLookAheadSize());
    }

    @Test
    public void LBcanBeDecrementByShiftingUntillItHasSomeSize() {
        appendString("abc");

        int iterations = 0;
        while(buffer.shift()) {
            iterations++;
        }

        assertEquals(0, buffer.getLookAheadSize());
        assertEquals(5, iterations);
    }

    @Test
    public void emptyLongestprefix() {
        appendString("abracx");

        Prefix prefix = buffer.longestPrefix();

        assertEquals(0, prefix.getLength());
        assertEquals(0, prefix.getPosition());
    }

    //@Test
    public void singleCharacterPrefix() {
        appendString("aabrac");

        Prefix prefix = buffer.longestPrefix();

        assertEquals(1, prefix.getLength());
        assertEquals(1, prefix.getPosition());

    }

    private void appendString(String value) {
        value.chars().forEach(code -> buffer.append((char) code));
    }
}