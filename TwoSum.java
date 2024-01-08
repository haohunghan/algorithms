import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */
public class TwoSum {

    // Complexity: O(n-1)
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();
        int[] result = new int[2];
        if (nums.length == 0) {
            return result;
        }
        hash.put(nums[0], 0);

        for (int i = 1; i < nums.length; i++) {
            int oppositeTarget = target - nums[i];
            // find other index
            if (hash.containsKey(oppositeTarget)) {
                result[0] = i;
                result[1] = hash.get(oppositeTarget);
                break;
            } else {
                hash.put(nums[i], i);
            }
        }
        hash.clear();

        return result;
    }

    public static void main (String[] args) {
        int[] nums = {3, 2, 4};
        int[] result = twoSum(nums, 7);
        System.out.println(Arrays.toString(result));
    }
}
