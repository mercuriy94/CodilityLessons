package com.mercuriy94.codilitylessons.maximumsliceproblem;

/**
 * @author Nikita Marsyukov
 */
public class MaxDoubleSliceSum {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 2, 6, -1, 4, 5, -1, 2}));
        System.out.println(solution(new int[]{-3, -5, -4, -1, -4, -5, -1, -2}));
    }

    public static int solution(int[] A) {
        int N = A.length, maxDoubleSliceSum = 0;

        int[] leftMaxSlices = new int[N];
        int[] rightMaxSlices = new int[N];


        for (int i = 1; i < N; i++) {
            leftMaxSlices[i] = Math.max(0, leftMaxSlices[i - 1] + A[i]);
        }

        for (int i = N - 2; i >= 0; i--) {
            rightMaxSlices[i] = Math.max(0, rightMaxSlices[i + 1] + A[i]);
        }

        for (int i = 1; i < N - 1; i++) {
            int doubleSliceSum = leftMaxSlices[i - 1] + rightMaxSlices[i + 1];
            maxDoubleSliceSum = Math.max(doubleSliceSum, maxDoubleSliceSum);
        }

        return maxDoubleSliceSum;
    }

}
