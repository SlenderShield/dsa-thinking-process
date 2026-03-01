import java.util.*;

/**
 * REVISION CHALLENGES — Mixed problems from Chapters 5-7
 *
 * These are NOT new patterns. Every problem uses something you've already
 * learned.
 * Identify the pattern FIRST, then code.
 */
public class RevisionChallenges {

    // =====================================================
    // Challenge 1: Subarray Sum Equals K (Chapter 5 — Prefix Sum + HashMap)
    // Given [1, 2, 3, -1, 2] and k = 4, count subarrays that sum to k.
    //
    // Can sliding window work here? Why or why not?
    // Answer in the comment below, then code.
    //
    // Sliding window can/cannot work because: ___
    // Pattern: ___
    // =====================================================
    public static int subarraySum(int[] nums, int k) {
        // TODO: Code it
        return -1;
    }

    // =====================================================
    // Challenge 2: Sorted Squares (Chapter 7 — Two Pointers)
    // Given sorted array [-4, -1, 0, 3, 10], return squares in sorted order.
    // Output: [0, 1, 9, 16, 100]
    //
    // Brute force: square all, then sort → O(n log n)
    // Can you do O(n)? Which two-pointer variant?
    // =====================================================
    public static int[] sortedSquares(int[] nums) {
        // TODO: Code it
        return new int[0];
    }

    // =====================================================
    // Challenge 3: Maximum Product Subarray (Chapter 5 — Kadane's variant)
    // Given [2, 3, -2, 4], find contiguous subarray with largest product.
    // Output: 6 (subarray [2, 3])
    //
    // Why can't you just use normal Kadane's? What's different about PRODUCT?
    // Hint: negative × negative = positive
    // =====================================================
    public static int maxProduct(int[] nums) {
        // TODO: Code it
        return -1;
    }

    // =====================================================
    // Challenge 4: Find All Anagrams (Chapter 6 — Sliding Window)
    // Given s = "cbaebabacd", p = "abc"
    // Find all start indices of p's anagrams in s.
    // Output: [0, 6] ("cba" at 0, "bac" at 6)
    //
    // Which sliding window variant? Fixed or Variable?
    // =====================================================
    public static List<Integer> findAnagrams(String s, String p) {
        // TODO: Code it
        return new ArrayList<>();
    }

    // =====================================================
    // Challenge 5: Pattern Identification (NO CODE — just answer)
    //
    // For each problem, write the PATTERN NAME:
    //
    // A: "Given a list of tasks with dependencies, find valid execution order"
    // Pattern: ___
    //
    // B: "Find the kth largest element in unsorted array"
    // Pattern: ___
    //
    // C: "Given n = 10^6 integers, find if any two sum to target"
    // Pattern: ___ (Why not two pointers?)
    //
    // D: "Longest subarray with sum ≤ K (all positive values)"
    // Pattern: ___
    // =====================================================

    // -------------------------------------------------------
    // Test cases
    // -------------------------------------------------------
    public static void main(String[] args) {
        System.out.println("--- Challenge 1: Subarray Sum = K ---");
        System.out.println("C1: " + subarraySum(new int[] { 1, 2, 3, -1, 2 }, 4)
                + " (expected 2)");
        System.out.println("C1b: " + subarraySum(new int[] { 1, 1, 1 }, 2)
                + " (expected 2)");

        System.out.println("\n--- Challenge 2: Sorted Squares ---");
        System.out.println("C2: " + Arrays.toString(sortedSquares(new int[] { -4, -1, 0, 3, 10 }))
                + " (expected [0, 1, 9, 16, 100])");

        System.out.println("\n--- Challenge 3: Max Product Subarray ---");
        System.out.println("C3: " + maxProduct(new int[] { 2, 3, -2, 4 })
                + " (expected 6)");
        System.out.println("C3b: " + maxProduct(new int[] { -2, 0, -1 })
                + " (expected 0)");
        System.out.println("C3c: " + maxProduct(new int[] { -2, 3, -4 })
                + " (expected 24)");

        System.out.println("\n--- Challenge 4: Find Anagrams ---");
        System.out.println("C4: " + findAnagrams("cbaebabacd", "abc")
                + " (expected [0, 6])");
    }
}
