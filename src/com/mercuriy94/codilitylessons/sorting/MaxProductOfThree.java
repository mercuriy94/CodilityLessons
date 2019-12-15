package com.mercuriy94.codilitylessons.sorting;

import java.util.Arrays;

/**
 * @author Nikita Marsyukov
 */
public class MaxProductOfThree {

    public static void main(String[] args) {
        int[] testData1 = {-3, 1, 2, -2, 5, 6};
        int[] testData2 = {-3, -1, -1, -2, -5, -6};
        int[] testData3 = {-4, -2, 3, 5};
        System.out.println(solution(testData1));
        System.out.println(solution(testData2));
        System.out.println(solution(testData3));
    }

    public static int solution(int[] A) {
        Arrays.sort(A);
        return Math.max(A[0] * A[1] * A[A.length - 1], A[A.length - 1] * A[A.length - 2] * A[A.length - 3]);
    }

}
