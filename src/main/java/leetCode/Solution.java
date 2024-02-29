import java.util.Arrays;

public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] = digits[i] + 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        // If we reach here, it means all digits were 9, so we need to add a new digit 1 at the beginning
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();



        // Example 2
        int[] digits2 = {9};
        int[] result2 = solution.plusOne(digits2);
        System.out.println("Example 2: " + Arrays.toString(result2));


    }
}
