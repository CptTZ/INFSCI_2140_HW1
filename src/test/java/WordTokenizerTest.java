import PreProcessData.WordTokenizer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class WordTokenizerTest {

    private WordTokenizer wt, wt1, wt2, wt3, wt4, wt5, wt6;

    @Test
    @BeforeEach
    void initTest() {
        this.wt = new WordTokenizer("anti-Iraq coalition during the Gulf crisis, was symbolized by the".toCharArray());
        this.wt1 = new WordTokenizer("1,600\ngovernment officials".toCharArray());
        this.wt2 = new WordTokenizer("Acknowledgments \n \n  Why Hypermess?".toCharArray());
        this.wt3 = new WordTokenizer("&gt;      January to March 2004 I'm so".toCharArray());
    }

    @Test
    void token1Test() {
        List<String> allTok = extractTokens(this.wt);
        assertTrue(allTok.contains("anti"));
        assertTrue(allTok.contains("Iraq"));
        assertTrue(allTok.contains("was"));
        assertFalse(allTok.contains("anti-Iraq"));
    }

    @Test
    void token2Test() {
        List<String> allTok = extractTokens(this.wt1);
        assertTrue(allTok.contains("government"));
        assertFalse(allTok.contains("600"));
        assertFalse(allTok.contains("1"));
        assertFalse(allTok.contains("600government"));
    }

    @Test
    void token3Test() {
        List<String> allTok = extractTokens(this.wt2);
        assertEquals(allTok.size(), 3);
        assertTrue(allTok.contains("Acknowledgments"));
        assertTrue(allTok.contains("Why"));
        assertTrue(allTok.contains("Hypermess"));
    }

    @Test
    void token4Test() {
        List<String> allTok = extractTokens(this.wt3);
        assertEquals(allTok.size(), 5);
        assertTrue(allTok.contains("January"));
        assertTrue(allTok.contains("I'm"));
        assertFalse(allTok.contains("2004"));
        assertFalse(allTok.contains("&gt"));
    }

    private List<String> extractTokens(WordTokenizer wt) {
        char[] tok;
        List<String> allTok = new LinkedList<>();
        while ((tok = wt.nextWord()) != null) {
            allTok.add(String.valueOf(tok));
            // System.out.println(tok);
        }
        return allTok;
    }

}
