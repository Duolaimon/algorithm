/**
 * Leetcode - smallest_string_with_swaps
 */
package com.duol.leetcode.y21.m1.d11.no1202.smallest_string_with_swaps;

import java.util.*;

import com.duol.common.*;

/**
 *
 */
class Solution1 implements Solution {

    private Map<Integer, Integer> parent;
    private Map<Integer, int[]> parentIndexes;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        parent = new HashMap<>(s.length());
        parentIndexes = new HashMap<>(s.length());
        for (List<Integer> pair : pairs) {
            merge(s, pair.get(0), pair.get(1));
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            Integer iPar = find(s, i);
            int[] array = parentIndexes.get(iPar);
            res.append(getMin(array));
        }
        return res.toString();
    }

    private char getMin(int[] array) {
        for (int i = 0; i < 26; i++) {
            if (array[i] > 0) {
                array[i]--;
                return (char) (i + 'a');
            }
        }
        return ' ';
    }

    private void merge(String s, Integer a, Integer b) {
        Integer aPar = find(s, a);
        Integer bPar = find(s, b);
        if (Objects.equals(aPar, bPar)) {
            return;
        }
        parent.put(aPar, bPar);
        mergeIndexes(aPar, bPar);
    }

    private Integer find(String s, Integer a) {
        if (!parent.containsKey(a)) {
            parent.put(a, a);
            int[] array = new int[26];
            array[s.charAt(a) - 'a']++;
            parentIndexes.put(a, array);
        }
        Integer par = parent.get(a);
        if (!Objects.equals(par, a)) {
            Integer relPar = find(s, par);
            parent.put(a, relPar);

        }
        return parent.get(a);
    }

    private void mergeIndexes(Integer a, Integer b) {
        int[] arrayB = parentIndexes.get(b);
        int[] arrayA = parentIndexes.get(a);
        for (int i = 0; i < 26; i++) {
            arrayB[i] += arrayA[i];
        }
    }
}
