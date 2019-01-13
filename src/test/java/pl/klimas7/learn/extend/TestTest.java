package pl.klimas7.learn.extend;

import org.junit.Test;

public class TestTest {
    @Test
    public void test() {
        ExtendedList extendedList = new ExtendedList();
        ErrorListBoxModel errorListBoxModel = extendedList.get();
        System.out.println(errorListBoxModel.getErrors().size());
    }
}