package codility;

import java.util.Stack;

/**
 * Created by Nimrod Golan on 14/09/2016.
 */
public class Nesting {
    public int solution(String S) {
        if (S.length() == 0) {
            return 1;
        } else if (S.length() == 1) {
            return 0;
        } else {
            if (S.charAt(0) == ')') {
                return 0;
            }
            Stack<Character> stack = new Stack<>();
            int counter = 0;

            for (int i=0; i < S.length(); i++) {
                if (S.charAt(i) == ')') {
                    if (counter == 0) {
                        return 0;
                    }
                    stack.pop();
                    counter--;
                } else {
                    counter++;
                    stack.push(S.charAt(i));
                }
            }
            if (stack.isEmpty()) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        String s = "(()))";
        Nesting nesting = new Nesting();
        int solution = nesting.solution(s);
        int q= 0;
    }
}
