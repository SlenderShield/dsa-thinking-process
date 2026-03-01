
import java.util.HashMap;
import java.util.Map;

/**
 * CHAPTER 6 — Sliding Window Practice Problems
 *
 * Complete each method. Keep your "Key Insight" in mind for each!
 */

public class Ch6_SlidingWindow {

    // =====================================================
    // Level 1: Fixed Window
    // =====================================================

    // Problem 1: Maximum Sum Subarray of Size K
    // Input: [2, 1, 5, 1, 3, 2], k = 3 -> Output: 9
    public static int maxSumSubarrayK(int[] nums, int k) {
        int left = 0, right = 0, sum = 0;
        int length = nums.length;
        while (right < k) {
            sum += nums[right++];
        }
        int maxSum = sum;
        while (right < length) {
            sum -= nums[left++];
            sum += nums[right++];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    // Problem 2: Maximum Average Subarray (LeetCode 643)
    // Input: [1, 12, -5, -6, 50, 3], k = 4 -> Output: 12.75
    public static double findMaxAverage(int[] nums, int k) {
        int left = 0, right = 0;
        double sum = 0;
        int length = nums.length;
        while (right < k) {
            sum += nums[right++];
        }
        double maxAvg = sum / k;
        while (right < length) {
            sum -= nums[left++];
            sum += nums[right++];
            double avg = sum / k;
            maxAvg = Math.max(avg, maxAvg);
        }
        return maxAvg;
    }

    // =====================================================
    // Level 2: Variable Window — Sum Based
    // =====================================================

    // Problem 3: Smallest Subarray with Sum >= S (LeetCode 209)
    // Input: [2, 1, 5, 2, 3, 2], s = 7 -> Output: 2
    public static int minSubArrayLen(int s, int[] nums) {
        int left = 0, length = nums.length;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        for (int right = 0; right < length; right++) {
            sum += nums[right];
            while (sum >= s) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    // Problem 4: Max Consecutive Ones III (LeetCode 1004)
    // Input: [1,1,1,0,0,0,1,1,1,1,0], k = 2 -> Output: 6
    // Insight: Find longest window with at most k zeros.
    public static int longestOnes(int[] nums, int k) {
        int length = nums.length;
        int maxCount = 0, left = 0;
        int zeroC = 0;
        for (int right = 0; right < length; right++) {
            if (nums[right] == 0) {
                zeroC++;
            }
            while (zeroC > k) {
                if (nums[left++] == 0)
                    zeroC--;
            }
            maxCount = Math.max(maxCount, right - left + 1);
        }
        return maxCount;
    }

    // =====================================================
    // Level 3: Variable Window — HashMap Based
    // =====================================================

    // Problem 5: Longest Substring Without Repeating Characters (LeetCode 3)
    // Input: "abcabcbb" -> Output: 3
    public static int lengthOfLongestSubstring(String s) {
        boolean[] chars = new boolean[26];
        int maxLen = 0;
        int left = 0, len = s.length();
        for (int right = 0; right < len; right++) {
            int idx = s.charAt(right) - 'a';
            while (chars[idx]) {
                chars[s.charAt(left++) - 'a'] = false;
            }
            chars[idx] = true;
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    // Problem 6: Longest Substring with At Most K Distinct Characters (LeetCode
    // 340)
    // Input: "eceba", k = 2 -> Output: 3
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        // TODO: Variable window with HashMap char->frequency
        int[] chars = new int[26];
        int maxLen = 0, dis = 0;
        int left = 0, len = s.length();
        for (int right = 0; right < len; right++) {
            int idx = s.charAt(right) - 'a';
            chars[idx]++;
            if (chars[idx] == 1) {
                dis++;
            }
            while (dis > k) {
                chars[s.charAt(left) - 'a']--;
                if (chars[s.charAt(left) - 'a'] == 0)
                    dis--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    // Problem 7: Fruits Into Baskets (LeetCode 904)
    // Input: [1, 2, 1, 2, 3] -> Output: 4
    public static int totalFruit(int[] fruits) {
        // TODO: This is literally Problem 6 where k = 2. Try to adapt it!
        Map<Integer, Integer> chars = new HashMap<>();
        int maxLen = 0, dis = 0;
        int left = 0, len = fruits.length;
        for (int right = 0; right < len; right++) {
            int idx = fruits[right];
            if (!chars.containsKey(idx) || chars.get(idx) == 0)
                dis++;

            chars.put(idx, chars.getOrDefault(idx, 0) + 1);
            while (dis > 2) {
                int i = fruits[left];
                chars.put(i, chars.get(i) - 1);
                if (chars.get(i) == 0)
                    dis--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;

    }

    // =====================================================
    // Level 5: Discrimination Challenge
    // Are these Sliding Window problems? YES or NO. If NO, what pattern?
    // =====================================================
    /*
     * A: "Find longest palindromic substring"
     * YES/NO? -> No (Pattern: Two pointer)
     * 
     * B: "Find longest subarray with sum <= K (all positive)"
     * YES/NO? -> Yes (Pattern: Variable Window)
     * 
     * C: "Count subarrays with sum exactly K (with negatives)"
     * YES/NO? -> No (Pattern: kadane's)
     * 
     * D: "Find longest substring with at most 2 repeating characters"
     * YES/NO? -> Yes (Pattern: Variable window)
     * 
     * E: "Find two numbers in sorted array that sum to target"
     * YES/NO? -> No (Pattern: two pointers)
     */

    // -------------------------------------------------------
    // Test cases
    // -------------------------------------------------------
    public static void main(String[] args) {
        System.out.println("--- Level 1 ---");
        System.out.println("P1: " + maxSumSubarrayK(new int[] { 2, 1, 5, 1, 3, 2 }, 3) + " (expected 9)");
        System.out.println("P2: " + findMaxAverage(new int[] { 1, 12, -5, -6, 50, 3 }, 4) + " (expected 12.75)");

        System.out.println("\n--- Level 2 ---");
        System.out.println("P3: " + minSubArrayLen(7, new int[] { 2, 1, 5, 2, 3, 2 }) + " (expected 2)");
        System.out.println("P4: " + longestOnes(new int[] { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, 2) + " (expected 6)");

        System.out.println("\n--- Level 3 ---");
        System.out.println("P5: " + lengthOfLongestSubstring("abcabcbb") + " (expected 3)");
        System.out.println("P6: " + lengthOfLongestSubstringKDistinct("aabbcc", 2) + " (expected 4)");
        System.out.println("P7: " + totalFruit(new int[] { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 }) + " (expected 5)");
    }
}
