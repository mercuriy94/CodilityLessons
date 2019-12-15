package com.mercuriy94.codilitylessons.sorting;

import java.util.Arrays;

/**
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

   /* public static int solution(int[] A) {
        int N = A.length;
        Set<Integer> distinctSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            distinctSet.add(A[i]);
        }
        return distinctSet.size();
    }*/

}
