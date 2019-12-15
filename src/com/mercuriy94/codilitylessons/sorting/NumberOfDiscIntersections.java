package com.mercuriy94.codilitylessons.sorting;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nikita Marsyukov
 */
public class NumberOfDiscIntersections {

    public static void main(String[] args) {
        int[] testData1 = {1, 5, 2, 1, 4, 0};
        int[] testData2 = {0, 5, 0, 0, 4, 0};
        int[] testData3 = {4, 0, 0, 0, 1, 0};
        System.out.println(solution(testData1));
//        System.out.println(solution(testData2));
//        System.out.println(solution(testData3));
    }

    public static int solution(int[] A) {

        long[] lower = new long[A.length];
        long[] upper = new long[A.length];

        for (int i = 0; i < A.length; i++) {
            lower[i] = i - (long) A[i]; // note: lower = center - A[i]
            upper[i] = i + (long) A[i]; // note: upper = center + A[i]
        }

        int intersection = 0; // number of intersections

        // scan the upper points
        for (int i = 0; i < A.length; i++) {
            // note: compare "i" with "j": need to set "j=i+1" (avoid double counting)
            for (int j = i + 1; j < A.length; j++) {
                // intersection: when one's upper is bigger than "or equal to" one's lower (important)
                if (upper[i] >= lower[j]) { // note: when "equal to", there is also an intersection
                    intersection++;
                }
            }
        }

        // for the overflow cases
        if (intersection > 10_000_000)
            return -1;

        return intersection; // number of intersections
    }

}
