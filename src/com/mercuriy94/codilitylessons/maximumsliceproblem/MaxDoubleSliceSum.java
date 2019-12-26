package com.mercuriy94.codilitylessons.maximumsliceproblem;

/**
 * A non-empty array A consisting of N integers is given.
 * <p>
 * A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.
 * <p>
 * The sum of double slice (X, Y, Z) is the
 * total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].
 * <p>
 * For example, array A such that:
 * <p>
 * A[0] = 3
 * A[1] = 2
 * A[2] = 6
 * A[3] = -1
 * A[4] = 4
 * A[5] = 5
 * A[6] = -1
 * A[7] = 2
 * contains the following example double slices:
 * <p>
 * double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
 * double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
 * double slice (3, 4, 5), sum is 0.
 * The goal is to find the maximal sum of any double slice.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N integers, returns the maximal sum of any double slice.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 3
 * A[1] = 2
 * A[2] = 6
 * A[3] = -1
 * A[4] = 4
 * A[5] = 5
 * A[6] = -1
 * A[7] = 2
 * the function should return 17, because no double slice of array A has a sum of greater than 17.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [3..100,000];
 * each element of array A is an integer within the range [−10,000..10,000].
 * <p>
 * RESULT:
 * Task Score - 100%
 * Correctness - 100%
 * Performance - 100%
 *
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
