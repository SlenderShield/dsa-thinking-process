# Pattern 01 — Sliding Window

## 🔍 When Does This Pattern Fire?

### Smell Triggers

- "contiguous subarray / substring"
- "longest / shortest with condition"
- "window of size K"
- "at most K distinct"

### Confirm It's Sliding Window (NOT Two Pointers)

- Data is **contiguous** (subarray, not subsequence)
- You're maintaining a **window state** (sum, count, set)
- Window **expands** from right, **shrinks** from left

---

## 📐 Two Variants

### Variant A: Fixed-Size Window

**Use when**: Window size is given (e.g., "subarray of size k")

```
Pseudocode:
  1. Build initial window of size k
  2. Slide: add right element, remove left element
  3. Update result at each position
```

```java
// TEMPLATE: Fixed Sliding Window
public int fixedWindow(int[] nums, int k) {
    int windowSum = 0, result = 0;

    for (int i = 0; i < nums.length; i++) {
        windowSum += nums[i];              // add right

        if (i >= k) {
            windowSum -= nums[i - k];      // remove left
        }

        if (i >= k - 1) {
            result = Math.max(result, windowSum); // update
        }
    }
    return result;
}
```

**Complexity**: O(n) time, O(1) space

---

### Variant B: Variable-Size Window

**Use when**: Window size is unknown, determined by a constraint

```
Pseudocode:
  1. Expand window (move right pointer, update state)
  2. While window is invalid: shrink (move left, update state)
  3. Update result (window is now valid)
```

```java
// TEMPLATE: Variable Sliding Window
public int variableWindow(int[] nums, int constraint) {
    int left = 0, result = 0;
    // window state — depends on problem:
    // int windowSum = 0;           (for sum problems)
    // Map<Character, Integer> map; (for frequency problems)
    // Set<Character> set;          (for uniqueness problems)

    for (int right = 0; right < nums.length; right++) {
        // 1. EXPAND: add nums[right] to window state

        while (/* window is INVALID */) {
            // 2. SHRINK: remove nums[left] from window state
            left++;
        }

        // 3. UPDATE: result based on current valid window
        result = Math.max(result, right - left + 1);
    }
    return result;
}
```

**Complexity**: O(n) time (each element added/removed at most once)

---

## ⚠️ Common Traps

1. **Negative numbers**: Shrinking left doesn't guarantee sum decreases → sliding window may NOT work
2. **"At most K" vs "Exactly K"**: Exactly K = atMost(K) - atMost(K-1)
3. **Forgetting to update state on shrink**: If you add to a map on expand, you MUST remove on shrink

---

## 🔀 Sliding Window vs Two Pointers

| Feature  | Sliding Window                         | Two Pointers                   |
| -------- | -------------------------------------- | ------------------------------ |
| Data     | Contiguous (subarray)                  | Often sorted                   |
| State    | Maintains window state (sum, map, set) | No state beyond pointers       |
| Movement | Right expands, left shrinks            | Both can move in any direction |
| Example  | Longest substring with K distinct      | Two sum in sorted array        |

---

## 📚 Problem Bank

| #   | Problem                                   | Variant            | Difficulty |
| --- | ----------------------------------------- | ------------------ | ---------- |
| 1   | Max sum subarray of size K                | Fixed              | Easy       |
| 2   | Longest subarray with sum ≤ K             | Variable           | Medium     |
| 3   | Longest substring without repeats         | Variable + HashSet | Medium     |
| 4   | Minimum window substring                  | Variable + HashMap | Hard       |
| 5   | Max consecutive ones III (flip K zeros)   | Variable           | Medium     |
| 6   | Fruits into baskets (at most 2 types)     | Variable + HashMap | Medium     |
| 7   | Longest substring with at most K distinct | Variable + HashMap | Medium     |
| 8   | Permutation in string                     | Fixed + HashMap    | Medium     |

_Problems will be solved progressively in Chapter 6._
