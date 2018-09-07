package PreProcessData;

import Classes.Util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Stream;


/**
 * This is for INFSCI 2140 in 2018
 */
public class TrecwebCollection implements DocumentCollection {

    /**
     * Path for TrecWeb documents
     */
    private Path trecWebPath;

    /**
     * Stream-based TrecWeb line-by-line data
     */
    private Stream<String> trecWebString;

    /**
     * Initialize this class with data defined from Classes.Path
     */
    public TrecwebCollection() throws IOException {
        this.trecWebPath = Paths.get(".//", Classes.Path.DataWebDir);
        this.trecWebString = Files.lines(this.trecWebPath, Util.nioUTF8Charset);
    }

    @Override
    public Map<String, Object> nextDocument() throws IOException {
        // 1. When called, this API processes one document from corpus, and returns its doc number and content.
        // 2. When no document left, return null, and close the file.
        // 3. the HTML tags should be removed in document content.

        return null;
    }

}
