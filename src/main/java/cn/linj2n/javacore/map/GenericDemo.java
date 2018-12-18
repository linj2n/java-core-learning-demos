package cn.linj2n.javacore.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericDemo {
    public static void main (String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");

        map.put("a", strings);
        map.get("a").forEach(s -> {
            System.out.print(s + " ");
        });
        System.out.println();

        strings = map.get("a");
        strings.add("4");

        map.get("a").forEach(s -> {
            System.out.print(s + " ");
        });
        System.out.println();

    }
}
