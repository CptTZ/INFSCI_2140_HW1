import PreProcessData.WordTokenizer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.LinkedList;

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
        List<String> allTok = new LinkedList<>();
        while ((tok = this.wt.nextWord()) != null) {
            allTok.add(String.valueOf(tok));
            System.out.println(tok);
        }
        assertTrue(allTok.contains("anti"));
        assertTrue(allTok.contains("Iraq"));
        assertTrue(allTok.contains("was"));
        assertFalse(allTok.contains("anti-Iraq"));
    }

}
