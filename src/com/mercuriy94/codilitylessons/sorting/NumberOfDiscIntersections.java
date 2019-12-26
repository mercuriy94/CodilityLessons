package com.mercuriy94.codilitylessons.sorting;

import java.util.Arrays;

/**
 * We draw N discs on a plane. The discs are numbered from 0 to N − 1. An array A of N non-negative integers,
 * specifying the radiuses of the discs, is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].
 * <p>
 * We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at
 * least one common point (assuming that the discs contain their borders).
 * <p>
 * The figure below shows discs drawn for N = 6 and A as follows:
 * <p>
 * A[0] = 1
 * A[1] = 5
 * A[2] = 2
 * A[3] = 1
 * A[4] = 4
 * A[5] = 0
 * <p>
 * There are eleven (unordered) pairs of discs that intersect, namely:
 * <p>
 * discs 1 and 4 intersect, and both intersect with all the other discs;
 * disc 2 also intersects with discs 0 and 3.
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of
 * intersecting discs. The function should return −1 if the number of intersecting pairs exceeds 10,000,000.
 * <p>
 * Given array A shown above, the function should return 11, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [0..2,147,483,647].
 * <p>
 * RESULT:
 * Task Score - 100%
 * Correctness - 100%
 * Performance - 100%
 *
 * @author Nikita Marsyukov
 */
public class NumberOfDiscIntersections {

    public static void main(String[] args) {
        int[] testData1 = {1, 5, 2, 1, 4, 0};
        int[] testData2 = {0, 5, 0, 0, 4, 0};
        int[] testData3 = {4, 0, 0, 0, 1, 0};
        int[] testData4 = {1, 2};
//        System.out.println(solution(testData1));
//        System.out.println(solution(testData2));
//        System.out.println(solution(testData3));
        System.out.println(solution(testData4));
    }

    public static int solution(int[] A) {
        int N = A.length, MAX = 10_000_000;
        if (N < 2) return 0;
        long[] lefts = new long[N];
        long[] rights = new long[N];

        for (int i = 0; i < N; i++) {
            lefts[i] = i - (long) A[i];
            rights[i] = i + (long) A[i];
        }

        Arrays.sort(lefts);
        Arrays.sort(rights);

        int result = 0, j = 0;
        for (int i = 0; i < N; i++) {

            while (j < N && rights[i] >= lefts[j]) {
                result = result + j - i;
                j++;
            }
        }

        if (result > MAX) return -1;

        return result;
    }

}
