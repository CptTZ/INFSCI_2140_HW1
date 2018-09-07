import PreProcessData.StopWordRemover;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StopWordTest {

    private StopWordRemover swr;

    @Test
    @BeforeEach
    void initStopWord() {
        this.swr = new StopWordRemover();
        assertNotNull(this.swr);
    }

    @Test
    void correctnessTest() {
        assertTrue(this.swr.isStopword("normally".toCharArray()));
        assertTrue(this.swr.isStopword("zero".toCharArray()));
        assertTrue(this.swr.isStopword("a".toCharArray()));
        assertTrue(this.swr.isStopword("x".toCharArray()));
        assertFalse(this.swr.isStopword("obvious".toCharArray()));
        assertFalse(this.swr.isStopword("computer".toCharArray()));
        assertFalse(this.swr.isStopword("news".toCharArray()));
    }

}
