import PreProcessData.WordTokenizer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class WordTokenizerTest {

    private WordTokenizer wt,wt1,wt2;

    @Test
    @BeforeEach
    void initTest() {
        this.wt = new WordTokenizer("anti-Iraq coalition during the Gulf crisis, was symbolized by the".toCharArray());
        this.wt1 = new WordTokenizer("1,600\ngovernment officials".toCharArray());
    }

    @Test
    void token1Test() {
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

    @Test
    void token2Test() {
        char[] tok;
        List<String> allTok = new LinkedList<>();
        while ((tok = this.wt1.nextWord()) != null) {
            allTok.add(String.valueOf(tok));
            System.out.println(tok);
        }
        assertTrue(allTok.contains("government"));
        assertFalse(allTok.contains("600"));
        assertFalse(allTok.contains("1"));
        assertFalse(allTok.contains("600government"));
    }

}
