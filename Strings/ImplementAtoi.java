/*
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit
 * signed integer (similar to C/C++'s atoi function).
 * 
 * The algorithm for myAtoi(string s) is as follows:
 * 
 * Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-'
 * or '+'. Read this character in if it is either. This determines if the final
 * result is negative or positive respectively. Assume the result is positive if
 * neither is present.
 * Read in next the characters until the next non-digit character or the end of
 * the input is reached. The rest of the string is ignored.
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no
 * digits were read, then the integer is 0. Change the sign as necessary (from
 * step 2).
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1],
 * then clamp the integer so that it remains in the range. Specifically,
 * integers less than -231 should be clamped to -231, and integers greater than
 * 231 - 1 should be clamped to 231 - 1.
 * Return the integer as the final result.
 * Note:
 * 
 * Only the space character ' ' is considered a whitespace character.
 * Do not ignore any characters other than the leading whitespace or the rest of
 * the string after the digits.
 */

class ImplementAtoi {

    // Time -> O(n) //
    // Space -> O(1) //

    private static int myAtoi(String s) {
        int n = s.length();

        if (n == 0) {
            return 0;
        }

        int index = 0;
        int sign = 1;
        int total = 0;

        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        if (index == n) {
            return 0;
        }

        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        while (index < n) {
            int digit = s.charAt(index) - '0';

            if (digit < 0 || digit > 9) {
                break;
            }

            if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = 10 * total + digit;
            index++;
        }

        return total * sign;
    }

    public static void main(String[] args) {
        String s = "   -42";

        System.out.println(myAtoi(s));
    }
}