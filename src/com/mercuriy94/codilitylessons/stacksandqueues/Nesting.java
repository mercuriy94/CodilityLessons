package com.mercuriy94.codilitylessons.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * A string S consisting of N characters is called properly nested if:
 * <p>
 * S is empty;
 * S has the form "(U)" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, string "(()(())())" is properly nested but string "())" isn't.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(String S); }
 * <p>
 * that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.
 * <p>
 * For example, given S = "(()(())())", the function should return 1 and given S = "())",
 * the function should return 0, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..1,000,000];
 * string S consists only of the characters "(" and/or ")".
 * <p>
 * RESULT:
 * Task Score - 100%
 * Correctness - 100%
 * Performance - 100%
 *
 * @author Nikita Marsyukov
 */
public class Nesting {

    public static void main(String[] args) {

        System.out.println(solution("(()(())())"));
        System.out.println(solution("())"));
    }

    public static int solution(String S) {

        int N = S.length();

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {

            char value = S.charAt(i);

            if (value == '(') {
                stack.push(value);
            } else if (!stack.isEmpty()) {
                if (stack.pop() != '(') {
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
