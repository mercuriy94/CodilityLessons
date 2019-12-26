package com.mercuriy94.codilitylessons.stacksandqueues;

import java.util.*;

/**
 * You are going to build a stone wall. The wall should be straight and N meters long, and its thickness
 * should be constant; however, it should have different heights in different places. The height of the
 * wall is specified by an array H of N positive integers. H[I] is the height of the wall from I to I+1
 * meters to the right of its left end. In particular, H[0] is the height of the wall's left end
 * and H[N−1] is the height of the wall's right end.
 * <p>
 * The wall should be built of cuboid stone blocks (that is, all sides of such blocks are rectangular).
 * Your task is to compute the minimum number of blocks needed to build the wall.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] H); }
 * <p>
 * that, given an array H of N positive integers specifying the height of the wall, returns the minimum number
 * of blocks needed to build it.
 * <p>
 * For example, given array H containing N = 9 integers:
 * <p>
 * H[0] = 8    H[1] = 8    H[2] = 5
 * H[3] = 7    H[4] = 9    H[5] = 8
 * H[6] = 7    H[7] = 4    H[8] = 8
 * the function should return 7. The figure shows one possible arrangement of seven blocks.
 * <p>
 * <p>
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array H is an integer within the range [1..1,000,000,000].
 * <p>
 * RESULT:
 * Task Score - 100%
 * Correctness - 100%
 * Performance - 100%
 *
 * @author Nikita Marsyukov
 */
public class StoneWall {

    public static void main(String[] args) {

        System.out.println(solution(new int[]{8, 8, 5, 7, 9, 8, 7, 4, 8}));

    }

    public static int solution(int[] H) {

        int N = H.length, result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {

            int value = H[i];

            while (!stack.isEmpty() && stack.peek() > value) {
                stack.pop();
            }

            if (stack.isEmpty() || stack.peek() < value) {
                stack.push(value);
                result++;
            }

        }

        return result;
    }

}
