package lz77;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.LinkedList;
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

            LinkedList<LengthDistancePair> pairs = new LinkedList<>();

            while (buffer.getLookAheadSize() != 0) {
                Prefix prefix = buffer.longestPrefix();
                for (int i=0; i < prefix.getLength(); i++) {
                    buffer.shift();
                }
                pairs.add(new LengthDistancePair(buffer.at(buffer.getSearchSize()), prefix.getOffset(), prefix.getLength()));
                buffer.shift();
            }

            return pairs;
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
