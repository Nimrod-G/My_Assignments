package codility;

import java.util.Stack;

/**
 * Created by Nimrod Golan on 15/09/2016.
 */
public class Brackets {

    public int solution(String S) {
        if (S.length() == 0) {
            return 1;
        } else if (S.length() == 1) {
            return 0;
        } else {
            if (S.charAt(0) == ')' || S.charAt(0) == ']' || S.charAt(0) == '}') {
                return 0;
            } else {
                int counter = 0;
                Stack<Character> stack = new Stack<>();

                for (int i=0; i < S.length(); i++) {
                    if (S.charAt(i) == ')') {
                        if (counter == 0) {
                            return 0;
                        }
                        if (stack.peek() == '(') {
                            stack.pop();
                            counter--;
                        } else {
                            return 0;
                        }
                    } else if (S.charAt(i) == ']') {
                        if (stack.peek() == '[') {
                            stack.pop();
                            counter--;
                        } else {
                            return 0;
                        }
                    } else if (S.charAt(i) == '}') {
                        if (stack.peek() == '{') {
                            stack.pop();
                            counter--;
                        } else {
                            return 0;
                        }
                    } else {
                        stack.push(S.charAt(i));
                        counter++;
                    }
                }
                if (stack.isEmpty()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Brackets brackets = new Brackets();
        int solution = brackets.solution("())(()");
        int q = 0;
    }
}
