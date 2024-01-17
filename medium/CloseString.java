package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/determine-if-two-strings-are-close/description/?envType=daily-question&envId=2024-01-15
 * Two strings are considered close if you can attain one from the other using the following operations:
 *
 * Operation 1: Swap any two existing characters.
 * For example, abcde -> aecdb
 * Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
 * For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
 * You can use the operations on either string as many times as necessary.
 *
 * Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: word1 = "abc", word2 = "bca"
 * Output: true
 * Explanation: You can attain word2 from word1 in 2 operations.
 * Apply Operation 1: "abc" -> "acb"
 * Apply Operation 1: "acb" -> "bca"
 * Example 2:
 *
 * Input: word1 = "a", word2 = "aa"
 * Output: false
 * Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.
 * Example 3:
 *
 * Input: word1 = "cabbba", word2 = "abbccc"
 * Output: true
 * Explanation: You can attain word2 from word1 in 3 operations.
 * Apply Operation 1: "cabbba" -> "caabbb"
 * Apply Operation 2: "caabbb" -> "baaccc"
 * Apply Operation 2: "baaccc" -> "abbccc"
 *
 *
 * Constraints:
 *
 * 1 <= word1.length, word2.length <= 105
 * word1 and word2 contain only lowercase English letters.
 */
public class CloseString {
    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        Map<Character, Integer> hashMap = new HashMap<>();
        Map<Character, Integer> hashMap2 = new HashMap<>();

        for (int i = 0; i < word1.length(); i++) {
            if (hashMap.containsKey(word1.charAt(i))) {
                int tempIndex = hashMap.get(word1.charAt(i));
                hashMap.put(word1.charAt(i), ++tempIndex);

            } else {
                hashMap.put(word1.charAt(i), 0);
            }

            if (hashMap2.containsKey(word2.charAt(i))) {
                int tempIndex = hashMap2.get(word2.charAt(i));
                hashMap2.put(word2.charAt(i), ++tempIndex);

            } else {
                hashMap2.put(word2.charAt(i), 0);
            }
        }
        if (!hashMap2.keySet().equals(hashMap.keySet())) {
            return false;
        }
        List<Integer> list1 = hashMap.values().stream().sorted().toList();
        List<Integer> list2 = hashMap2.values().stream().sorted().toList();

        for (int i = 0; i < list1.size(); i++) {

            if (!hashMap2.containsValue(list1.get(i))) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        String word1 = "cabbba";
        String word2 = "abbccc";
        System.out.println('b' - 'a');

        System.out.println(closeStrings(word1, word2));
    }
}
