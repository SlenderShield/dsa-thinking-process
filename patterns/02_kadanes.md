# Pattern 02 — Kadane's Algorithm

## Smell Triggers

- "Maximum/minimum subarray sum"
- "Best contiguous segment"
- "I need the best thing ending at each position"

## Template

```java
public int maxSubarraySum(int[] nums) {
    int currentSum = nums[0];
    int maxSum = nums[0];
    for (int i = 1; i < nums.length; i++) {
        currentSum = Math.max(nums[i], currentSum + nums[i]);
        maxSum = Math.max(maxSum, currentSum);
    }
    return maxSum;
}
```

## Core Insight

At each position: **extend previous OR start fresh**. If running sum is negative, starting fresh is always better.

## Complexity

- Time: **O(n)**
- Space: **O(1)**

## Variations

| Variation                 | Twist                                        |
| ------------------------- | -------------------------------------------- |
| Minimum subarray sum      | Flip max to min                              |
| Maximum circular subarray | max(Kadane, totalSum - minSubarray)          |
| Maximum product subarray  | Track both max AND min (negatives flip sign) |

## Common Traps

- ⚠️ Initialize `maxSum = nums[0]`, NOT 0 (handles all-negative arrays)
- ⚠️ Product variant needs `minProduct` too (negative × negative = positive)

## LeetCode Problems

- 53: Maximum Subarray
- 152: Maximum Product Subarray
- 918: Maximum Sum Circular Subarray
