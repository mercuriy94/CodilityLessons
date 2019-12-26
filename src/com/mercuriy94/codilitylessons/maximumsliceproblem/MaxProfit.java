package com.mercuriy94.codilitylessons.maximumsliceproblem;

/**
 * @author Nikita Marsyukov
 */
public class MaxProfit {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{23171, 21011, 21123, 21366, 21013, 21367}));
    }

    public static int solution(int[] A) {

        int N = A.length;

        int min = Integer.MAX_VALUE;
        int maxSum = 0;

        for (int i = 0; i < N; i++) {

            int value = A[i];

            if (value < min) {
                min = value;
            } else {
                maxSum = Math.max(maxSum, value - min);
            }

        }

        return maxSum;
    }

}
