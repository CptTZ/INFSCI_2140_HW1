import static org.junit.jupiter.api.Assertions.assertEquals;

import Classes.Stemmer;
import PreProcessData.WordNormalizer;
import org.junit.jupiter.api.Test;

class WordNormalizerTest {

    private WordNormalizer wn = new WordNormalizer();

    @Test
    void basicStemmerTest() {
        String s = wn.stem("distention".toCharArray());
        assertEquals(s, "distent");
    }

    @Test
    void basicLowerCaseTest() {
        // TODO: Can't find a way to test Java.lang
        String t = String.valueOf(wn.lowercase(new char[]{'A','E','@',' ', 'g'}));
        assertEquals(t,"ae@ g");
    }

}
