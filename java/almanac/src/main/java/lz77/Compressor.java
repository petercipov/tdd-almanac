package lz77;

import java.util.List;

public class Compressor {

    public List<LengthDistancePair> compress(String input) {
        if (input.isEmpty()) {
            return List.of();
        } else {
            return List.of(new LengthDistancePair(input.charAt(0)));
        }
    }
}
