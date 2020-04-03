/**
 * Leetcode - game.of.life
 */
package com.duol.leetcode.game.of.life;

import java.util.*;

import com.duol.common.*;

/**
 * 输入：
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * <p>
 * [1,11,2],
 * [11,5,12],
 * [3,13,12],
 * [2,13,2]
 * <p>
 * 输出：
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 */
class Solution1 implements Solution {

    public void gameOfLife(int[][] board) {
        int[][] copy = Arrays.copyOf(board, board.length);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                for (int k = -1; k <= 1; k++) {
                    if (i + k < 0 || i + k >= board.length) {
                        continue;
                    }
                    for (int l = -1; l <= 1; l++) {
                        if (j + l < 0 || j + l >= board[i].length) {
                            continue;
                        }
                        if (board[i][j] == 1) {
                            if (k == 0 && l == 0) {
                                copy[i + k][j + l] += 9;
                            } else {
                                copy[i + k][j + l] += 1;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(copy));
    }

}
