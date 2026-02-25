import java.util.HashMap;
import java.util.Map;

/**
 * CHAPTER 5 — Arrays & Strings Practice Problems
 *
 * Complete each method using the pattern specified.
 * Run main() to test your solutions.
 */
public class Ch5_ArrayProblems {

    // =====================================================
    // PROBLEM 1: Kadane's Algorithm — Maximum Subarray Sum
    // Input: [-2, 1, -3, 4, -1, 2, 1, -5, 4]
    // Output: 6 (subarray [4, -1, 2, 1])
    //
    // Pattern: Kadane's (running state)
    // Smell: "max subarray sum" → extend or restart
    // =====================================================
    public static int maxSubarraySum(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        for (int idx = 1; idx < nums.length; idx++) {
            sum = Math.max(sum + nums[idx], nums[idx]);
            max = Math.max(max, sum);
        }
        return max;
    }

    // =====================================================
    // PROBLEM 2: Dutch National Flag — Sort Colors
    // Input: [2, 0, 2, 1, 1, 0]
    // Output: [0, 0, 1, 1, 2, 2]
    //
    // Pattern: Dutch National Flag (3-way partition)
    // Smell: "sort 2-3 values in-place, one pass"
    // =====================================================
    public static void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (mid <= high) {
            switch (nums[mid]) {
                case 0 -> {
                    swap(nums, low, mid);
                    low++;
                    mid++;
                }
                case 1 -> mid++;
                default -> swap(nums, mid, high--);
            }
        }
    }

    // =====================================================
    // PROBLEM 3: Missing Number (using Cyclic Sort)
    // Input: [3, 0, 1] — range [0, n]
    // Output: 2
    //
    // Pattern: Cyclic Sort OR Math (sum trick)
    // Question: Which do you choose? Why?
    // =====================================================
    public static int missingNumber(int[] nums) {
        // Option B: Math → expected sum - actual sum = missing
        int len = nums.length;
        int total = (len * (len + 1)) / 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return total - sum;
    }

    // =====================================================
    // PROBLEM 4: Subarray Sum Equals K
    // Input: nums = [1, 1, 1], k = 2
    // Output: 2 (subarrays: [1,1] at pos 0-1 and [1,1] at pos 1-2)
    //
    // Pattern: Prefix Sum + HashMap
    // Question: Why can't sliding window work here?
    // =====================================================
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int idx = 0; idx < nums.length; idx++) {
            sum += nums[idx];
            if (prefix.containsKey(sum - k)) {
                count += prefix.get(sum - k);
            }
            prefix.put(sum, prefix.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    // =====================================================
    // PROBLEM 5: Rotate Array
    // Input: [1,2,3,4,5,6,7], k = 3
    // Output: [5,6,7,1,2,3,4]
    //
    // Pattern: In-place reverse trick
    // Trick: reverse all → reverse first k → reverse rest
    // =====================================================
    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // -------------------------------------------------------
    // Test cases
    // -------------------------------------------------------
    public static void main(String[] args) {
        // Test Problem 1: Kadane's
        int[] p1 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println("P1 Kadane's: " + maxSubarraySum(p1) + " (expected 6)");

        // Test Problem 2: Dutch Flag
        int[] p2 = { 2, 0, 2, 1, 1, 0 };
        sortColors(p2);
        System.out.print("P2 Dutch Flag: [");
        for (int i = 0; i < p2.length; i++) {
            System.out.print(p2[i] + (i < p2.length - 1 ? ", " : ""));
        }
        System.out.println("] (expected [0, 0, 1, 1, 2, 2])");

        // Test Problem 3: Missing Number
        int[] p3 = { 3, 0, 1 };
        System.out.println("P3 Missing: " + missingNumber(p3) + " (expected 2)");
        int[] p3b = { 0, 1 };
        System.out.println("P3b Missing: " + missingNumber(p3b) + " (expected 2)");

        // Test Problem 4: Subarray Sum = K
        int[] p4 = { 1, 1, 1 };
        System.out.println("P4 SubSum: " + subarraySum(p4, 2) + " (expected 2)");
        int[] p4b = { 1, 2, 3, -1, 2 };
        System.out.println("P4b SubSum: " + subarraySum(p4b, 4) + " (expected 2)");

        // Test Problem 5: Rotate
        int[] p5 = { 1, 2, 3, 4, 5, 6, 7 };
        rotate(p5, 3);
        System.out.print("P5 Rotate: [");
        for (int i = 0; i < p5.length; i++) {
            System.out.print(p5[i] + (i < p5.length - 1 ? ", " : ""));
        }
        System.out.println("] (expected [5, 6, 7, 1, 2, 3, 4])");
    }
}
