package com.mercuriy94.codilitylessons.prefixsums;

import java.util.HashMap;
import java.util.Map;

/**
 * A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N,
 * is called a slice of array A (notice that the slice contains at least two elements).
 * The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice.
 * To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
 * <p>
 * For example, array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 2
 * A[2] = 2
 * A[3] = 5
 * A[4] = 1
 * A[5] = 5
 * A[6] = 8
 * contains the following example slices:
 * <p>
 * slice (1, 2), whose average is (2 + 2) / 2 = 2;
 * slice (3, 4), whose average is (5 + 1) / 2 = 3;
 * slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
 * The goal is to find the starting position of a slice whose average is minimal.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N integers,
 * returns the starting position of the slice with the minimal average.
 * If there is more than one slice with a minimal average,
 * you should return the smallest starting position of such a slice.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 2
 * A[2] = 2
 * A[3] = 5
 * A[4] = 1
 * A[5] = 5
 * A[6] = 8
 * the function should return 1, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−10,000..10,000].
 * <p>
 * RESULT:
 * Task Score - 100%
 * Correctness - 100%
 * Performance - 100%
 *
 * @author Nikita Marsyukov
 */
public class MinAvgTwoSlice {

    public static void main(String[] args) {
        int[] testData1 = {4, 2, 2, 5, 1, 5, 8};
        System.out.println(solution(testData1));
    }

    public static int solution(int[] A) {

        int N = A.length, result = 0;
        float minAvg = Integer.MAX_VALUE;

        for (int i = 0; i < N - 2; i++) {

            float avg1 = (A[i] + A[i + 1]) / 2f;
            float avg2 = (A[i] + A[i + 1] + A[i + 2]) / 3f;

            float avg = Math.min(avg1, avg2);

            if (avg < minAvg) {
                minAvg = avg;
                result = i;
            }

        }

        float avg = (A[N - 1] + A[N - 2]) / 2f;
        if (avg < minAvg) {
            result = N - 2;
        }

        return result;
    }

}
