# Pattern 08 — Monotonic Stack

## Smell Triggers

- "Next greater/smaller element"
- "Previous greater/smaller element"
- "Days until warmer"
- "Largest rectangle in histogram"
- "Stock span"

## Template — Next Greater Element

```java
// Stack stores INDICES
int[] result = new int[n];
Arrays.fill(result, -1);
Deque<Integer> stack = new ArrayDeque<>();

for (int i = 0; i < n; i++) {
    while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
        result[stack.pop()] = nums[i];  // nums[i] is the next greater
    }
    stack.push(i);
}
```

## The 4 Variants

| Want to Find         | Stack Type | Pop Condition       |
| -------------------- | ---------- | ------------------- |
| Next **Greater**     | Decreasing | `peek() < current`  |
| Next **Smaller**     | Increasing | `peek() > current`  |
| Previous **Greater** | Decreasing | `peek() <= current` |
| Previous **Smaller** | Increasing | `peek() >= current` |

**Memory trick**:

- Want **greater**? Keep stack **decreasing** (pop when bigger comes)
- Want **smaller**? Keep stack **increasing** (pop when smaller comes)

## Core Insight

Stack maintains monotonic order. When new element **breaks** the order → pop and resolve. Each element is pushed once, popped once → **O(n)** total.

## Complexity

- Time: **O(n)** (each element pushed and popped at most once)
- Space: **O(n)**

## Common Traps

- ⚠️ Store **indices** in stack, not values (needed for distance calculations)
- ⚠️ For "distance until warmer": `distance = current_index - popped_index`
- ⚠️ Histogram needs BOTH previous smaller AND next smaller

## LeetCode Problems

- 739: Daily Temperatures
- 496: Next Greater Element I
- 503: Next Greater Element II (circular)
- 84: Largest Rectangle in Histogram
- 42: Trapping Rain Water
- 901: Online Stock Span
