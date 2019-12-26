package com.mercuriy94.codilitylessons.primeandcompositenumbers;


/**
 * An integer N is given, representing the area of some rectangle.
 * <p>
 * The area of a rectangle whose sides are of length A and B is A * B, and the perimeter is 2 * (A + B).
 * <p>
 * The goal is to find the minimal perimeter of any rectangle whose area equals N.
 * The sides of this rectangle should be only integers.
 * <p>
 * For example, given integer N = 30, rectangles of area 30 are:
 * <p>
 * (1, 30), with a perimeter of 62,
 * (2, 15), with a perimeter of 34,
 * (3, 10), with a perimeter of 26,
 * (5, 6), with a perimeter of 22.
 * Write a function:
 * <p>
 * class Solution { public int solution(int N); }
 * <p>
 * that, given an integer N, returns the minimal perimeter of any rectangle whose area is exactly equal to N.
 * <p>
 * For example, given an integer N = 30, the function should return 22, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..1,000,000,000].
 * <p>
 * RESULT:
 * Task Score - 100%
 * Correctness - 100%
 * Performance - 100%
 *
 * @author Nikita Marsyukov
 */
public class MinPerimeterRectangle {

    public static void main(String[] args) {
        System.out.println(solution(30));
        System.out.println(solution(36));
        System.out.println(solution(48));
    }

    public static int solution(int N) {

        long i = 1;
        int minPerimeter = (N + 1) * 2;

        while (i * i < N) {

            if (N % i == 0) {
                minPerimeter = Math.min(minPerimeter, (int) (i + N / i) * 2);
            }

            i++;
        }
        if (i * i == N) {
            minPerimeter = Math.min(minPerimeter, (int) (i + N / i) * 2);
        }
        return minPerimeter;
    }

}
