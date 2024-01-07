public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindromeWithoutParseString(10));
    }

    // Convert to String solution
    public static boolean isPalindrome(int x) {
        char[] inputs = Integer.toString(x).toCharArray();

        int right = inputs.length - 1;
        final int arrLength = inputs.length;
        final int middle = (arrLength)/2;
        boolean isPalindrome = false;

        for (int i =0; i <= middle; i++) {
            if (i == middle) {
                if (!isEven(arrLength)) {
                    isPalindrome = true;
                    break;
                } else if (inputs[i] == inputs[right - i]) {
                    isPalindrome = true;
                }

            }
            if (inputs[i] != inputs[right - i]) {
                break;
            }
        }

        return isPalindrome;
    }

    public static boolean isPalindromeWithoutParseString(int x) {
        if (x <= 0 || (x % 10 == 0)) {
            return false;
        }

        int reversedNumber = 0;
        int originInput = x;
        while (originInput > 0) {
            final int digit = originInput % 10;
            reversedNumber = reversedNumber * 10 + digit;
            originInput = originInput / 10;
        }

        return reversedNumber == x;
    }

    public static boolean isEven(int x) {
        return x % 2 == 0;
    }
}