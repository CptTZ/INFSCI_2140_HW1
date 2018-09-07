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
public class TrectextCollection implements DocumentCollection {

    /**
     * Path for TrecText documents
     */
    private Path trecTextPath;

    /**
     * Stream-based TrecText line-by-line data
     */
    private Stream<String> trecTextString;

    /**
     * Initialize this class with data defined from Classes.Path
     */
    public TrectextCollection() throws IOException {
        this.trecTextPath = Paths.get(".//" + Classes.Path.DataTextDir);
        this.trecTextString = Files.lines(this.trecTextPath, Util.nioUTF8Charset);
    }

    @Override
    public Map<String, Object> nextDocument() throws IOException {
        // 1. When called, this API processes one document from corpus, and returns its doc number and content.
        // 2. When no document left, return null, and close the file.
        return null;
    }

}
