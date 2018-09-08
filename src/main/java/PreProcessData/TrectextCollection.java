package PreProcessData;

import Classes.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * This is for INFSCI 2140 in 2018
 */
public class TrectextCollection implements DocumentCollection {

    /**
     * Path for TrecText documents
     */
    private Path trecTextPath;

    /**
     * Buffered-reader for TrecText
     */
    private BufferedReader trecTextReader;

    private Pattern docNoPattern;

    /**
     * Initialize this class with data defined from Classes.Path
     */
    public TrectextCollection() throws IOException {
        this.trecTextPath = Paths.get(".//" + Classes.Path.DataTextDir);
        this.trecTextReader = Files.newBufferedReader(this.trecTextPath, Util.nioUTF8Charset);
        this.docNoPattern = Util.docNoPattern;
    }

    /**
     * When called, this API processes one document from corpus, and returns its doc number and content.
     * When no document left, return null, and close the file.
     */
    @Override
    public Map<String, Object> nextDocument() throws IOException {
        String data;

        while ((data = this.trecTextReader.readLine()) != null) {
            // Locate the document start
            if (!data.equals("<DOC>")) continue;
            Map<String, Object> thisDocument = new HashMap<>();
            StringBuilder sb = new StringBuilder();
            String thisDocNo = "Unknown";
            // Read while reaches the end of this document
            while (!(data = this.trecTextReader.readLine()).equals("</DOC>")) {
                Matcher m = this.docNoPattern.matcher(data);
                if (m.matches()) thisDocNo = m.group(1).trim();
                // Text data begins
                if (data.equals("<TEXT>")) {
                    while (!(data = this.trecTextReader.readLine()).equals("</TEXT>")) {
                        sb.append(data.trim());
                    }
                }
            }
            thisDocument.put(thisDocNo, sb.toString().toCharArray());
            // Finished reading document, return it
            return thisDocument;
        }

        // File empty, should close
        this.trecTextReader.close();
        return null;
    }

}
