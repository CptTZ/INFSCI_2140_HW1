package PreProcessData;

import Classes.*;

import java.util.Locale;

/**
 * This is for INFSCI 2140 in 2018
 */
public class WordNormalizer {

    /**
     * Transform the word uppercase characters into lowercase.
     */
    public char[] lowercase(char[] chars) {
        return String.valueOf(chars).toLowerCase(Locale.US).toCharArray();
    }

    /**
     * Return the stemmed word with Stemmer in Classes package.
     */
    public String stem(char[] chars) {
        Stemmer stemmer = new Stemmer();
        stemmer.add(chars, chars.length);
        stemmer.stem();
        return stemmer.toString();
    }

}
