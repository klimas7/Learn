package pl.klimas7.learn.lang;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.text.StrTokenizer;
import org.junit.Test;

public class StringTokenizerTest {

    @Test
    public void temporaryStringTokenizer() {

        String text = "A\nB\nC";
        StrTokenizer st = new StrTokenizer(text);
        st.nextToken(); //A

        assertEquals("B", st.nextToken());
        assertEquals("B", st.previousToken());
        assertEquals("B", st.nextToken());
    }
}
