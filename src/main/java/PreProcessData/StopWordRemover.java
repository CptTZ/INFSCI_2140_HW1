package PreProcessData;


import Classes.Util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class StopWordRemover {

    /**
     * Set of stop words
     */
    private Set<String> stopWords;

    public StopWordRemover() {
        this.stopWords = new HashSet<>();
        try {
            initStopWords(Classes.Path.StopwordDir);
        } catch (IOException e) {
            System.err.println(Util.expectionToFullString(e));
        }
    }

    /**
     * // Return true if the input word is a stopword, or false if not.
     */
    public boolean isStopword(char[] word) {
        return this.stopWords.contains(String.valueOf(word));
    }

    /**
     * Load and store the stop words from the fileinputstream with appropriate data structure.
     *
     * @param path StopWords DB dir
     */
    private void initStopWords(String path) throws IOException {
        Path p = Paths.get(".//" + path);
        // Auto-close
        try (Stream<String> lines = Files.lines(p)) {
            lines.forEach(s -> this.stopWords.add(s.trim()));
        }
    }
}
