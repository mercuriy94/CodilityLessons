package com.mercuriy94.codilitylessons.sorting;

import java.util.Arrays;

/**
 * Write a function
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns the number of distinct values in array A.
 * <p>
 * For example, given array A consisting of six elements such that:
 * <p>
 * A[0] = 2    A[1] = 1    A[2] = 1
 * A[3] = 2    A[4] = 3    A[5] = 1
 * the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 * <p>
 * RESULT:
 * Task Score - 100%
 * Correctness - 100%
 * Performance - 100%
 *
 * @author Nikita Marsyukov
 */
public class Distinct {

    public static void main(String[] args) {
        int[] testData1 = {2, 1, 1, 2, 3, 1};
        System.out.println(solution(testData1));
    }

    public static int solution(int[] A) {
        int N = A.length;

        if (N == 0) return 0;
        else if (N == 1) return 1;

        int result = 1;
        Arrays.sort(A);

        for (int i = 1; i < N; i++) {
            int value = A[i];
            int prevValue = A[i - 1];

            if (prevValue != value) result++;
        }

        return result;
    }


    /**
     * Solution #2
     * */
   /* public static int solution(int[] A) {
        int N = A.length;
        Set<Integer> distinctSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            distinctSet.add(A[i]);
        }
        return distinctSet.size();
    }*/

}
