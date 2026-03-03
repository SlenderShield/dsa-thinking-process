# Pattern 05 — Prefix Sum

## Smell Triggers

- "Sum of subarray from i to j"
- "Range sum queries"
- "Subarray sum equals K" (especially with negatives)
- "Cumulative" anything

## Template — Basic Prefix Sum

```java
int[] prefix = new int[nums.length + 1];
for (int i = 0; i < nums.length; i++) {
    prefix[i + 1] = prefix[i] + nums[i];
}
// Sum from index l to r (inclusive) = prefix[r+1] - prefix[l]
```

## Template — Subarray Sum = K (with HashMap)

```java
Map<Integer, Integer> prefixCount = new HashMap<>();
prefixCount.put(0, 1);  // empty prefix
int sum = 0, count = 0;
for (int num : nums) {
    sum += num;
    count += prefixCount.getOrDefault(sum - k, 0);
    prefixCount.merge(sum, 1, Integer::sum);
}
```

## Core Insight

Any subarray sum = **one subtraction** of two prefix sums: `prefix[j] - prefix[i] = sum(i..j-1)`.

## Complexity

- Build: **O(n)**, Query: **O(1)**
- Space: **O(n)**

## When Prefix Sum vs Sliding Window

| Technique            | Use When                                  |
| -------------------- | ----------------------------------------- |
| Sliding Window       | Positive values + longest/shortest window |
| Prefix Sum + HashMap | **Negatives allowed** + exact sum / count |

## LeetCode Problems

- 303: Range Sum Query
- 560: Subarray Sum Equals K
- 974: Subarray Sums Divisible by K
- 525: Contiguous Array
