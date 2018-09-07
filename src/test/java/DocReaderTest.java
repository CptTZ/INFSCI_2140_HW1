import Classes.Util;
import PreProcessData.TrectextCollection;
import PreProcessData.TrecwebCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class DocReaderTest {

    TrectextCollection tt;
    TrecwebCollection tw;

    @Test
    @BeforeEach
    void initCollectionTest() {
        try {
            this.tt = new TrectextCollection();
        } catch (IOException io) {
            fail("TrectextCollection init failed!\n" + Util.expectionToFullString(io));
        }
        try {
            this.tw = new TrecwebCollection();
        } catch (IOException io) {
            fail("TrecwebCollection init failed\n" + Util.expectionToFullString(io));
        }
    }

    @Test
    void WebReadTest() {
        try {
            var d1 = this.tw.nextDocument();
            var d2 = this.tw.nextDocument();
            var d1id = d1.keySet().iterator().next();
            var d2id = d2.keySet().iterator().next();
            assertEquals(d1id, "lists-000-0000000");
            assertEquals(d2id, "lists-000-0012197");
            assertTrue(((String) d1.get(d1id)).contains("February-March 1997: Development of a Perl script/hypermail (1.x)"));
            assertTrue(((String) d2.get(d2id)).contains("daigo matsubara"));
            // No HTML tags
            assertFalse(((String) d1.get(d1id)).contains("href=\"http://www.hypermail.org/\">"));
            assertFalse(((String) d2.get(d2id)).contains("</candidate-0022>"));
        } catch (IOException o) {
            fail("TrecwebCollection read failed\n" + Util.expectionToFullString(o));
        } catch (Exception e) {
            fail("TrecwebCollection failed\n" + Util.expectionToFullString(e));
        }
    }

    @Test
    void TextReadTest() {
        try {
            var d1 = this.tt.nextDocument();
            var d2 = this.tt.nextDocument();
            var d1id = d1.keySet().iterator().next();
            var d2id = d2.keySet().iterator().next();
            assertEquals(d1id, "XIE19960101.0001");
            assertEquals(d2id, "XIE19960101.0002");
            assertTrue(((String) d1.get(d1id)).contains("accomplishment of Jordan's foreign policy."));
            assertTrue(((String) d2.get(d2id)).contains("Kuwait, invaded by Iraq in 1990, has not"));
        } catch (IOException o) {
            fail("TrectextCollection read failed\n" + Util.expectionToFullString(o));
        } catch (Exception e) {
            fail("TrectextCollection failed\n" + Util.expectionToFullString(e));
        }
    }

}
