package cn.linj2n.javacore.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class CollectionInterfaceTest {

    private Collection<String> stooges;

    @Before
    public void prepare() {
        stooges = new ArrayList<>(Arrays.asList("Larry", "Moe", "Curly"));
    }

    @Test
    public void remove_usingIterator() {
        // JDK 7 or before
        for (Iterator<String> iterator = stooges.iterator(); iterator.hasNext();) {
            if ("Moe".equals(iterator.next())) {
                iterator.remove();
            }
        }
        assertEquals(2,stooges.size());
    }

    @Test
    public void removeIf() {
        // JDK 8 or later
        stooges.removeIf(string -> string.equals("Moe"));
        assertEquals(2,stooges.size());
    }

    @Test
    public void toArray() {
        // Convert the collection to an string array.
        String[] strings = stooges.toArray(new String[0]);
        assertEquals(3,strings.length); // length: 3 , strings: {"Larry", "Moe", "Curly"}

        // Convert the collection to an object array.
        Object[] objects = stooges.toArray();   // length: 3
        assertEquals(3,objects.length);
        for (int i = 0; i < objects.length; i++) {
            String entry = (String) objects[i];
            assertTrue(entry.equals(strings[i]));
        }
    }

    @Test
    public void traversingCollectionsUsing_forEach() {
        for (String string : stooges) {
            System.out.print(string + " ");
        }  // Larry Moe Curly
    }

    @Test
    public void traversingCollectionsUsing_Iterator() {
        for (Iterator<String> it = stooges.iterator(); it.hasNext();) {
            System.out.print(it.next() + " ");
        }  // Larry Moe Curly
    }

    @Test
    public void traversingCollectionUsing_AggregateOperations() {
        stooges.forEach(e -> System.out.print(e + " "));

        String strings = stooges.stream()
                .collect(Collectors.joining(", "));
        System.out.println();
        System.out.print("strings: " + strings);  // strings: Larry, Moe, Curly
    }

}