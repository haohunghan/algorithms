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

    public static boolean isInteger(double number) {
        if (number == 0) {
            return true;
        }
        return (number / (int) number)  == 1;
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
