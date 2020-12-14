/**
 * Leetcode - group_anagrams
 */
package com.duol.leetcode.y20.m12.d14.no49.group_anagrams;

import java.util.*;

import com.duol.common.*;

/**
 * 对每个字符串排序
 * O(N*M*logM)
 */
class Solution1 implements Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sortedMap = new HashMap<>(strs.length);
        for (String str : strs) {
            String sortedStr = sortedStr(str);
            List<String> sameStrs;
            if (sortedMap.containsKey(sortedStr)) {
                sameStrs = sortedMap.get(sortedStr);
            } else {
                sameStrs = new ArrayList<>();
            }
            sameStrs.add(str);
            sortedMap.put(sortedStr, sameStrs);
        }

        return new ArrayList<>(sortedMap.values());
    }

    private String sortedStr(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}
