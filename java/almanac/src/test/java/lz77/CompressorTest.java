package lz77;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompressorTest {

    Compressor compressor;

    @BeforeEach
    public void before () {
        compressor = new Compressor();
    }

    @Test
    public void compressionWillReturnEmptyListOfLengthDistancePairsIfRecevingEmptyStringAsInput () {


        List<LengthDistancePair> pairs = compressor.compress("");

        Assertions.assertTrue(pairs.isEmpty());
    }
}