package com.mercuriy94.codilitylessons.leader;

/**
 * A non-empty array A consisting of N integers is given.
 * <p>
 * The leader of this array is the value that occurs in more than half of the elements of A.
 * <p>
 * An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and
 * A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 3
 * A[2] = 4
 * A[3] = 4
 * A[4] = 4
 * A[5] = 2
 * we can find two equi leaders:
 * <p>
 * 0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
 * 2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
 * The goal is to count the number of equi leaders.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N integers, returns the number of equi leaders.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 4
 * A[1] = 3
 * A[2] = 4
 * A[3] = 4
 * A[4] = 4
 * A[5] = 2
 * the function should return 2, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
 * <p>
 * RESULT:
 * Task Score - 100%
 * Correctness - 100%
 * Performance - 100%
 *
 * @author Nikita Marsyukov
 */
public class EquiLeader {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 3, 4, 4, 4, 2}));
        System.out.println(solution(new int[]{-1000000000, -1000000000}));
    }

    public static int solution(int[] A) {
        int N = A.length, value = 0, size = 0;

        for (int i = 0; i < N; i++) {
            if (size == 0) {
                size++;
                value = A[i];
            } else if (value != A[i]) {
                size--;
            } else {
                size++;
            }
        }

        int candidate = -1;
        if (size > 0) {
            candidate = value;
        }

        int count = 0;

        int index = -1;

        for (int i = 0; i < N; i++) {
            if (A[i] == candidate) {
                count++;
                index = i;
            }
        }

        if (count <= N / 2) {
            return 0;
        }

        int leader = A[index];

        int leftCount = 0;

        int result = 0;

        for (int i = 0; i < N; i++) {

            if (A[i] == leader) {
                leftCount++;
            }

            if (leftCount > ((i + 1) / 2) &&
                    count - leftCount > ((N - i - 1) / 2)) {
                result++;
            }

        }


        return result;
    }

}
