/**
* Leetcode - number_of_valid_words_for_each_puzzle
*/
package com.duol.leetcode.y21.m2.d26.no1178.number_of_valid_words_for_each_puzzle;
import java.util.*;
import com.duol.common.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 1178. 猜字谜
 * 
 * 外国友人仿照中国字谜设计了一个英文版猜字谜小游戏，请你来猜猜看吧。
 *
 * 字谜的迷面puzzle 按字符串形式给出，如果一个单词word符合下面两个条件，那么它就可以算作谜底：
 *
 * 单词word中包含谜面puzzle的第一个字母。
 * 单词word中的每一个字母都可以在谜面puzzle中找到。
 * 例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；而 "beefed"（不含字母 "a"）以及"based"（其中的 "s" 没有出现在谜面中）。
 * 返回一个答案数组answer，数组中的每个元素answer[i]是在给出的单词列表 words 中可以作为字谜迷面puzzles[i]所对应的谜底的单词数目。
 *
 * 
 *
 * 示例：
 *
 * 输入：
 * words = ["aaaa","asas","able","ability","actt","actor","access"],
 * puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
 * 输出：[1,1,3,2,4,0]
 * 解释：
 * 1 个单词可以作为 "aboveyz" 的谜底 : "aaaa"
 * 1 个单词可以作为 "abrodyz" 的谜底 : "aaaa"
 * 3 个单词可以作为 "abslute" 的谜底 : "aaaa", "asas", "able"
 * 2 个单词可以作为"absoryz" 的谜底 : "aaaa", "asas"
 * 4 个单词可以作为"actresz" 的谜底 : "aaaa", "asas", "actt", "access"
 * 没有单词可以作为"gaswxyz" 的谜底，因为列表中的单词都不含字母 'g'。
 * 
 *
 * 提示：
 *
 * 1 <= words.length <= 10^5
 * 4 <= words[i].length <= 50
 * 1 <= puzzles.length <= 10^4
 * puzzles[i].length == 7
 * words[i][j], puzzles[i][j]都是小写英文字母。
 * 每个puzzles[i]所包含的字符都不重复。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-valid-words-for-each-puzzle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
interface Solution {

// use this Object to print the log (call from slf4j facade)
static Logger log = LoggerFactory.getLogger(Solution.class);

    List<Integer> findNumOfValidWords(String[] words, String[] puzzles);
}
