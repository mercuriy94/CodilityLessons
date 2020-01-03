package com.mercuriy94.codilitylessons.arrays;

import java.util.Arrays;

/**
 * A non-empty array A consisting of N integers is given. The array contains an odd number of elements,
 * and each element of the array can be paired with another element that has the same value, except for one
 * element that is left unpaired.
 * <p>
 * For example, in array A such that:
 * <p>
 * A[0] = 9  A[1] = 3  A[2] = 9
 * A[3] = 3  A[4] = 9  A[5] = 7
 * A[6] = 9
 * the elements at indexes 0 and 2 have value 9,
 * the elements at indexes 1 and 3 have value 3,
 * the elements at indexes 4 and 6 have value 9,
 * the element at index 5 has value 7 and is unpaired.
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers fulfilling the above conditions,
 * returns the value of the unpaired element.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 9  A[1] = 3  A[2] = 9
 * A[3] = 3  A[4] = 9  A[5] = 7
 * A[6] = 9
 * the function should return 7, as explained in the example above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an odd integer within the range [1..1,000,000];
 * each element of array A is an integer within the range [1..1,000,000,000];
 * all but one of the values in A occur an even number of times.
 * <p>
 * RESULT:
 * Task Score - 100%
 * Correctness - 100%
 * Performance - 100%
 *
 * @author Nikita Marsyukov
 */
public class OddOccurrencesInArray {

    public static void main(String[] args) {

        int[] testData1 = {9};
        int[] testData2 = {9, 3, 9, 3, 9, 7, 9};
        int[] testData3 = {1, 9, 3, 9, 3, 9, 7, 7, 9};
        int[] testData4 = {9, 3, 9, 3, 9, 7, 7, 9, 10};
        int[] testData5 = {9, 3, 9, 3, 9, 7, 7, 9, 10, 10, 5};
        int[] testData6 = {9, 3, 9, 3, 9, 7, 7, 9, 5, 8, 10, 10, 5};

//        System.out.println(solution(testData1));
//        System.out.println(solution(testData2));
//        System.out.println(solution(testData3));
//        System.out.println(solution(testData4));
//        System.out.println(solution(testData5));
//        System.out.println(solution(testData6));

//        System.out.println(solution2(testData1));
        System.out.println(solution2(testData2));
//        System.out.println(solution2(testData3));
//        System.out.println(solution2(testData4));
//        System.out.println(solution2(testData5));
//        System.out.println(solution2(testData6));

    }

    public static int solution(int[] A) {

        Arrays.sort(A);

        int N = A.length, prevValue = -1, count = 0;

        for (int i = 0; i < N; i++) {
            int value = A[i];
            if (value != prevValue) {

                if (count % 2 != 0) {
                    break;
                }
                count = 0;
            }

            count++;
            prevValue = value;

        }

        return prevValue;
    }


    public static int solution2(int[] A) {
        if (A.length == 0)
            return 0;

        int unpaired;
        unpaired = A[0]; // initial

        for (int i = 1; i < A.length; i++) {
            unpaired ^= A[i]; // xor
        }

        return unpaired; // return the unpaired value
    }

}
