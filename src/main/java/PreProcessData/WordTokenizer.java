package PreProcessData;

import java.util.StringTokenizer;

/**
 * This is for INFSCI 2140 in 2018
 * <p>
 * TextTokenizer can split a sequence of text into individual word tokens.
 */
public class WordTokenizer {

    private StringTokenizer sTokenizer;

    /**
     * Reference from WEKA3
     */
    private String wekaDelimiters = " \r\n\t.,;:\"()?!";

    /**
     * Extra delimiters by inferring results
     */
    private String extraDelimiters = "-+*/[]_";

    /**
     * Tokenize the input texts
     */
    public WordTokenizer(char[] texts) {
        this.sTokenizer = new StringTokenizer(
                String.valueOf(texts), this.wekaDelimiters + this.extraDelimiters);
    }

    /**
     * Output the next word
     */
    public char[] nextWord() {
        while (this.sTokenizer.hasMoreTokens()) {
            char[] cand = this.sTokenizer.nextToken().toCharArray();
            if (hasNonLetterInCharArray(cand)) continue;
            return cand;
        }
        return null;
    }

    /**
     * Filter out char array that has non-letters
     */
    private boolean hasNonLetterInCharArray(char[] test) {
        for (char cTest : test) {
            // Allow single quote as special one
            if (cTest == '\'') continue;
            if (!Character.isLetter(cTest)) {
                return true;
            }
        }
        return false;
    }

}
