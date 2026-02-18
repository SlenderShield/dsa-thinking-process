# Chapter 4 — Complexity & Constraint Intuition

## 🔑 The Superpower: Reading Constraints Like a Code

Before you even think about patterns, **read the constraints**.

They TELL you the expected time complexity. And the complexity TELLS you the pattern.

---

## The Constraint → Complexity → Pattern Pipeline

```text
Constraint (n ≤ ???)
      ↓
Expected Complexity
      ↓
Allowed Patterns
```

---

## The Constraint Table (MEMORIZE THIS)

This is one of the most powerful tools in competitive programming and interviews.

| Constraint              | Max Complexity   | Allowed Patterns                                  |
| ----------------------- | ---------------- | ------------------------------------------------- |
| n ≤ **10**              | O(n!) or O(2ⁿ)   | Brute force, backtracking, permutations           |
| n ≤ **20**              | O(2ⁿ)            | Backtracking, bitmask DP                          |
| n ≤ **100**             | O(n³)            | Floyd-Warshall, interval DP, triple loops         |
| n ≤ **1,000**           | O(n²)            | DP (2D), brute force pairs, nested loops          |
| n ≤ **10,000**          | O(n²) (tight)    | DP, careful O(n²)                                 |
| n ≤ **100,000** (10⁵)   | O(n log n)       | Sorting, binary search, heap, merge sort          |
| n ≤ **1,000,000** (10⁶) | O(n)             | Sliding window, two pointers, hashmap, prefix sum |
| n ≤ **10⁸+**            | O(log n) or O(1) | Math formula, binary search on answer             |

---

## How to Use This in Practice

### Step 0: Read Constraints BEFORE Reading the Problem

Yes, seriously. Before you even understand what the problem is asking, glance at constraints.

```
You see: n ≤ 10⁵
You think: "I need O(n log n) or better"
You know: Sorting, binary search, heap, or O(n) patterns
You DON'T try: Nested loops, O(n²) DP
```

This **eliminates patterns instantly**.

---

### Example 1: Constraint Guides Pattern

**Problem**: "Find two numbers in array that sum to target"  
**Constraint**: n ≤ 10⁶

```
n ≤ 10⁶ → need O(n) or O(n log n)
O(n²) nested loops? ❌ TOO SLOW
O(n) hashmap?        ✅ FITS
O(n log n) sort + two pointers? ✅ FITS
```

Without even thinking deeply, you've narrowed to **Hashmap** or **Sort + Two Pointers**.

---

### Example 2: Constraint Allows Brute Force

**Problem**: "Generate all permutations of array"  
**Constraint**: n ≤ 8

```
n ≤ 8 → O(n!) = 8! = 40,320 → TOTALLY FINE
No optimization needed!
Backtracking is the answer.
```

---

### Example 3: Constraint Screams Binary Search

**Problem**: "Find minimum capacity to ship packages in D days"  
**Constraint**: n ≤ 5 × 10⁴, weights up to 500

```
n ≤ 5 × 10⁴ → need O(n log n) or better
"Minimize the maximum" → Binary Search on Answer smell
Binary search over capacity × O(n) check = O(n log W) ✅
```

---

## The Complexity Cheat Sheet

### Common Pattern Complexities

| Pattern         | Time                   | Space          |
| --------------- | ---------------------- | -------------- |
| Hashmap lookup  | O(n)                   | O(n)           |
| Sliding Window  | O(n)                   | O(1) or O(k)   |
| Two Pointers    | O(n)                   | O(1)           |
| Prefix Sum      | O(n) build, O(1) query | O(n)           |
| Sorting         | O(n log n)             | O(1) to O(n)   |
| Binary Search   | O(log n)               | O(1)           |
| BFS/DFS         | O(V + E)               | O(V)           |
| Heap operations | O(n log k)             | O(k)           |
| DP (1D)         | O(n) to O(n²)          | O(n)           |
| DP (2D)         | O(n × m)               | O(n × m)       |
| Backtracking    | O(2ⁿ) or O(n!)         | O(n)           |
| Trie            | O(L) per operation     | O(total chars) |
| Union Find      | O(α(n)) ≈ O(1)         | O(n)           |

---

## Space-Time Tradeoffs

Almost every optimization trades space for time:

| Tradeoff            | Example                                          |
| ------------------- | ------------------------------------------------ |
| O(n²) → O(n) time   | Hashmap uses O(n) space to avoid inner loop      |
| O(n) → O(1) space   | Two pointers on sorted array (no hashmap needed) |
| O(2ⁿ) → O(n×target) | DP memoization uses table to avoid recomputation |

**Interview tip**: Always mention the tradeoff. "I'm using O(n) extra space to bring time from O(n²) to O(n)."

---

## Common Complexity Mistakes

### Mistake 1: "O(n log n) is always better than O(n²)"

**Wrong when**: n ≤ 100. Both are fine. Pick the simpler code.

### Mistake 2: Forgetting hidden loops

```java
// This looks like O(n) but is O(n × k)
for (int i = 0; i < n; i++) {
    String sub = s.substring(i, i + k);  // O(k) operation!
}
```

### Mistake 3: HashMap is "always O(1)"

**Technically**: O(1) amortized. Worst case O(n) due to hash collisions. But for interviews, say O(1) average.

---

## 🧪 Practice: Constraint Reading

### Exercise: What Patterns Are Eliminated?

For each constraint, list what you **CAN** and **CANNOT** use:

#### Constraint A: n ≤ 15

- CAN use: \_\_\_
- CANNOT use (overkill): \_\_\_

#### Constraint B: n ≤ 10⁵

- MUST be at most: \_\_\_
- CAN use: \_\_\_
- CANNOT use (too slow): \_\_\_

#### Constraint C: n ≤ 10⁶

- MUST be at most: \_\_\_
- CAN use: \_\_\_

#### Constraint D: n ≤ 500

- MUST be at most: \_\_\_
- What DP dimension fits?: \_\_\_

---

### Exercise: Problem → Constraint → Pattern

#### Problem 1

> "Given array of n ≤ 10⁵ integers, find subarray with max sum"
>
> Constraint tells you: **_
> Pattern: _**

#### Problem 2

> "Given n ≤ 20 items with weights and values, maximize value in knapsack"
>
> Constraint tells you: **_
> Pattern: _**

#### Problem 3

> "Given string of length n ≤ 10⁶, find longest palindromic substring"
>
> Constraint tells you: **_
> Pattern: _**

---

**Share your answers when ready!** This is the final chapter of Part I. After this, you'll have the complete Universal Solver OS, and we start coding real patterns in Part II! 🚀
