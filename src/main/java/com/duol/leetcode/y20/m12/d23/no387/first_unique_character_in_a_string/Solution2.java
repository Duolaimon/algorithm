/**
 * Leetcode - first_unique_character_in_a_string
 */
package com.duol.leetcode.y20.m12.d23.no387.first_unique_character_in_a_string;
import java.util.*;
import com.duol.common.*;

/** 
 *
 */
class Solution2 implements Solution {

    public int firstUniqChar(String s){
        for (int i = 0; i < s.length(); i++)
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i)))
                return i;
        return -1;
    }

}
