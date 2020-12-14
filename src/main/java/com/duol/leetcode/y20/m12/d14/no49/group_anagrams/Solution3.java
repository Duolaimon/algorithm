package com.duol.leetcode.y20.m12.d14.no49.group_anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * hash
 */
public class Solution3 implements Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<Long, Integer> hashIndexMap = new HashMap<>();
        int size = 0;
        for (String str : strs) {
            long hash = getHash(str);
            List<String> list;
            if (hashIndexMap.containsKey(hash)) {
                int index = hashIndexMap.get(hash);
                list = ans.get(index);
            } else {
                list = new ArrayList<>();
                ans.add(list);
                hashIndexMap.put(hash, size++);
            }
            list.add(str);
        }
        return ans;
    }

    long getHash(String str) {
        long hash = 0;
        long sum = 0;
        long prod = 1;
        for (char c : str.toCharArray()) {
            sum += c;
            prod *= c;
        }
        hash = sum + prod;
        return hash;
    }
}
