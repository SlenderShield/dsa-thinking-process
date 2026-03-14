import java.util.*;

/**
 * CHAPTER 10 — Binary Search Practice Problems
 */
public class Ch10_BinarySearch {

    // =====================================================
    // Level 1: Classic & Boundary
    // =====================================================

    // Problem 1: Binary Search (LeetCode 704)
    // Input: [-1,0,3,5,9,12], target=9 -> 4
    // Classic: lo <= hi, return on match
    public static int search(int[] nums, int target) {
        // TODO: Classic binary search
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    // Problem 2: First and Last Position (LeetCode 34)
    // Input: [5,7,7,8,8,10], target=8 -> [3,4]
    // Use lowerBound (first >= target) and upperBound (last <= target)
    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int[] result = new int[] { -1, -1 };

        // Find first occurrence (lower bound)
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // Target not found
        if (left == nums.length || nums[left] != target) {
            return result;
        }

        result[0] = left;

        // Find last occurrence (upper bound)
        right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        result[1] = left - 1;

        return result;
    }

    // =====================================================
    // Level 2: Modified Binary Search
    // =====================================================

    // Problem 3: Search in Rotated Sorted Array (LeetCode 33)
    // Input: [4,5,6,7,0,1,2], target=0 -> 4
    // KEY: One half is ALWAYS sorted. Check which half,
    // then decide if target lies in that sorted half.
    public static int searchRotated(int[] nums, int target) {
        // TODO: At each mid, determine which half is sorted
        // Then check if target is in that sorted half

        // Note: we need to check four condition i.e if and else and if and else in if
        // and else
        return -1;
    }

    // Problem 4: Find Minimum in Rotated Sorted Array (LeetCode 153)
    // Input: [3,4,5,1,2] -> 1
    // Compare mid with hi: if nums[mid] > nums[hi], min is in right half
    public static int findMin(int[] nums) {
        // TODO: Binary search, compare mid with hi
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];
    }

    // =====================================================
    // Level 3: Binary Search on Answer Space ⭐⭐
    // =====================================================

    // Problem 5: Koko Eating Bananas (LeetCode 875)
    // piles = [3,6,7,11], h = 8 -> 4
    // Answer space: speed from 1 to max(piles)
    // Condition: canFinish(piles, speed, h)
    public static int minEatingSpeed(int[] piles, int h) {
        // TODO: Binary search on answer space [1, max(piles)]
        // Write helper: canFinish(piles, speed, h)
        int maxBanana = 0;
        for (int pile : piles) {
            maxBanana = Math.max(maxBanana, pile);
        }
        int left = 1;
        int right = maxBanana;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, mid, h)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // Helper: Can Koko eat all bananas at given speed within h hours?
    private static boolean canFinish(int[] piles, int speed, int h) {
        // TODO: For each pile, hours needed = ceil(pile / speed)
        // Total hours <= h?
        long totalTime = 0;
        for (int pile : piles) {
            totalTime += (pile + speed - 1) / speed;
        }
        return totalTime <= h;
    }

    // =====================================================
    // Level 4: Discrimination
    // =====================================================
    /*
     * A: "Find target in sorted array"
     * BS? Yes Pattern: Simple BS
     *
     * B: "Find peak element (greater than neighbors)"
     * BS? yes Pattern: check if right neighbor is low, you reached peak as it will
     * be rotated
     *
     * C: "Minimum speed to arrive on time"
     * BS? Yes Pattern: BS space
     *
     * D: "Find K-th largest element"
     * BS? No Pattern: heap
     *
     * E: "Find square root of N (integer part)"
     * BS? Yes Pattern: Don't know(space or simple)
     */

    // -------------------------------------------------------
    // Test cases
    // -------------------------------------------------------
    public static void main(String[] args) {
        System.out.println("--- Level 1 ---");
        System.out.println("P1: " + search(new int[] { -1, 0, 3, 5, 9, 12 }, 9)
                + " (expected 4)");
        System.out.println("P1b: " + search(new int[] { -1, 0, 3, 5, 9, 12 }, 2)
                + " (expected -1)");

        System.out.println("P2: " + Arrays.toString(
                searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8))
                + " (expected [3,4])");
        System.out.println("P2b: " + Arrays.toString(
                searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6))
                + " (expected [-1,-1])");

        System.out.println("\n--- Level 2 ---");
        System.out.println("P3: " + searchRotated(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0)
                + " (expected 4)");
        System.out.println("P3b: " + searchRotated(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3)
                + " (expected -1)");

        System.out.println("P4: " + findMin(new int[] { 3, 4, 5, 1, 2 })
                + " (expected 1)");
        System.out.println("P4b: " + findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 })
                + " (expected 0)");

        System.out.println("\n--- Level 3 ---");
        System.out.println("P5: " + minEatingSpeed(new int[] { 3, 6, 7, 11 }, 8)
                + " (expected 4)");
        System.out.println("P5b: " + minEatingSpeed(new int[] { 30, 11, 23, 4, 20 }, 5)
                + " (expected 30)");
    }
}