package lz77;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.List;

public class Compressor {

    private final Buffer buffer;

    public Compressor(Buffer buffer) {
        this.buffer = buffer;
    }

    public List<LengthDistancePair> compress(String input) {
        StringCharacterIterator iterator = new StringCharacterIterator(input);
        if (input.isEmpty()) {
            return List.of();
        } else {
            prependBuffer(iterator);
            Prefix prefix = buffer.longestPrefix();

            return List.of(new LengthDistancePair(input.charAt(0), prefix));
        }
    }

    private void prependBuffer(StringCharacterIterator iterator) {
        int lbSize = buffer.getLookAheadSize();
        for (int i=0; i< lbSize; i++) {
            char current = iterator.current();
            iterator.next();
            if(current != CharacterIterator.DONE) {
                buffer.append(current);
            } else {
                buffer.shift();
            }
        }
    }
}
