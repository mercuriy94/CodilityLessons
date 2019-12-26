package com.mercuriy94.codilitylessons.sorting;

import java.util.Arrays;

/**
 * An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:
 * <p>
 * A[P] + A[Q] > A[R],
 * A[Q] + A[R] > A[P],
 * A[R] + A[P] > A[Q].
 * For example, consider array A such that:
 * <p>
 * A[0] = 10    A[1] = 2    A[2] = 5
 * A[3] = 1     A[4] = 8    A[5] = 20
 * Triplet (0, 2, 4) is triangular.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns 1 if there exists a
 * triangular triplet for this array and returns 0 otherwise.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 10    A[1] = 2    A[2] = 5
 * A[3] = 1     A[4] = 8    A[5] = 20
 * the function should return 1, as explained above. Given array A such that:
 * <p>
 * A[0] = 10    A[1] = 50    A[2] = 5
 * A[3] = 1
 * the function should return 0.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 * <p>
 * RESULT:
 * Task Score - 100%
 * Correctness - 100%
 * Performance - 100%
 *
 * @author Nikita Marsyukov
 */
public class Triangle {

    public static void main(String[] args) {
        int[] testData1 = {10, 2, 5, 1, 8, 20};
        int[] testData2 = {10, 1, 50, 5, 1};
        int[] testData3 = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};

        System.out.println(solution(testData1));
        System.out.println(solution(testData2));
        System.out.println(solution(testData3));
    }

    public static int solution(int[] A) {

        int N = A.length, result = 0;

        Arrays.sort(A);

        for (int i = 0; i < N - 2; i++) {

            int P = A[i];
            int Q = A[i + 1];
            int R = A[i + 2];

            if ((long) P + Q > R &&
                    (long) Q + R > P &&
                    (long) R + P > Q) {
                result = 1;
                break;
            }

        }

        return result;
    }

}
