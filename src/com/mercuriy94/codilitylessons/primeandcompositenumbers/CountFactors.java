package com.mercuriy94.codilitylessons.primeandcompositenumbers;


/**
 * A positive integer D is a factor of a positive integer N if there exists an integer M such that N = D * M.
 * <p>
 * For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int N); }
 * <p>
 * that, given a positive integer N, returns the number of its factors.
 * <p>
 * For example, given N = 24, the function should return 8, because 24 has 8 factors,
 * namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of 24.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..2,147,483,647].
 * <p>
 * RESULT:
 * Task Score - 100%
 * Correctness - 100%
 * Performance - 100%
 *
 * @author Nikita Marsyukov
 */
public class CountFactors {

    public static void main(String[] args) {
        System.out.println(solution(24));
    }

    public static int solution(int N) {

        long i = 1;
        int result = 0;

        while (i * i < N) {

            if (N % i == 0) {
                result += 2;
            }
            i++;

        }

        if (i * i == N) {
            result++;
        }

        return result;
    }


}
