package lz77;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class CompressorTest {

    Compressor compressor;

    @BeforeEach
    public void before () {
        compressor = new Compressor(new Buffer(8,6));
    }

    @Test
    public void compressionWillReturnEmptyListOfLengthDistancePairsIfRecevingEmptyStringAsInput () {
        List<LengthDistancePair> pairs = compressor.compress("");
        Assertions.assertTrue(pairs.isEmpty());
    }

    @Test
    public void compressorShouldReturnStaritngLengthDistancePairForSingleCharInput () {
        List<LengthDistancePair> pairs = compressor.compress("a");
        Assertions.assertEquals(1, pairs.size());
        LengthDistancePair pair = pairs.get(0);
        Assertions.assertEquals(0, pair.getOffset());
        Assertions.assertEquals(0, pair.getLength());
        Assertions.assertEquals('a', pair.getNext());
    }

    @Test
    public void compressorShouldReturnUptoLBSizeStartingLengthDistancePairs() {
        String input = "abcdef";
        Assertions.assertEquals(6, input.length());
        List<LengthDistancePair> pairs = compressor.compress(input);

        Assertions.assertEquals(6, pairs.size());
        for (int i=0; i < input.length(); i++) {
            Assertions.assertEquals(input.charAt(i), pairs.get(i).getNext());
            Assertions.assertEquals(0, pairs.get(i).getLength());
            Assertions.assertEquals(0, pairs.get(i).getOffset());
        }
    }

    @Test
    public void prefixLongerThanOneShouldreturnNexCharaterShifterdByLebgth() {
        String input = "ababab";
        Assertions.assertEquals(6, input.length());
        List<LengthDistancePair> pairs = compressor.compress(input);

        Assertions.assertEquals(4, pairs.size());
    }
}