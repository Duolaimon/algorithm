/**
 * Leetcode - num_rook_captures
 */
package com.duol.leetcode.num_rook_captures;

import java.util.*;

import com.duol.common.*;

/**
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */
class Solution1 implements Solution {

    public int numRookCaptures(char[][] board) {
        int n = 0;
        int x = -1, y = -1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                }
            }
        }
        for (int i = x; i >= 0; i--) {
            if (board[i][y] == 'p') {
                n++;
                break;
            }
            if (board[i][y] == 'B') {
                break;
            }
        }
        for (int i = x; i < board.length; i++) {
            if (board[i][y] == 'p') {
                n++;
                break;
            }
            if (board[i][y] == 'B') {
                break;
            }
        }
        for (int j = y; j >= 0; j--) {
            if (board[x][j] == 'p') {
                n++;
                break;
            }
            if (board[x][j] == 'B') {
                break;
            }
        }
        for (int j = y; j < board.length; j++) {
            if (board[x][j] == 'p') {
                n++;
                break;
            }
            if (board[x][j] == 'B') {
                break;
            }
        }
        return n;
    }

}
