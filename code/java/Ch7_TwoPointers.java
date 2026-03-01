import java.util.*;

/**
 * CHAPTER 7 — Two Pointers Practice Problems
 */
public class Ch7_TwoPointers {

    // =====================================================
    // Level 1: Opposite Ends (Converging)
    // =====================================================

    // Problem 1: Two Sum II — Sorted (LeetCode 167)
    // Input: [2, 7, 11, 15], target = 9 -> Output: [1, 2]
    public static int[] twoSumSorted(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[] { left + 1, right + 1 };
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[] { -1, -1 };
    }

    // Problem 2: Container With Most Water (LeetCode 11)
    // Input: [1,8,6,2,5,4,8,3,7] -> Output: 49
    // WHY move the shorter line? Because keeping it can't give a bigger area.
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    // Problem 3: Valid Palindrome (LeetCode 125)
    // Input: "A man, a plan, a canal: Panama" -> Output: true
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        s = s.toLowerCase();
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    // =====================================================
    // Level 2: Same Direction (Read-Write)
    // =====================================================

    // Problem 4: Remove Duplicates from Sorted Array (LeetCode 26)
    // Input: [1, 1, 2] -> Output: 2 (array becomes [1, 2, ...])
    public static int removeDuplicates(int[] nums) {
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] != nums[left]) {
                nums[++left] = nums[right];
            }
        }
        return left + 1;
    }

    public static void swap(int[] nums, int left, int right) {
        int tmp = nums[right];
        nums[right] = nums[left];
        nums[left] = tmp;
    }

    // Problem 5: Move Zeroes (LeetCode 283)
    // Input: [0, 1, 0, 3, 12] -> Output: [1, 3, 12, 0, 0]
    public static void moveZeroes(int[] nums) {
        // int left = 0;
        // for (int right = 1; right < nums.length; right++) {
        // if (nums[right] == 0) {
        // continue;
        // }
        // nums[left++] = nums[right];
        // }
        // while (left < nums.length) {
        // nums[left++] = 0;
        // }

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
        }
    }

    // =====================================================
    // Level 3: Multi-Pointer
    // =====================================================

    // Problem 6: Three Sum (LeetCode 15) ⭐
    // Input: [-1, 0, 1, 2, -1, -4] -> Output: [[-1,-1,2], [-1,0,1]]
    // -4,-1,-1,0,1,2
    // Strategy: Sort -> fix one -> Two Pointers on remaining
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1])
                        j++;
                    while (j < k && nums[k] == nums[k - 1])
                        k--;
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }

    // =====================================================
    // Level 5: Discrimination
    // =====================================================
    /*
     * A: "Find longest substring without repeating chars"
     * TP? No Pattern: SW
     *
     * B: "Remove duplicates from sorted linked list"
     * TP? Yes Pattern: same direction
     *
     * C: "Find pair with given difference in sorted array"
     * TP? Yes Pattern: opposite dir
     *
     * D: "Find subarray with max sum"
     * TP? No Pattern: SW or hashmap depends
     *
     * E: "Merge two sorted arrays in-place"
     * TP? Yes Pattern: same direction
     */

    // -------------------------------------------------------
    // Test cases
    // -------------------------------------------------------
    public static void main(String[] args) {
        System.out.println("--- Level 1: Opposite Ends ---");
        System.out.println("P1: " + Arrays.toString(twoSumSorted(new int[] { 2, 7, 11, 15 }, 9))
                + " (expected [1, 2])");
        System.out.println("P2: " + maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 })
                + " (expected 49)");
        System.out.println("P3: " + isPalindrome("A man, a plan, a canal: Panama")
                + " (expected true)");
        System.out.println("P3b: " + isPalindrome("race a car")
                + " (expected false)");

        System.out.println("\n--- Level 2: Same Direction ---");
        int[] p4 = { 1, 1, 2 };
        System.out.println("P4: " + removeDuplicates(p4) + " (expected 2)");
        int[] p5 = { 4, 2, 4, 0, 0, 3, 0, 5, 1, 0 };
        moveZeroes(p5);
        System.out.println("P5: " + Arrays.toString(p5)
                + " (expected [1, 3, 12, 0, 0])");

        System.out.println("\n--- Level 3: Multi-Pointer ---");
        System.out.println("P6: " + threeSum(new int[] { -1, 0, 1, 2, -1, -4 })
                + " (expected [[-1,-1,2], [-1,0,1]])");
    }
}
