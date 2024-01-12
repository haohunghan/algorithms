package medium;

import java.util.HashMap;
import java.util.Map;

public class IntToRoman {
    public static String intToRoman(int num) {
        String[] romans = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        Integer[] romanValue = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        StringBuilder result = new StringBuilder();

        int index = romans.length - 1;
        while (index >= 0) {
            int divineResult = num / romanValue[index];
            if (divineResult > 0) {
                num = num % romanValue[index];
                result.append(numberToDigit(divineResult, romans[index]));
            }
            index--;
        }

        return result.toString();
    }

    // Complexity: O(1)
    public String intToRomanBetter(int num) {
        StringBuilder sb = new StringBuilder("");
        // Define the symbols and values for each digit place
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        // Append the symbols for each digit place from left to right
        sb.append(thousands[num / 1000]);
        sb.append(hundreds[(num % 1000) / 100]);
        sb.append(tens[(num % 100) / 10]);
        sb.append(ones[num % 10]);
        return sb.toString();
    }

    public static String numberToDigit(int number, String digit) {
        int index = 1;
        StringBuilder result = new StringBuilder();
        for (; index <= number; index++) {
            result.append(digit);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int num = 58;

        System.out.println(intToRoman(num));
    }
}
