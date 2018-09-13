package cn.linj2n.javacore.string;

import java.util.*;

/*893. Groups of Special-Equivalent Strings FROM: https://leetcode.com/problems/groups-of-special-equivalent-strings/description/

You are given an array A of strings.

Two strings S and T are special-equivalent if after any number of moves, S == T.

A move consists of choosing two indices i and j with i % 2 == j % 2, and swapping S[i] with S[j].

Now, a group of special-equivalent strings from A is a non-empty subset S of A such that any string not in S is not special-equivalent with any string in S.

Return the number of groups of special-equivalent strings from A.
*/
public class GroupsOfSpecialEquivalentStrings {
    public int numSpecialEquivGroups(String[] A) {
        return numSpecialEquivGroupsWithCollections(A);
    }
    private int numSpecialEquivGroupsWithCollections(String[] strings) {
        Set<String> set = new HashSet<>();
        for (String string: strings) {
            List<Character> evenChars = new ArrayList<>();
            List<Character> oddChars = new ArrayList<>();

            // 1. string split into two list: even \ odd.
            for (int i = 0; i < string.length(); i++) {
                if (i % 2 == 0) {
                    evenChars.add(string.charAt(i));
                } else {
                    oddChars.add(string.charAt(i));
                }
            }

            // 2. sorting list .
            Collections.sort(evenChars);
            Collections.sort(oddChars);

            // 3. concating two char list .
            StringBuilder sb = new StringBuilder();
            for (Character c: evenChars) {
                sb.append(c);
            }
            for (Character c: oddChars) {
                sb.append(c);
            }
            // 4 add the final sorted string to set.
            set.add(sb.toString());
        }
        return set.size();
    }
}
