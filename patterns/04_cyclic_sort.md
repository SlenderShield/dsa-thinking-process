# Pattern 04 — Cyclic Sort

## Smell Triggers

- "Find missing number in range [1, n]"
- "Find duplicate in range [1, n]"
- "Array of n numbers in range [0, n] or [1, n]"
- Values **bounded by array size**

## Template

```java
public int findMissing(int[] nums) {
    int i = 0;
    // Phase 1: Place each number at its correct index
    while (i < nums.length) {
        int correctIdx = nums[i] - 1;
        if (nums[i] > 0 && nums[i] <= nums.length
            && nums[i] != nums[correctIdx]) {
            swap(nums, i, correctIdx);
        } else {
            i++;
        }
    }
    // Phase 2: Find the mismatch
    for (int j = 0; j < nums.length; j++) {
        if (nums[j] != j + 1) return j + 1;
    }
    return nums.length + 1;
}
```

## Core Insight

Number `i` belongs at index `i-1`. **The array IS the hashmap** — use positions as keys.

## Complexity

- Time: **O(n)** (each element moves at most once)
- Space: **O(1)**

## When to Choose

| Approach         | Time | Space    | When                |
| ---------------- | ---- | -------- | ------------------- |
| Cyclic Sort      | O(n) | **O(1)** | Values bounded by n |
| HashMap          | O(n) | O(n)     | Values unbounded    |
| Math (sum trick) | O(n) | O(1)     | Only one missing    |

## LeetCode Problems

- 268: Missing Number
- 287: Find the Duplicate Number
- 448: Find All Numbers Disappeared in an Array
- 41: First Missing Positive
