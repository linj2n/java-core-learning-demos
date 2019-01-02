package cn.linj2n.javacore.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class MapInterfaceTest {

    private List<String> words;

    private Map<String, Integer> hashMap = new HashMap<>();

    private Map<String, Integer> treeMap = new TreeMap<>();

    private Map<String, Integer> linkedHashMap = new LinkedHashMap<>();

    @Before
    public void setUp() throws Exception {
        words = new ArrayList<>(Arrays.asList("if","it","is","to","be","it","is","up","to","me","to","delegate"));
    }

    @Test
    public void threeDifferentImplementations_put() {
        counting(words, hashMap);
        counting(words, treeMap);
        counting(words, linkedHashMap);

        System.out.println("hash map: " + hashMap);                 // countsByString: {delegate=1, be=1, me=1, is=2, it=2, to=3, up=1, if=1}
        System.out.println("tree map: " + treeMap);                 // tree map: {be=1, delegate=1, if=1, is=2, it=2, me=1, to=3, up=1}
        System.out.println("linked hash map: " + linkedHashMap);    // linked hash map: {if=1, it=2, is=2, to=3, be=1, up=1, me=1, delegate=1}
        String str = "0P";
        System.out.println("---> " + Character.isLetter(str.charAt(0)));
    }
    private void counting(List<String> words, Map<String, Integer> map) {
        words.forEach(word -> {
            Integer freq = map.get(word);
            map.put(word, (freq == null) ? 1 : freq + 1);
        });
    }
}
