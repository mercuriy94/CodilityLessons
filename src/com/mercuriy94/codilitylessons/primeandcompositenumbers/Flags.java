package com.mercuriy94.codilitylessons.primeandcompositenumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * A non-empty array A consisting of N integers is given.
 * <p>
 * A peak is an array element which is larger than its neighbours.
 * More precisely, it is an index P such that 0 < P < N − 1 and A[P − 1] < A[P] > A[P + 1].
 * <p>
 * For example, the following array A:
 * <p>
 * A[0] = 1
 * A[1] = 5
 * A[2] = 3
 * A[3] = 4
 * A[4] = 3
 * A[5] = 4
 * A[6] = 1
 * A[7] = 2
 * A[8] = 3
 * A[9] = 4
 * A[10] = 6
 * A[11] = 2
 * has exactly four peaks: elements 1, 3, 5 and 10.
 * <p>
 * You are going on a trip to a range of mountains whose relative heights are represented by array A,
 * as shown in a figure below. You have to choose how many flags you should take with you.
 * The goal is to set the maximum number of flags on the peaks, according to certain rules.
 * <p>
 * <p>
 * <p>
 * Flags can only be set on peaks. What's more, if you take K flags,
 * then the distance between any two flags should be greater than or equal to K.
 * The distance between indices P and Q is the absolute value |P − Q|.
 * <p>
 * For example, given the mountain range represented by array A, above, with N = 12, if you take:
 * <p>
 * two flags, you can set them on peaks 1 and 5;
 * three flags, you can set them on peaks 1, 5 and 10;
 * four flags, you can set only three flags, on peaks 1, 5 and 10.
 * You can therefore set a maximum of three flags in this case.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A of N integers, returns the maximum number of
 * flags that can be set on the peaks of the array.
 * <p>
 * For example, the following array A:
 * <p>
 * A[0] = 1
 * A[1] = 5
 * A[2] = 3
 * A[3] = 4
 * A[4] = 3
 * A[5] = 4
 * A[6] = 1
 * A[7] = 2
 * A[8] = 3
 * A[9] = 4
 * A[10] = 6
 * A[11] = 2
 * the function should return 3, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..400,000];
 * each element of array A is an integer within the range [0..1,000,000,000].
 * <p>
 * RESULT:
 * Task Score - 100%
 * Correctness - 100%
 * Performance - 100%
 *
 * @author Nikita Marsyukov
 */
public class Flags {

    public static void main(String[] args) {

        System.out.println(solution(new int[]{1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}));
        System.out.println(solution(new int[]{0, 0, 0, 0, 0, 1, 0, 1, 0, 1}));
        System.out.println(solution(new int[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 1}));
        System.out.println(solution(new int[]{1, 3, 2}));
        System.out.println(solution(new int[]{1, 3, 2, 3, 2}));
        System.out.println(solution(new int[]{1, 3, 2, 3, 2, 3, 2}));
        System.out.println(solution(new int[]{1, 1, 1, 3, 2, 3, 2}));
        System.out.println(solution(new int[]{1}));
        System.out.println(solution(new int[]{1, 1, 1, 1, 2, 1, 1, 2, 1}));
//
        System.out.println("Корректно:");
//
        System.out.println(badPerformanceSolution(new int[]{1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}));
        System.out.println(badPerformanceSolution(new int[]{0, 0, 0, 0, 0, 1, 0, 1, 0, 1}));
        System.out.println(badPerformanceSolution(new int[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 1}));
        System.out.println(badPerformanceSolution(new int[]{1, 3, 2}));
        System.out.println(badPerformanceSolution(new int[]{1, 3, 2, 3, 2}));
        System.out.println(badPerformanceSolution(new int[]{1, 3, 2, 3, 2, 3, 2}));
        System.out.println(badPerformanceSolution(new int[]{1, 1, 1, 3, 2, 3, 2}));
        System.out.println(badPerformanceSolution(new int[]{1}));
        System.out.println(badPerformanceSolution(new int[]{1, 1, 1, 1, 2, 1, 1, 2, 1}));

    }

    public static int solution(int[] A) {

        int N = A.length;
        boolean[] peaks = new boolean[N];

        for (int i = 1; i < N - 1; i++) {
            peaks[i] = A[i] > A[i - 1] && A[i] > A[i + 1];
        }

        int[] nextPeaks = new int[N];
        nextPeaks[N - 1] = -1;

        for (int i = N - 2; i > -1; i--) {
            nextPeaks[i] = peaks[i] ? i : nextPeaks[i + 1];
        }

        long i = 1;
        int result = 0;
        while ((i - 1) * i <= N) {

            int pos = 0, num = 0;

            while (pos < N && num < i) {
                pos = nextPeaks[pos];
                if (pos == -1) break;
                num++;
                pos += i;
            }

            i++;
            result = Math.max(result, num);

        }

        return result;
    }


    public static int badPerformanceSolution(int[] A) {
        List<Integer> peakIndices = new ArrayList<>();

        int N = A.length;

        for (int i = 1; i < N - 1; i++) {

            int prev = A[i - 1];
            int cur = A[i];
            int next = A[i + 1];

            if (cur > prev && cur > next) {
                peakIndices.add(i);
                i++;
            }

        }

        int peakIndicesCount = peakIndices.size();
        int maxFlagsCount = 0;

        for (int i = peakIndicesCount - 1; i >= 0; i--) {

            int flagsCount = i + 1;
            int j = peakIndicesCount - 1;
            int peakIndex = peakIndices.get(j);
            int lastFlagIndex = peakIndex;
            int count = flagsCount - 1;

            while (count > 0 && j >= 0 && count <= (j + 1)) {

                peakIndex = peakIndices.get(j);

                if (lastFlagIndex - peakIndex >= flagsCount) {
                    count--;
                    lastFlagIndex = peakIndex;
                }

                j--;

            }

            if (count == 0) {
                maxFlagsCount = flagsCount;
                break;
            }

        }


        return maxFlagsCount;
    }

}
