package com.phorse.monkey.leetcode.leetcode100_200;

/**
 * @Description:
 * @Auther: luo
 * @Date: 2020/3/9 00:08
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test121_Solution {

    public static int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int price = 0;
        for (int i = 0; i <= prices.length - 2; i++) {
            for (int j = i + 1; j <= prices.length - 1 && prices[j] > prices[i]; j++) {
                price = Math.max(price, prices[j] - prices[i]);
            }
        }
        return price;
    }

    /**
     * 仅遍历1次，将最大收益每天计算
     */
    public static int maxProfit1(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit1(new int[]{2, 5, 1, 3}));
    }
}
