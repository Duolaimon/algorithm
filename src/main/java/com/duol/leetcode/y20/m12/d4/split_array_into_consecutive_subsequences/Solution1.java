/**
 * Leetcode - split_array_into_consecutive_subsequences
 */
package com.duol.leetcode.y20.m12.d4.split_array_into_consecutive_subsequences;
import java.util.*;
import com.duol.common.*;

/**
 * 从方法一可以看到，对于数组中的元素 xx，如果存在一个子序列以 x−1 结尾，则可以将 xx 加入该子序列中。
 * 将 x 加入已有的子序列总是比新建一个只包含 x 的子序列更优，因为前者可以将一个已有的子序列的长度增加 1，而后者新建一个长度为 1 的子序列，
 * 而题目要求分割成的子序列的长度都不小于 33，因此应该尽量避免新建短的子序列。
 *
 * 基于此，可以通过贪心的方法判断是否可以完成分割。
 *
 * 使用两个哈希表，第一个哈希表存储数组中的每个数字的剩余次数，第二个哈希表存储数组中的每个数字作为结尾的子序列的数量。
 *
 * 初始时，每个数字的剩余次数即为每个数字在数组中出现的次数，因此遍历数组，初始化第一个哈希表。
 *
 * 在初始化第一个哈希表之后，遍历数组，更新两个哈希表。只有当一个数字的剩余次数大于 00 时，才需要考虑这个数字是否属于某个子序列。假设当前元素是 xx，进行如下操作。
 *
 * 首先判断是否存在以 x-1x−1 结尾的子序列，即根据第二个哈希表判断 x-1x−1 作为结尾的子序列的数量是否大于 00，
 * 如果大于 00，则将元素 xx 加入该子序列中。由于 xx 被使用了一次，因此需要在第一个哈希表中将 xx 的剩余次数减 11。
 * 又由于该子序列的最后一个数字从 x-1x−1 变成了 xx，因此需要在第二个哈希表中将 x-1x−1 作为结尾的子序列的数量减 11，以及将 xx 作为结尾的子序列的数量加 11。
 *
 * 否则，x 为一个子序列的第一个数，为了得到长度至少为 3 的子序列，x+1 和 x+2 必须在子序列中，因此需要判断在第一个哈希表中 x+1x+1 和 x+2x+2 的剩余次数是否都大于 00。
 *
 * 当 x+1 和 x+2 的剩余次数都大于 0 时，可以新建一个长度为 3 的子序列 [x,x+1,x+2]。
 * 由于这三个数都被使用了一次，因此需要在第一个哈希表中将这三个数的剩余次数分别减 11。又由于该子序列的最后一个数字是 x+2x+2，因此需要在第二个哈希表中将 x+2x+2 作为结尾的子序列的数量加 11。
 *
 * 否则，无法得到长度为 33 的子序列 [x,x+1,x+2][x,x+1,x+2]，因此无法完成分割，返回 false。
 *
 * 如果整个数组遍历结束时，没有遇到无法完成分割的情况，则可以完成分割，返回 true。
 *
 */
class Solution1 implements Solution {

    public boolean isPossible(int[] nums){
        Map<Integer, Integer> numCountMap = new HashMap<>();
        Map<Integer, Integer> subsequenceLastNumCountMap = new HashMap<>();
        for (int num : nums) {
            numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (numCountMap.get(num) == 0) {
                continue;
            }
            if (subsequenceLastNumCountMap.getOrDefault(num - 1, 0) > 0) {
                // 有现成队列，追加
                numCountMap.put(num, numCountMap.get(num) - 1);
                subsequenceLastNumCountMap.put(num - 1, subsequenceLastNumCountMap.getOrDefault(num - 1, 0) - 1);
                subsequenceLastNumCountMap.put(num, subsequenceLastNumCountMap.getOrDefault(num, 0) + 1);
            } else{
                // 创建新队列
                if (numCountMap.getOrDefault(num + 1, 0) > 0 && numCountMap.getOrDefault(num + 2, 0) > 0) {
                    numCountMap.put(num, numCountMap.get(num) - 1);
                    numCountMap.put(num + 1, numCountMap.get(num + 1) - 1);
                    numCountMap.put(num + 2, numCountMap.get(num + 2) - 1);
                    subsequenceLastNumCountMap.put(num + 2, subsequenceLastNumCountMap.getOrDefault(num + 2, 0) + 1);
                } else{
                    return false;
                }
            }
        }
        return true;
    }

}
