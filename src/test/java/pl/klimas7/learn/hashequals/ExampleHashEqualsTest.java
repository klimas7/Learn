package pl.klimas7.learn.hashequals;

import org.testng.annotations.Test;

import java.util.HashMap;

import static org.testng.Assert.*;

/**
 * Created by bklimas on 14.02.16.
 */
public class ExampleHashEqualsTest {
    @Test
    public void putInHashMap()
    {
        ExampleHashEquals exA = new ExampleHashEquals("A", Integer.valueOf(1));
        ExampleHashEquals exB = new ExampleHashEquals("A", Integer.valueOf(2));
        ExampleHashEquals exC = new ExampleHashEquals("A", Integer.valueOf(3));

        HashMap<ExampleHashEquals, Integer> map = new HashMap<ExampleHashEquals, Integer>();
        map.put(exA,Integer.valueOf(1));
        map.put(exB,Integer.valueOf(2));
        map.put(exC,Integer.valueOf(3));

        assertEquals(3,map.size());
    }

    @Test
    public void removeFromHashMap()
    {
        ExampleHashEquals exA = new ExampleHashEquals("A", Integer.valueOf(1));
        ExampleHashEquals exB = new ExampleHashEquals("A", Integer.valueOf(2));
        ExampleHashEquals exC = new ExampleHashEquals("A", Integer.valueOf(3));

        HashMap<ExampleHashEquals, Integer> map = new HashMap<ExampleHashEquals, Integer>();
        map.put(exA,Integer.valueOf(1));
        map.put(exB,Integer.valueOf(2));
        map.put(exC,Integer.valueOf(3));

        assertEquals(3,map.size());

        ExampleHashEquals exD = new ExampleHashEquals("A", Integer.valueOf(3));

        map.remove(exD);

        assertEquals(2,map.size());
    }
}