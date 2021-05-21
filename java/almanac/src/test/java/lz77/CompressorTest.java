package lz77;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompressorTest {

    @Test
    public void compressionWillReturnEmptyListOfLengthDistancePairsIfRecevingEmptyStringAsInput () {
        Compressor compressor = new Compressor();

        List<LengthDistancePair> pairs = compressor.compress("");

        Assertions.assertTrue(pairs.isEmpty());
    }
}