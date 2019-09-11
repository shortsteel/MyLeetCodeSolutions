package leetcode.solution.p918;

public class Solution {

    public int maxSubarraySumCircular(int[] A) {
        int maxValue = -30000, sum = 0, maxSumSoFar = 0, minSumSoFar = 0,
                maxSum = 0, minSum = 0;

        //获取sum和最大值
        for (int value : A) {
            sum += value;
            if (maxValue <= value) maxValue = value;
        }

        //分情况处理
        if (maxValue > 0) {

            for (int value : A) {
//                maxSumSoFar = (maxSumSoFar + value) > value ? maxSumSoFar + value : value;
                if (maxSumSoFar > 0)
                    maxSumSoFar += value;
                else
                    maxSumSoFar = value;
                if (maxSumSoFar > maxSum) maxSum = maxSumSoFar;

//                minSumSoFar = (minSumSoFar + value) < value ? minSumSoFar + value : value;
                if (minSumSoFar < 0)
                    minSumSoFar += value;
                else
                    minSumSoFar = value;
                if (minSumSoFar < minSum) minSum = minSumSoFar;
            }

            return maxSum > (sum - minSum) ? maxSum : (sum - minSum);
        } else
            return maxValue;
    }
}