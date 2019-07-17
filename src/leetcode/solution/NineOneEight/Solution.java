package leetcode.solution.NineOneEight;

public class Solution {

    public int maxSubarraySumCircular(int[] A) {
        int maxValue = Integer.MIN_VALUE, sum = 0, maxSumSoFar = 0, minSumSoFar = 0,
                maxSum = 0, minSum = 0;

        //获取sum和最大值
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (maxValue <= A[i]) maxValue = A[i];
        }

        if (maxValue > 0) {

            for (int i = 0; i < A.length; i++) {
                maxSumSoFar = (maxSumSoFar + A[i]) > A[i] ? maxSumSoFar + A[i] : A[i];
                if (maxSumSoFar > maxSum) maxSum = maxSumSoFar;

                minSumSoFar = (minSumSoFar + A[i]) < A[i] ? minSumSoFar + A[i] : A[i];
                if (minSumSoFar < minSum) minSum = minSumSoFar;
            }

            return maxSum > (sum - minSum) ? maxSum : (sum - minSum);
        } else
            return maxValue;
    }
}