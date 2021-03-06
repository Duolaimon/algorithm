/**
 * Leetcode - valid.parentheses.nesting.depth
 */
package com.duol.leetcode.y20.before.valid.parentheses.nesting.depth;

/**
 * 我假设你已经做过上面的题目了，知道需要用栈辅助判断。题面中的depth其实就是栈的最大深度。
 * “你需要从中选出任意一组有效括号字符串 A 和 B，使 max(depth(A), depth(B)) 的可能取值最小”。
 * 这句话其实相当于让A字符串和B字符串的depth尽可能的接近。为什么呢？因为seq对应的栈上，每个左括号都对应一个深度，
 * 而这个左括号，要么是A的，要么是B的。所以，栈上的左括号只要按奇偶分配给A和B就可以啦！
 * 时间复杂度很明显是 O(n)O(n)的，空间复杂度也是O(n)O(n)（如果算返回的变量的话）。
 */
class Solution1 implements Solution {

    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int [seq.length()];
        int idx = 0;
        for(char c: seq.toCharArray()) {
            ans[idx++] = c == '(' ? idx & 1 : ((idx + 1) & 1);
        }
        return ans;
    }

}
