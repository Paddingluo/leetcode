package com.phorse.monkey.leetcode.interview;

import com.phorse.monkey.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Auther: luo
 * @Date: 2020/3/6 15:05
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= target <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InterView57_Solution {

    public static int[][] findContinuousSequence(int target) {
        // 滑动窗口的左边界
        int i = 1;
        // 滑动窗口的右边界
        int j = 1;
        // 滑动窗口中数字的和
        int sum = 0;
        List<int[]> res = new ArrayList<>();

        while (i <= target / 2) {
            if (sum < target) {
                // 右边界向右移动
                sum += j;
                j++;
            } else if (sum > target) {
                // 左边界向右移动
                sum -= i;
                i++;
            } else {
                // 记录结果
                int[] arr = new int[j - i];
                for (int k = i; k < j; k++) {
                    arr[k - i] = k;
                }
                res.add(arr);
                // 左边界向右移动
                sum -= i;
                i++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {

        int[][] continuousSequence = findContinuousSequence(4);
        ArrayUtils.printArr(continuousSequence);
    }

}
