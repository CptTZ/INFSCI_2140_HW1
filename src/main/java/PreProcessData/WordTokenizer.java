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
    private String wekaDelimiters = " \r\n\t.,;:'\"()?!";

    /**
     * Extra delimiters by inferring results
     */
    private String extraDelimiters = "-";

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
        if (this.sTokenizer.hasMoreTokens()) {
            return this.sTokenizer.nextToken().toCharArray();
        } else {
            return null;
        }
    }

}
