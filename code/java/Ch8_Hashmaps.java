import java.util.*;

/**
 * CHAPTER 8 — HashMap Practice Problems
 */
public class Ch8_Hashmaps {

    // =====================================================
    // Level 1: Complement / Existence
    // =====================================================

    // Problem 1: Two Sum (LeetCode 1)
    // Input: [2, 7, 11, 15], target = 9 -> Output: [0, 1]
    public static int[] twoSum(int[] nums, int target) {
        // TODO: Complement lookup pattern
        return new int[] { -1, -1 };
    }

    // Problem 2: Contains Duplicate (LeetCode 217)
    // Input: [1, 2, 3, 1] -> Output: true
    public static boolean containsDuplicate(int[] nums) {
        // TODO: HashSet existence check
        return false;
    }

    // =====================================================
    // Level 2: Frequency
    // =====================================================

    // Problem 3: First Unique Character (LeetCode 387)
    // Input: "leetcode" -> Output: 0
    public static int firstUniqChar(String s) {
        // TODO: Frequency count, then scan for freq == 1
        return -1;
    }

    // Problem 4: Top K Frequent Elements (LeetCode 347)
    // Input: [1,1,1,2,2,3], k = 2 -> Output: [1, 2]
    public static int[] topKFrequent(int[] nums, int k) {
        // TODO: Frequency map + sort by value (or use heap)
        return new int[0];
    }

    // =====================================================
    // Level 3: Grouping
    // =====================================================

    // Problem 5: Group Anagrams (LeetCode 49)
    // Input: ["eat","tea","tan","ate","nat","bat"]
    // Output: [["eat","tea","ate"], ["tan","nat"], ["bat"]]
    public static List<List<String>> groupAnagrams(String[] strs) {
        // TODO: Use sorted string as key, group into map
        return new ArrayList<>();
    }

    // =====================================================
    // Level 4: Advanced
    // =====================================================

    // Problem 6: Longest Consecutive Sequence (LeetCode 128) ⭐
    // Input: [100, 4, 200, 1, 3, 2] -> Output: 4
    // Hint: HashSet + only count from sequence START (no predecessor)
    public static int longestConsecutive(int[] nums) {
        // TODO: Put all in HashSet.
        // For each num, if (num-1) NOT in set → it's a start → count forward.
        return -1;
    }

    // =====================================================
    // Level 5: Discrimination
    // =====================================================
    /*
     * A: "Find two numbers in sorted array summing to target"
     * HashMap? ___ Pattern: ___
     *
     * B: "Group words by their first letter"
     * HashMap? ___ Pattern: ___
     *
     * C: "Find longest substring without repeating characters"
     * HashMap? ___ Pattern: ___
     *
     * D: "Check if two strings are anagrams"
     * HashMap? ___ Pattern: ___
     *
     * E: "Find missing number in range [1, n]"
     * HashMap? ___ Pattern: ___
     */

    // -------------------------------------------------------
    // Test cases
    // -------------------------------------------------------
    public static void main(String[] args) {
        System.out.println("--- Level 1 ---");
        System.out.println("P1: " + Arrays.toString(twoSum(new int[] { 2, 7, 11, 15 }, 9))
                + " (expected [0, 1])");
        System.out.println("P2: " + containsDuplicate(new int[] { 1, 2, 3, 1 })
                + " (expected true)");
        System.out.println("P2b: " + containsDuplicate(new int[] { 1, 2, 3, 4 })
                + " (expected false)");

        System.out.println("\n--- Level 2 ---");
        System.out.println("P3: " + firstUniqChar("leetcode")
                + " (expected 0)");
        System.out.println("P3b: " + firstUniqChar("aabb")
                + " (expected -1)");
        System.out.println("P4: " + Arrays.toString(topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2))
                + " (expected [1, 2])");

        System.out.println("\n--- Level 3 ---");
        System.out.println("P5: " + groupAnagrams(
                new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));

        System.out.println("\n--- Level 4 ---");
        System.out.println("P6: " + longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 })
                + " (expected 4)");
        System.out.println("P6b: " + longestConsecutive(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 })
                + " (expected 9)");
    }
}
