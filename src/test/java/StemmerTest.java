import static org.junit.jupiter.api.Assertions.assertEquals;

import Classes.Stemmer;
import org.junit.jupiter.api.Test;

class StemmerTest {

    @Test
    void basicStemmerTest() {
        var s = new Stemmer();
        var word = "distention".toCharArray();
        s.add(word, word.length);
        s.stem();
        assertEquals(s.toString(), "distent");
    }

}
