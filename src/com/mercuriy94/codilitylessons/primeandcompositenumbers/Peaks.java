package com.mercuriy94.codilitylessons.primeandcompositenumbers;

import java.util.*;

/**
 * A non-empty array A consisting of N integers is given.
 * <p>
 * A peak is an array element which is larger than its neighbors. More precisely,
 * it is an index P such that 0 < P < N − 1,  A[P − 1] < A[P] and A[P] > A[P + 1].
 * <p>
 * For example, the following array A:
 * <p>
 * A[0] = 1
 * A[1] = 2
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
 * has exactly three peaks: 3, 5, 10.
 * <p>
 * We want to divide this array into blocks containing the same number of elements.
 * More precisely, we want to choose a number K that will yield the following blocks:
 * <p>
 * A[0], A[1], ..., A[K − 1],
 * A[K], A[K + 1], ..., A[2K − 1],
 * ...
 * A[N − K], A[N − K + 1], ..., A[N − 1].
 * What's more, every block should contain at least one peak.
 * Notice that extreme elements of the blocks (for example A[K − 1] or A[K]) can also be peaks,
 * but only if they have both neighbors (including one in an adjacent blocks).
 * <p>
 * The goal is to find the maximum number of blocks into which the array A can be divided.
 * <p>
 * Array A can be divided into blocks as follows:
 * <p>
 * one block (1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2). This block contains three peaks.
 * two blocks (1, 2, 3, 4, 3, 4) and (1, 2, 3, 4, 6, 2). Every block has a peak.
 * three blocks (1, 2, 3, 4), (3, 4, 1, 2), (3, 4, 6, 2). Every block has a peak.
 * Notice in particular that the first block (1, 2, 3, 4) has a peak at A[3],
 * because A[2] < A[3] > A[4], even though A[4] is in the adjacent block.
 * However, array A cannot be divided into four blocks, (1, 2, 3), (4, 3, 4), (1, 2, 3) and (4, 6, 2),
 * because the (1, 2, 3) blocks do not contain a peak.
 * Notice in particular that the (4, 3, 4) block contains two peaks: A[3] and A[5].
 * <p>
 * The maximum number of blocks that array A can be divided into is three.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N integers,
 * returns the maximum number of blocks into which A can be divided.
 * <p>
 * If A cannot be divided into some number of blocks, the function should return 0.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 1
 * A[1] = 2
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
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [0..1,000,000,000].
 * <p>
 * RESULT:
 * Task Score - 100%
 * Correctness - 100%
 * Performance - 100%
 *
 * @author Nikita Marsyukov
 */
public class Peaks {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}));
        System.out.println(solution(new int[]{0, 1, 0, 0, 1, 0, 0, 1, 0}));
        System.out.println(solution(new int[]{1, 3, 2, 1}));
        System.out.println(solution(new int[]{5}));
    }

    public static int solution(int[] A) {

        List<Integer> peakIndices = new ArrayList<>();
        List<Integer> divisors1 = new ArrayList<>();
        List<Integer> divisors2 = new ArrayList<>();

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

        long i = 1;

        while (i * i <= N) {

            if (N % i == 0) {
                divisors1.add((int) i);
                divisors2.add(N / (int) i);
            }

            i++;

        }

        List<Integer> divisors = divisors1;

        if (peakIndices.size() == 0) return 0;

        int maxCountBlocks = 0;

        int prevDivisors = -1;

        int plus = 1;

        for (int q = 0; q >= 0; q += plus) {

            if (q == divisors.size()) {
                divisors = divisors2;
                plus = -1;
                continue;
            }

            int divisor = divisors.get(q);
            int countBlocks = N / divisor;

            if (divisor == prevDivisors || countBlocks > peakIndices.size()) continue;

            prevDivisors = divisor;

            int startBlockIndex = 0;
            int endBlockIndex = divisor - 1;

            int count = N / divisor;

            int j = 0;
            int peakIndex = peakIndices.get(j);

            while (j < peakIndices.size() && peakIndex <= endBlockIndex) {

                if (peakIndex >= startBlockIndex && peakIndex <= endBlockIndex) {
                    count--;
                    startBlockIndex += divisor;
                    endBlockIndex += divisor;
                }

                j++;

                if (j < peakIndices.size()) {
                    peakIndex = peakIndices.get(j);
                }

            }

            if (count == 0) {
                maxCountBlocks = countBlocks;
                break;
            }


        }

        return maxCountBlocks != 0 ? maxCountBlocks : 1;
    }

}
