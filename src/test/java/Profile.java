import PreProcessData.TrectextCollection;
import PreProcessData.TrecwebCollection;

/**
 * Class for running profile tools such as VisualVM
 */
public class Profile {

    public static void main(String... args) throws Exception {
        System.err.println("Started running");
        long ttCount = 0, twCount = 0;
        TrectextCollection tt = new TrectextCollection();
        TrecwebCollection tw = new TrecwebCollection();
        for (; tt.nextDocument() != null; ttCount++) ;
        for (; tw.nextDocument() != null; twCount++) ;
        System.out.println(String.format("Text Count:%d\nWeb Count:%d", ttCount, twCount));
    }

}
