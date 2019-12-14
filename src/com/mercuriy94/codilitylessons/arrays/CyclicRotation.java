package com.mercuriy94.codilitylessons.arrays;


import java.util.Arrays;

/**
 * An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by
 * one index, and the last element of the array is moved to the first place. For example, the rotation of
 * array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7]
 * (elements are shifted right by one index and 6 is moved to the first place).
 * <p>
 * The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int[] solution(int[] A, int K); }
 * <p>
 * that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.
 * <p>
 * For example, given
 * A = [3, 8, 9, 7, 6]
 * K = 3
 * <p>
 * the function should return [9, 7, 6, 3, 8]. Three rotations were made:
 * [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
 * [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
 * [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
 * <p>
 * For another example, given
 * A = [0, 0, 0]
 * K = 1
 * the function should return [0, 0, 0]
 * <p>
 * Given
 * A = [1, 2, 3, 4]
 * K = 4
 * the function should return [1, 2, 3, 4]
 * <p>
 * Assume that:
 * <p>
 * N and K are integers within the range [0..100];
 * each element of array A is an integer within the range [−1,000..1,000].
 * In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 * <p>
 * RESULT:
 * Task Score - 100%
 * Correctness - 100%
 * Performance - Not assessed
 *
 * @author Nikita Marsyukov
 */
public class CyclicRotation {

    public static void main(String[] args) {
        int[] testData1 = {3, 8, 9, 7, 6};
        System.out.println(Arrays.toString(solution(testData1, 8)));
    }

    public static int[] solution(int[] A, int K) {

        int N = A.length;

        if (N == 0) {
            return A;
        }

        int realK = K >= N ? K % N : K;

        int[] result = new int[N];

        for (int i = 0; i < N; i++) {

            int newIndex = i + realK;
            if (newIndex > N - 1) {
                newIndex = newIndex - N;
            }

            result[newIndex] = A[i];

        }

        return result;
    }

}
