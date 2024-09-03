package medium;

/**
 * https://leetcode.com/problems/minimum-falling-path-sum/?envType=daily-question&envId=2024-01-19
 */
public class MinimumFallingPath {
    public static int minFallingPathSum(int[][] matrix) {
        int length = matrix.length;
        int[] total = new int[length * length - 1];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.println(matrix[i][j]);
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[][] input = {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };
        minFallingPathSum(input);
    }
}
