# Chapter 2 — The Universal Checklist

## The 5 Steps That Solve EVERYTHING

```flow
BRUTE FORCE → BOTTLENECK → PATTERN → PROOF → TEMPLATE
```

---

## Step 1: Brute Force — Always Start Here

Translate: English → Human action → Code shape

### The 3 Universal Brute Force Shapes

| Shape         | When                              | Code                | Complexity |
| ------------- | --------------------------------- | ------------------- | ---------- |
| **Pairs**     | Subarray, two elements, start/end | `for i` + `for j`   | O(n²)      |
| **Subsets**   | Include/exclude decisions         | Recursion / bitmask | O(2ⁿ)      |
| **Orderings** | Arrangements, all paths           | Permutations / DFS  | O(n!)      |

### Shape Detection Rules

| Problem says...                             | Shape                         |
| ------------------------------------------- | ----------------------------- |
| subarray / substring                        | **Pairs** (start, end)        |
| subsequence / subset / combination          | **Subsets** (include/exclude) |
| arrangement / schedule / permutation / path | **Orderings**                 |

### ⚠️ Not everything needs optimization

If brute force is already O(n) or O(n log n), it might already BE the solution (e.g., palindrome check).

---

## Step 2: Identify the Bottleneck

Ask: **"What SPECIFIC operation makes this slow?"**

### The 6 Common Bottlenecks

| Bottleneck                | You Hear Yourself Saying...                      | Fix                    |
| ------------------------- | ------------------------------------------------ | ---------------------- |
| **Redundant search**      | "I keep looking for X in the array"              | Hashmap                |
| **Redundant computation** | "I keep recalculating the same thing"            | DP / Prefix Sum        |
| **Redundant comparison**  | "I'm comparing things I already know"            | Sort first             |
| **Scanning for min/max**  | "Every step I need the current min/max"          | Heap / Monotonic Stack |
| **Exploring all paths**   | "I'm going down the same path twice"             | Memoization / BFS      |
| **Rechecking window**     | "I'm re-examining elements that haven't changed" | Sliding Window         |

---

## Step 3: Pattern Mapping

Bottleneck → Pattern (almost automatic):

```list
Searching repeatedly      →  Hashmap
Recalculating same thing  →  DP / Memoization
Nested loop on contiguous →  Sliding Window
Need min/max repeatedly   →  Heap / Monotonic Stack
Too many paths            →  BFS / DFS with pruning
Checking connectivity     →  Union Find
Dependencies exist        →  Topological Sort
```

---

## Step 4: Prove Your Solution

Answer these to satisfy any interviewer:

1. **"Does this cover ALL cases?"** — No edge case missed
2. **"Why is greedy valid here?"** — Greedy needs justification
3. **"What's the complexity?"** — Must beat brute force

### Quick Proof Template

```doc
"My approach works because:
 1. Every element is visited exactly [once/twice/...]
 2. At each step, [invariant holds because...]
 3. Therefore, time = O(...), space = O(...)"
```

---

## Step 5: Template Execution

Plug into the reusable code skeleton for the identified pattern.
See `/patterns/` directory for all templates.

---

## Full Pipeline Example

**Problem**: "Longest substring without repeating characters"

```
STEP 1 — BRUTE FORCE:
  For every pair (i, j): check if substring has no repeats
  Shape: Pairs | O(n³)

STEP 2 — BOTTLENECK:
  "I'm RE-CHECKING all characters when I extend by 1"
  → Rechecking window bottleneck

STEP 3 — PATTERN:
  Rechecking window → Sliding Window
  Track uniqueness  → + HashSet

STEP 4 — PROOF:
  "Each char added once, removed once → O(n)"
  "HashSet ensures no repeats in O(1)"
  "Window always represents a valid substring"

STEP 5 — TEMPLATE:
  Variable Sliding Window + shrink when duplicate found
```

```java
public int lengthOfLongestSubstring(String s) {
    Set<Character> window = new HashSet<>();
    int left = 0, result = 0;

    for (int right = 0; right < s.length(); right++) {
        while (window.contains(s.charAt(right))) {  // invalid
            window.remove(s.charAt(left++));         // shrink
        }
        window.add(s.charAt(right));                 // expand
        result = Math.max(result, right - left + 1); // update
    }
    return result;
}
```

---

## Practice Problems

### Problem 1 (Completed ✅)

> "Given an array of positive integers, find the length of the longest subarray where sum ≤ K"

```
STEP 1: Pairs shape, O(n²)
STEP 2: Recalculating sum i..j every time
STEP 3: Sliding Window (variable)
STEP 4: When sum > k, all larger windows from same left are invalid
         → safe to move left forward
         ⚠️ Only works with positive numbers!
STEP 5: Variable Sliding Window template
```

### Problem 2 (Pending — Code It!)

> Code Problem 1 in Java using the variable sliding window template.
> See: `/code/java/SlidingWindowLongestSubarray.java`

---

## Pop Quiz Bank (Chapter 2)

**Q1**: What bottleneck does "I keep looking for the complement" map to?
**A1**: Redundant search → Hashmap

**Q2**: Problem says "contiguous subarray with max sum" — what's the brute force shape?
**A2**: Pairs (start i, end j) → O(n²)

**Q3**: When does the sliding window proof break?
**A3**: When array contains negative numbers (shrinking left doesn't guarantee sum decreases)
