
/**
 * PROBLEM: Given an array of positive integers, find the length of the
 * longest subarray where the sum is ≤ K.
 *
 * CHECKLIST APPLIED:
 * Step 1 - Brute Force: Pairs shape (i, j), O(n²)
 * Step 2 - Bottleneck: Recalculating sum i..j every time
 * Step 3 - Pattern: Sliding Window (variable size)
 * Step 4 - Proof: When sum > k, all larger windows from same left invalid
 * Safe to move left forward. Only works with positives!
 * Step 5 - Template: Variable Sliding Window
 *
 * COMPLEXITY: O(n) time, O(1) space
 *
 * STATUS: Pending — complete this yourself!
 */
public class SlidingWindowLongestSubarray {

    public static int longestSubarray(int[] nums, int k) {
        int left = 0, sum = 0, max = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > k) {
                sum -= nums[left++];
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    // -------------------------------------------------------
    // Test cases — run to verify your solution
    // -------------------------------------------------------
    public static void main(String[] args) {
        // Test 1: Basic case
        int[] nums1 = { 1, 2, 3, 4, 5 };
        int k1 = 9;
        // Expected: 3 (subarray [2, 3, 4] has sum 9 ≤ 9)
        System.out.println("Test 1: " + longestSubarray(nums1, k1) + " (expected 3)");

        // Test 2: Entire array valid
        int[] nums2 = { 1, 1, 1, 1 };
        int k2 = 10;
        // Expected: 4
        System.out.println("Test 2: " + longestSubarray(nums2, k2) + " (expected 4)");

        // Test 3: Single element
        int[] nums3 = { 5 };
        int k3 = 5;
        // Expected: 1
        System.out.println("Test 3: " + longestSubarray(nums3, k3) + " (expected 1)");

        // Test 4: No valid subarray (element > k)
        int[] nums4 = { 10, 20, 30 };
        int k4 = 5;
        // Expected: 0
        System.out.println("Test 4: " + longestSubarray(nums4, k4) + " (expected 0)");

        // Test 5: All same elements
        int[] nums5 = { 3, 3, 3, 3, 3 };
        int k5 = 9;
        // Expected: 3 (sum of 3+3+3 = 9 ≤ 9)
        System.out.println("Test 5: " + longestSubarray(nums5, k5) + " (expected 3)");
    }
}
