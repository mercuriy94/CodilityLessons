package com.mercuriy94.codilitylessons.maximumsliceproblem;

/**
 * A non-empty array A consisting of N integers is given.
 * A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A.
 * The sum of a slice (P, Q) is the total of A[P] + A[P+1] + ... + A[Q].
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns the maximum sum of any slice of A.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 3  A[1] = 2  A[2] = -6
 * A[3] = 4  A[4] = 0
 * the function should return 5 because:
 * <p>
 * (3, 4) is a slice of A that has sum 4,
 * (2, 2) is a slice of A that has sum −6,
 * (0, 1) is a slice of A that has sum 5,
 * no other slice of A has sum greater than (0, 1).
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..1,000,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000];
 * the result will be an integer within the range [−2,147,483,648..2,147,483,647].
 * <p>
 * RESULT:
 * Task Score - 100%
 * Correctness - 100%
 * Performance - 100%
 *
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
