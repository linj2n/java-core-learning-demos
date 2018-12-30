package cn.linj2n.javacore.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class MapInterfaceTest {

    private List<String> words;

    private Map<String, Integer> map;

    @Before
    public void setUp() throws Exception {
        words = new ArrayList<>(Arrays.asList("if","it","is","to","be","it","is","up","to","me","to","delegate"));
    }

    @Test
    public void putAndGet() {
        map = new HashMap<>();
        words.forEach(word -> {
            Integer freq = map.get(word);
            map.put(word, (freq == null) ? 1 : freq + 1);
        });
        System.out.print("countsByString: " + map);     //  countsByString: {delegate=1, be=1, me=1, is=2, it=2, to=3, up=1, if=1}
    }
}
