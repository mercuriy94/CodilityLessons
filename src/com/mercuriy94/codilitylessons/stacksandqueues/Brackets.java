package com.mercuriy94.codilitylessons.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
 * <p>
 * S is empty;
 * S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(String S); }
 * <p>
 * that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
 * <p>
 * For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]",
 * the function should return 0, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..200,000];
 * string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
 * <p>
 * RESULT:
 * Task Score - 100%
 * Correctness - 100%
 * Performance - 100%
 *
 * @author Nikita Marsyukov
 */
public class Brackets {

    public static void main(String[] args) {

        String s1 = "{[()()]}";
        String s2 = "([)()]";
        String s3 = "{";
        String s4 = ")";
        String s5 = "";

        System.out.println(solution(s1));
        System.out.println(solution(s2));
        System.out.println(solution(s3));
        System.out.println(solution(s4));
        System.out.println(solution(s5));

    }

    public static int solution(String S) {
        int N = S.length();

        if (N % 2 != 0) return 0;

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {

            char value = S.charAt(i);

            if (value == '{' || value == '[' || value == '(') {
                stack.push(value);
            } else if (!stack.isEmpty()) {
                char prevValue = stack.pop();
                if (prevValue == '{' && value != '}' ||
                        prevValue == '[' && value != ']' ||
                        prevValue == '(' && value != ')') {
                    stack.push(value);
                    break;
                }

            } else {
                stack.push(value);
                break;
            }

        }


        return stack.isEmpty() ? 1 : 0;
    }

}
