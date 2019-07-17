package leetcode.solution.p918;

public class Solution {

    public int maxSubarraySumCircular(int[] A) {
        int maxValue = Integer.MIN_VALUE, sum = 0, maxSumSoFar = 0, minSumSoFar = 0,
                maxSum = 0, minSum = 0;

        //获取sum和最大值
        for (int value : A) {
            sum += value;
            if (maxValue <= value) maxValue = value;
        }

        if (maxValue > 0) {

            for (int value : A) {
                maxSumSoFar = (maxSumSoFar + value) > value ? maxSumSoFar + value : value;
                if (maxSumSoFar > maxSum) maxSum = maxSumSoFar;

                minSumSoFar = (minSumSoFar + value) < value ? minSumSoFar + value : value;
                if (minSumSoFar < minSum) minSum = minSumSoFar;
            }

            return maxSum > (sum - minSum) ? maxSum : (sum - minSum);
        } else
            return maxValue;
    }
}