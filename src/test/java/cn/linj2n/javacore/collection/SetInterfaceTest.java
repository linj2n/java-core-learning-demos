package cn.linj2n.javacore.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class SetInterfaceTest {

    private List<String> words;

    private Set<String> stoogesHashSet;

    private Set<String> stoogesTreeSet;

    @Before
    public void prepare() {
        stoogesHashSet = new HashSet<>(Arrays.asList("Larry", "Moe", "Curly"));
        stoogesTreeSet = new TreeSet<>(Arrays.asList("Larry", "Moe", "Curly"));
        words = new ArrayList<>(Arrays.asList("i", "came", "i", "saw", "i", "left"));
    }

    @Test
    public void equals() {
        assertTrue(stoogesHashSet.equals(stoogesTreeSet));
    }

    @Test
    public void constructors() {
        // distinct words using constructor
        Set<String> distinctWords = new HashSet<>(words);
        assertEquals(4,distinctWords.size());
        System.out.println("distinct words: " + distinctWords); // distinct words: [left, came, saw, i]
    }

    @Test
    public void bulkOperations() {
        // find all words that occur only once and more than once
        // eg. words = {"i", "came", "i", "saw", "i", "left"}, uniques = {"came","saw","left"}, dups = {"i"}
        Set<String> uniques = new HashSet<>();
        Set<String> dups = new HashSet<>();
        words.forEach(word -> {
            if (!uniques.add(word)) {
                dups.add(word);
            }
        });
        uniques.removeAll(dups);
        assertEquals(3, uniques.size());
        assertEquals(1,dups.size());
        System.out.println("uniques: " + uniques);    // uniques: [left, came, saw]
        System.out.println("dups:    " + dups);       // dups:    [i]
    }



}