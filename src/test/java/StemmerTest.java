import static org.junit.jupiter.api.Assertions.assertEquals;

import Classes.Stemmer;
import org.junit.jupiter.api.Test;

class StemmerTest {

    @Test
    void basicStemmerTest() {
        Stemmer s = new Stemmer();
        char[] word = "distention".toCharArray();
        s.add(word, word.length);
        s.stem();
        assertEquals(s.toString(), "distent");
    }

}
