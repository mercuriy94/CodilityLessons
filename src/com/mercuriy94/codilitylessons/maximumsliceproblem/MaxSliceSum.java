package com.mercuriy94.codilitylessons.maximumsliceproblem;

/**
 * @author Nikita Marsyukov
 */
public class MaxSliceSum {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 2, -6, 4, 0}));
        System.out.println(solution(new int[]{-10}));
        System.out.println(solution(new int[]{-2, 1}));
        System.out.println(solution(new int[]{-10, -45}));
    }

    public static int solution(int[] A) {
        int N = A.length, maxEnding, maxEndingPrevious = A[0], maxSlices = A[0];

        for (int i = 1; i < N; i++) {
            maxEnding = Math.max(A[i], maxEndingPrevious + A[i]);
            maxEndingPrevious = maxEnding;
            maxSlices = Math.max(maxEnding, maxSlices);
        }

        return maxSlices;
    }

}
