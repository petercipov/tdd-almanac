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
    public void compressorShouldReturnSingleLengthDistancePairForSingleCharInput () {
        List<LengthDistancePair> pairs = compressor.compress("a");
        Assertions.assertEquals(1, pairs.size());
        LengthDistancePair pair = pairs.get(0);
        Assertions.assertEquals(0, pair.getPrefix().getOffset());
        Assertions.assertEquals(0, pair.getPrefix().getLength());
        Assertions.assertEquals('a', pair.getNext());
    }
}