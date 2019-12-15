package com.mercuriy94.codilitylessons.prefixsums;

/**
 * @author Nikita Marsyukov
 */
public class CountDiv {

    public static void main(String[] args) {

        System.out.println(solution(6, 11, 2));
        System.out.println(solution(112, 136, 4));
    }

    public static int solution(int A, int B, int K) {
        int result = 0;

        if (A % K == 0) result++;

        int val1 = A / K;
        int val2 = B / K;

        result += val2 - val1;

        return result;
    }

}
