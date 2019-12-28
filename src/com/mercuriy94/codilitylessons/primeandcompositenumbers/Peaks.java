package com.mercuriy94.codilitylessons.primeandcompositenumbers;

import java.util.*;

/**
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

        List<Integer> pickIndexes = new ArrayList<>();
        List<Integer> divisors = new ArrayList<>();

        int N = A.length;

        for (int i = 1; i < N - 1; i++) {

            int prev = A[i - 1];
            int cur = A[i];
            int next = A[i + 1];

            if (cur > prev && cur > next) {
                pickIndexes.add(i);
            }


            if (N % i == 0 && i != 1) {

                divisors.add(i);
                divisors.add(N / i);

            }


        }

        if (pickIndexes.size() == 0) return 0;

        int maxCountBlocks = 0;


        divisors.sort(Integer::compareTo);

        int prevDivisors = -1;
        int divisorsCount = divisors.size();

        for (int q = 0; q < divisorsCount; q++) {

            int divisor = divisors.get(q);
            int countBlocks = N / divisor;

            if(divisor == prevDivisors) continue;;

            prevDivisors = divisor;

            int startBlockIndex = 0;
            int endBlockIndex = divisor - 1;

            int count = N / divisor;

            int j = 0;
            int pickIndex = pickIndexes.get(j);

            while (j < pickIndexes.size() && pickIndex <= endBlockIndex) {

                if (pickIndex >= startBlockIndex && pickIndex <= endBlockIndex) {
                    count--;
                    startBlockIndex += divisor;
                    endBlockIndex += divisor;
                }

                j++;

                if (j < pickIndexes.size()) {
                    pickIndex = pickIndexes.get(j);
                }

            }

            if (count == 0) {
                maxCountBlocks = countBlocks;
                break;
            }

        }

        return maxCountBlocks != 0 ? maxCountBlocks : pickIndexes.size() != 0 ? 1 : 0;
    }

}
