package PreProcessData;

import Classes.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
     * Buffered-reader for TrecWeb
     */
    private BufferedReader trecWebReader;

    private Pattern docNoPattern;


    /**
     * Initialize this class with data defined from Classes.Path
     */
    public TrecwebCollection() throws IOException {
        this.trecWebPath = Paths.get(".//", Classes.Path.DataWebDir);
        this.trecWebReader = Files.newBufferedReader(this.trecWebPath, Util.nioUTF8Charset);
        this.docNoPattern = Util.docNoPattern;
    }

    /**
     * When called, this API processes one document from corpus, and returns its doc number and content.
     * When no document left, return null, and close the file.
     * the HTML tags should be removed in document content.
     */
    @Override
    public Map<String, Object> nextDocument() throws IOException {
        String data;

        while ((data = this.trecWebReader.readLine()) != null) {
            // Locate the document start
            if (!data.equals("<DOC>")) continue;
            var thisDocument = new HashMap<String, Object>();
            StringBuilder sb = new StringBuilder();
            String thisDocNo = "Unknown";
            // Just read, determine end later
            for (; ; data = this.trecWebReader.readLine()) {
                Matcher m = this.docNoPattern.matcher(data);
                if (m.matches()) thisDocNo = m.group(1).trim();
                // Header ends and html data begins
                if (data.equals("</DOCHDR>")) {
                    while (!(data = this.trecWebReader.readLine()).equals("</DOC>")) {
                        sb.append(data.trim());
                    }
                    break;
                }
            }
            thisDocument.put(thisDocNo, removeHtmlTags(sb.toString()));
            // Finished reading document, return it
            return thisDocument;
        }

        // File empty, should close
        this.trecWebReader.close();
        return null;
    }

    /**
     * Remove tags for html
     */
    private String removeHtmlTags(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        return Util.htmlTagPattern.matcher(s).replaceAll("");
    }

}
