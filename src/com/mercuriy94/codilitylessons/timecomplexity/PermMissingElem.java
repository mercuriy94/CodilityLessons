package com.mercuriy94.codilitylessons.timecomplexity;

import java.util.Arrays;

/**
 * An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)],
 * which means that exactly one element is missing.
 * <p>
 * Your goal is to find that missing element.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A, returns the value of the missing element.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 2
 * A[1] = 3
 * A[2] = 1
 * A[3] = 5
 * the function should return 4, as it is the missing element.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..100,000];
 * the elements of A are all distinct;
 * each element of array A is an integer within the range [1..(N + 1)].
 * <p>
 * RESULT:
 * Task Score - 100%
 * Correctness - 100%
 * Performance - 100%
 *
 * @author Nikita Marsyukov
 */
public class PermMissingElem {

    public static void main(String[] args) {
        int[] testData1 = {2, 3, 1, 5};
        int[] testData2 = {2, 3, 4, 5};
        int[] testData3 = {1};
        int[] testData4 = new int[0];

        System.out.println(solution(testData1));
        System.out.println(solution(testData2));
        System.out.println(solution(testData3));
        System.out.println(solution(testData4));
    }

    public static int solution(int[] A) {

        Arrays.sort(A);

        int prevValue = 0;

        for (int i = 0, count = A.length; i < count; i++) {
            int value = A[i];

            if (value - prevValue > 1) {
                break;
            }

            prevValue = value;
        }

        return ++prevValue;
    }

}
