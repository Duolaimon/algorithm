/**
 * Leetcode - dota2_senate
 */
package com.duol.leetcode.y20.m12.d11.no649.dota2_senate;

import java.util.*;

import com.duol.common.*;

/**
 *
 */
class Solution2 implements Solution {

    public String predictPartyVictory(String senate) {
        return predictPartyVictory(senate, 0, 0);
    }

    public String predictPartyVictory(String senate, int radiant, int dire) {
        int n = senate.length();
        StringBuilder stringBuilder = new StringBuilder();
        boolean radiantWin = true;
        boolean direWin = true;
        for (int i = 0; i < n; i++) {
            char c = senate.charAt(i);
            if (c == 'R') {
                if (dire > 0) {
                    dire--;
                } else {
                    radiant++;
                    stringBuilder.append(c);
                    direWin = false;
                }
            } else {
                if (radiant > 0) {
                    radiant--;
                } else {
                    dire++;
                    stringBuilder.append(c);
                    radiantWin = false;
                }
            }
        }
        if (radiantWin) {
            return "Radiant";
        } else if (direWin) {
            return "Dire";
        } else {
            return predictPartyVictory(stringBuilder.toString(), radiant, dire);
        }
    }

}
