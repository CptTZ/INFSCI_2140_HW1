import PreProcessData.WordTokenizer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class WordTokenizerTest {

    private WordTokenizer wt;

    @Test
    @BeforeEach
    void initTest() {
        this.wt = new WordTokenizer("anti-Iraq coalition during the Gulf crisis, was symbolized by the".toCharArray());
    }

    @Test
    void tokenTest() {
        char[] tok;
        ArrayList<char[]> allTok = new ArrayList<>();
        while ((tok = this.wt.nextWord()) != null) {
            allTok.add(tok);
            System.out.println(tok);
        }
        assertTrue(allTok.contains("anti".toCharArray()));
        assertTrue(allTok.contains("Iraq".toCharArray()));
        assertTrue(allTok.contains("was".toCharArray()));
        assertFalse(allTok.contains("anti-Iraq".toCharArray()));
    }

}
