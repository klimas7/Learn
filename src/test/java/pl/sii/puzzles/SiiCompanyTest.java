package pl.sii.puzzles;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SiiCompanyTest {
    @Test
    public void getDescriptionTest() {
        // given
        SiiCompany siiCompany = new SiiCompany();
        // when
        String description = siiCompany.getDescription();
        // then
        String expected = "...";
        assertEquals(expected, description);
    }
}