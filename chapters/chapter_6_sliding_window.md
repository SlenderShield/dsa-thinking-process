# Chapter 6 — Sliding Window (Deep Dive)

## 🎯 When Does Sliding Window Fire?

### Instant Triggers (< 5 seconds)

- "contiguous subarray/substring"
- "longest/shortest with condition"
- "window of size K"
- "at most K distinct"

### Confirm Checklist

- ✅ Data is contiguous (subarray, NOT subsequence)
- ✅ You maintain a window state (sum, count, set, map)
- ✅ Window expands from right, shrinks from left
- ✅ Values are positive (for sum-based problems)

### ❌ NOT Sliding Window When

- Subsequence (not contiguous) → DP
- Structural property (palindrome) → Expand around center
- Negative values with sum constraint → Prefix Sum + Hashmap
- No clear "invalid" condition to shrink

---

## The Two Variants

### Variant A: Fixed-Size Window

**Smell**: "subarray of size K", "every window of size K"

```
Template:
  1. Build first window of size K
  2. SLIDE: add right element, remove leftmost
  3. Update result at each step
```

```java
public int fixedWindow(int[] nums, int k) {
    // Build first window
    int windowSum = 0;
    for (int i = 0; i < k; i++) {
        windowSum += nums[i];
    }
    int result = windowSum;

    // Slide
    for (int i = k; i < nums.length; i++) {
        windowSum += nums[i];       // add right
        windowSum -= nums[i - k];   // remove left
        result = Math.max(result, windowSum);
    }
    return result;
}
```

**Complexity**: O(n) time, O(1) space

---

### Variant B: Variable-Size Window

**Smell**: "longest/shortest subarray/substring with condition"

```
Template:
  1. EXPAND: add right element to window state
  2. SHRINK: while window is INVALID, remove left
  3. UPDATE: result from current valid window
```

```java
public int variableWindow(int[] nums, int constraint) {
    int left = 0, result = 0;
    // window state depends on problem

    for (int right = 0; right < nums.length; right++) {
        // 1. EXPAND: add nums[right] to state

        while (/* window is INVALID */) {
            // 2. SHRINK: remove nums[left] from state
            left++;
        }

        // 3. UPDATE
        result = Math.max(result, right - left + 1);
    }
    return result;
}
```

**Key Insight**: Each element is added once (right pointer) and removed at most once (left pointer) → O(n) total, NOT O(n²).

---

## Window State Types

The "state" you track IN the window changes per problem:

| Problem Type       | Window State          | Data Structure                |
| ------------------ | --------------------- | ----------------------------- |
| Sum-based          | Running sum           | `int sum`                     |
| Count-based        | Character frequency   | `HashMap<Character, Integer>` |
| Uniqueness         | Unique elements       | `HashSet<Character>`          |
| At most K distinct | Distinct count + freq | `HashMap` + size check        |
| Min/Max in window  | Ordered elements      | `Deque` (monotonic)           |

---

## 🧪 Practice Problems (Progressive Difficulty)

### Level 1: Fixed Window

#### Problem 1: Maximum Sum Subarray of Size K

> Given array and integer k, find the maximum sum of any contiguous subarray of size k.
> Input: `[2, 1, 5, 1, 3, 2]`, k = 3
> Output: 9 (subarray [5, 1, 3])

#### Problem 2: Maximum Average Subarray (LeetCode 643)

> Find contiguous subarray of length k with maximum average.
> Input: `[1, 12, -5, -6, 50, 3]`, k = 4
> Output: 12.75

---

### Level 2: Variable Window — Sum Based

#### Problem 3: Smallest Subarray with Sum ≥ S (LeetCode 209)

> Find the MINIMUM length subarray with sum ≥ s.
> Input: `[2, 1, 5, 2, 3, 2]`, s = 7
> Output: 2 (subarray [5, 2])
>
> ⚠️ This is "shortest" not "longest" — how does that change the template?

#### Problem 4: Max Consecutive Ones III (LeetCode 1004)

> Given binary array and integer k, find longest subarray of 1s if you can flip at most k zeros.
> Input: `[1,1,1,0,0,0,1,1,1,1,0]`, k = 2
> Output: 6
>
> Hint: Think of it as "window with at most k zeros"

---

### Level 3: Variable Window — HashMap Based

#### Problem 5: Longest Substring Without Repeating Characters (LeetCode 3)

> Input: "abcabcbb"
> Output: 3 ("abc")
>
> You already know this one from Chapter 2. Code it from memory!

#### Problem 6: Longest Substring with At Most K Distinct Characters (LeetCode 340)

> Input: "eceba", k = 2
> Output: 3 ("ece")
>
> When to shrink? When map.size() > k

#### Problem 7: Fruits Into Baskets (LeetCode 904)

> Collect maximum fruits — at most 2 types.
> Input: `[1, 2, 1, 2, 3]`
> Output: 4 ([1, 2, 1, 2])
>
> This IS Problem 6 with k = 2! Can you recognize the disguise?

---

### Level 4: Variable Window — Advanced

#### Problem 8: Minimum Window Substring (LeetCode 76) ⭐ HARD

> Find shortest substring of s that contains all characters of t.
> Input: s = "ADOBECODEBANC", t = "ABC"
> Output: "BANC"
>
> This is the HARDEST sliding window problem.
> Key: Track "how many characters of t are satisfied"

#### Problem 9: Permutation in String (LeetCode 567)

> Check if s2 contains a permutation of s1.
> Input: s1 = "ab", s2 = "eidbaooo"
> Output: true ("ba" is permutation of "ab")
>
> Hint: Fixed window of size s1.length() + frequency match

---

### Level 5: Discrimination Challenge

#### Problem 10: Is This Sliding Window?

For each problem, answer YES or NO, and if NO, what pattern instead:

**A**: "Find longest palindromic substring"
→ Sliding Window? **_ Pattern: _**

**B**: "Find longest subarray with sum ≤ K (all positive)"
→ Sliding Window? **_ Pattern: _**

**C**: "Count subarrays with sum exactly K (with negatives)"
→ Sliding Window? **_ Pattern: _**

**D**: "Find longest substring with at most 2 repeating characters"
→ Sliding Window? **_ Pattern: _**

**E**: "Find two numbers in sorted array that sum to target"
→ Sliding Window? **_ Pattern: _**

---

## ⚡ Key Decisions Cheat Sheet

### "Longest" vs "Shortest"

| Goal         | Template Difference                                                |
| ------------ | ------------------------------------------------------------------ |
| **Longest**  | Update result AFTER shrinking (window is now valid, maximize)      |
| **Shortest** | Update result DURING shrinking (each valid shrink could be answer) |

```java
// LONGEST:
while (invalid) { shrink; }
result = Math.max(result, right - left + 1);  // after shrink

// SHORTEST:
while (valid) {
    result = Math.min(result, right - left + 1);  // during shrink
    shrink;
}
```

### "At Most K" vs "Exactly K"

**Trick**: Exactly K = atMost(K) - atMost(K - 1)

This is a classic interview trick — don't try to solve "exactly K" directly.

---

## Assignment

**Code Problems 1-4 first** (they build from easy → medium).

Then attempt **Problem 5-7** (HashMap-based).

Finally, try the **Discrimination Challenge (Problem 10)** — this tests your pattern boundaries.

Save everything in `code/java/Ch6_SlidingWindow.java`.
