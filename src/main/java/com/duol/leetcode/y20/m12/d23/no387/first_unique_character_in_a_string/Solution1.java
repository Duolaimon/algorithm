/**
 * Leetcode - first_unique_character_in_a_string
 */
package com.duol.leetcode.y20.m12.d23.no387.first_unique_character_in_a_string;
import java.util.*;
import com.duol.common.*;

/** 
 *
 */
class Solution1 implements Solution {

    public int firstUniqChar(String s){
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

}
