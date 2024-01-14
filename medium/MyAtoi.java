package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 *
 * The algorithm for myAtoi(string s) is as follows:
 *
 * Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
 * Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 * Return the integer as the final result.
 * Note:
 *
 * Only the space character ' ' is considered a whitespace character.
 * Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 *
 *
 * Example 1:
 *
 * Input: s = "42"
 * Output: 42
 * Explanation: The underlined characters are what is read in, the caret is the current reader position.
 * Step 1: "42" (no characters read because there is no leading whitespace)
 *          ^
 * Step 2: "42" (no characters read because there is neither a '-' nor '+')
 *          ^
 * Step 3: "42" ("42" is read in)
 *            ^
 * The parsed integer is 42.
 * Since 42 is in the range [-231, 231 - 1], the final result is 42.
 * Example 2:
 *
 * Input: s = "   -42"
 * Output: -42
 * Explanation:
 * Step 1: "   -42" (leading whitespace is read and ignored)
 *             ^
 * Step 2: "   -42" ('-' is read, so the result should be negative)
 *              ^
 * Step 3: "   -42" ("42" is read in)
 *                ^
 * The parsed integer is -42.
 * Since -42 is in the range [-231, 231 - 1], the final result is -42.
 * Example 3:
 *
 * Input: s = "4193 with words"
 * Output: 4193
 * Explanation:
 * Step 1: "4193 with words" (no characters read because there is no leading whitespace)
 *          ^
 * Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
 *          ^
 * Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
 *              ^
 * The parsed integer is 4193.
 * Since 4193 is in the range [-231, 231 - 1], the final result is 4193.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 200
 * s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.
 */
public class MyAtoi {
    public static int myAtoi(String s) {

        char[] arr = s.trim().toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean isIgnoreZero = true;
        // -2147483648,2147483647
        int maximumIntegerCharacter = 10;
        boolean isMinus = false;

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                if ('+' == arr[i]) {
                    continue;
                } else if ('-' == arr[i]) {
                    sb.append('-');
                    maximumIntegerCharacter += 1;
                    isMinus = true;
                    continue;
                }
            }
            if ('0' == arr[i]) {
                if (isIgnoreZero) {
                    continue;
                }
            } else {
                if (Character.isDigit(arr[i])) {
                    isIgnoreZero = false;
                }
            }

            if (arr[i] != ' ') {
                if (sb.length() < maximumIntegerCharacter - 1) {
                    sb.append(arr[i]);
                } else {
                    String temp = sb.toString() + arr[i];
                    try {
                        Integer.parseInt(temp);
                        sb.append(arr[i]);
                    } catch (NumberFormatException e) {
                        return isMinus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    }
                }
            } else {
                break;
            }
        }

        if ("".contentEquals(sb)) {
            return 0;
        }
        if (sb.length() == 1 && isMinus) {
            return 0;
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main (String[] args) {
        int result = myAtoi("-91283472332");
        System.out.println(result);
    }
}
