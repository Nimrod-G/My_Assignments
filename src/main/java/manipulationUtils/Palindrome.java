package manipulationUtils;

/**
 * Created by Nimrod Golan on 10/08/2016.
 */
public class Palindrome {

    public static boolean isPalindrome(int number) {
        int i = reverseNumber(number);

        return i == number;
    }

    public static boolean isPalindrome(String string) {
        int firstIndex = 0;
        int lastIndex = string.length()-1;

        while (firstIndex <= lastIndex) {
            if (string.charAt(firstIndex) == string.charAt(lastIndex)) {
                firstIndex++;
                lastIndex--;
            } else {
                return false;
            }
        }
        return true;
    }

    private static int reverseNumber(int number) {
        int reverseNum = 0;
        int moduloVal = 0;

        while (number != 0) {
            moduloVal = number%10;
            reverseNum = reverseNum * 10 + moduloVal;
            number = number/10;
        }
        return reverseNum;
    }

    public static void main(String[] args) {
        boolean isPalindrome = isPalindrome(31113);
        System.out.println(isPalindrome);

        boolean isPalindromeString = isPalindrome("aooa");
        System.out.println(isPalindromeString);
    }
}
