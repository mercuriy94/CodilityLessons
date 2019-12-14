package com.mercuriy94.codilitylessons.countingelements;

import java.util.Arrays;

/**
 * This is a demo task.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A of N integers, returns the smallest positive integer
 * (greater than 0) that does not occur in A.
 * <p>
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * <p>
 * Given A = [1, 2, 3], the function should return 4.
 * <p>
 * Given A = [−1, −3], the function should return 1.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 * <p>
 * RESULT:
 * Task Score - 100%
 * Correctness - 100%
 * Performance - 100%
 *
 * @author Nikita Marsyukov
 */
public class MissingInteger {

    public static void main(String[] args) {

        int[] testData1 = {1, 3, 6, 4, 1, 2};
        int[] testData2 = {1, 2, 3};
        int[] testData3 = {-1, -3};

        System.out.println(solution(testData1));
        System.out.println(solution(testData2));
        System.out.println(solution(testData3));

    }

    public static int solution(int[] A) {

        Arrays.sort(A);

        int N = A.length, result = -1, prevValue = 0;

        for (int i = 0; i < N; i++) {

            int value = A[i];

            if (value > 0) {

                if (value - prevValue > 1) {
                    result = prevValue + 1;
                    break;
                }

                prevValue = value;

            }

        }

        return result == -1 ? prevValue == 0 ? 1 : prevValue + 1 : result;
    }

}
