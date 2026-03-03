# Pattern 03 — Dutch National Flag (3-Way Partition)

## Smell Triggers

- "Sort array with only 2-3 distinct values"
- "Partition into groups"
- "Sort colors" (LeetCode 75)
- "Move all X to left, Y to right"

## Template

```java
public void dutchFlag(int[] nums) {
    int low = 0, mid = 0, high = nums.length - 1;
    while (mid <= high) {
        if (nums[mid] == 0) {
            swap(nums, low++, mid++);
        } else if (nums[mid] == 1) {
            mid++;
        } else {
            swap(nums, mid, high--);  // DON'T increment mid!
        }
    }
}
```

## Core Insight

3 pointers create 3 zones: `[0..low)` = group 1, `[low..mid)` = group 2, `(high..end]` = group 3.

## Complexity

- Time: **O(n)** single pass
- Space: **O(1)**

## Common Traps

- ⚠️ When swapping with `high`, **don't increment mid** — the swapped-in element hasn't been checked yet

## LeetCode Problems

- 75: Sort Colors
- 283: Move Zeroes (simplified 2-way version)
