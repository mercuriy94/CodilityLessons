package com.mercuriy94.codilitylessons.prefixsums;

import java.util.Arrays;

/**
 * A DNA sequence can be represented as a string consisting of the letters A, C, G and T,
 * which correspond to the types of successive nucleotides in the sequence. Each nucleotide has an impact factor,
 * which is an integer. Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4, respectively.
 * You are going to answer several queries of the form: What is the minimal impact factor of nucleotides contained in a
 * particular part of the given DNA sequence?
 * <p>
 * The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters.
 * There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers.
 * The K-th query (0 ≤ K < M) requires you to find the minimal impact factor
 * of nucleotides contained in the DNA sequence between positions P[K] and Q[K] (inclusive).
 * <p>
 * For example, consider string S = CAGCCTA and arrays P, Q such that:
 * <p>
 * P[0] = 2    Q[0] = 4
 * P[1] = 5    Q[1] = 5
 * P[2] = 0    Q[2] = 6
 * The answers to these M = 3 queries are as follows:
 * <p>
 * The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice),
 * whose impact factors are 3 and 2 respectively, so the answer is 2.
 * The part between positions 5 and 5 contains a single nucleotide T, whose impact factor is 4, so the answer is 4.
 * The part between positions 0 and 6 (the whole string) contains all nucleotides,
 * in particular nucleotide A whose impact factor is 1, so the answer is 1.
 * Write a function:
 * <p>
 * class Solution { public int[] solution(String S, int[] P, int[] Q); }
 * <p>
 * that, given a non-empty string S consisting of N characters and two non-empty arrays P and Q consisting of M integers,
 * returns an array consisting of M integers specifying the consecutive answers to all queries.
 * <p>
 * Result array should be returned as an array of integers.
 * <p>
 * For example, given the string S = CAGCCTA and arrays P, Q such that:
 * <p>
 * P[0] = 2    Q[0] = 4
 * P[1] = 5    Q[1] = 5
 * P[2] = 0    Q[2] = 6
 * the function should return the values [2, 4, 1], as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * M is an integer within the range [1..50,000];
 * each element of arrays P, Q is an integer within the range [0..N − 1];
 * P[K] ≤ Q[K], where 0 ≤ K < M;
 * string S consists only of upper-case English letters A, C, G, T.
 * <p>
 * RESULT:
 * Task Score - 100%
 * Correctness - 100%
 * Performance - 100%
 *
 * @author Nikita Marsyukov
 */
public class GenomicRangeQuery {

    public static void main(String[] args) {

        String testData1 = "CAGCCTA";
        int P1[] = {2, 5, 0};
        int Q1[] = {4, 5, 6};
        System.out.println(Arrays.toString(solution(testData1, P1, Q1)));

        String testData2 = "ACGCCT";
        int P2[] = {0};
        int Q2[] = {5};
        System.out.println(Arrays.toString(solution(testData2, P2, Q2)));
    }

    public static int[] solution(String S, int[] P, int[] Q) {
        int N = S.length(), M = P.length;
        int[] result = new int[M];

        int A[] = new int[N + 1];
        int C[] = new int[N + 1];
        int G[] = new int[N + 1];
        int T[] = new int[N + 1];

        for (int i = 0; i < N; i++) {

            switch (S.charAt(i)) {
                case 'A': {
                    A[i + 1] = A[i] + 1;
                    C[i + 1] = C[i];
                    G[i + 1] = G[i];
                    T[i + 1] = T[i];
                    break;
                }
                case 'C': {
                    A[i + 1] = A[i];
                    C[i + 1] = C[i] + 1;
                    G[i + 1] = G[i];
                    T[i + 1] = T[i];
                    break;
                }
                case 'G': {
                    A[i + 1] = A[i];
                    C[i + 1] = C[i];
                    G[i + 1] = G[i] + 1;
                    T[i + 1] = T[i];
                    break;
                }
                case 'T': {
                    A[i + 1] = A[i];
                    C[i + 1] = C[i];
                    G[i + 1] = G[i];
                    T[i + 1] = T[i] + 1;
                    break;
                }
            }

        }

        for (int i = 0; i < M; i++) {

            int a = A[Q[i] + 1] - A[P[i]];
            int c = C[Q[i] + 1] - C[P[i]];
            int g = G[Q[i] + 1] - G[P[i]];

            if (a > 0) {
                result[i] = 1;
            } else if (c > 0) {
                result[i] = 2;
            } else if (g > 0) {
                result[i] = 3;
            } else {
                result[i] = 4;
            }

        }

        return result;
    }

}
