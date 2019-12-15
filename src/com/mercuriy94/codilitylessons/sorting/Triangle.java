package com.mercuriy94.codilitylessons.sorting;

import java.util.Arrays;

/**
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
