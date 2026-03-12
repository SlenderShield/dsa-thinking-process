# Chapter 10 — Binary Search (Deep Dive)

## 🎯 When Does Binary Search Fire?

### Instant Triggers
- "Sorted array" + search
- "Find first/last occurrence"
- "Minimum/maximum that satisfies condition"
- "Search in rotated sorted array"
- Constraint: **O(log n)** required
- "Is there a value X such that..."

### The Core Idea
Binary search = **eliminating half the search space** each step. But it's NOT just for "find element in sorted array." The real power is **Binary Search on Answer Space**.

---

## Pattern 1: Classic Binary Search

**Smell**: "Find target in sorted array"

```java
// TEMPLATE: Classic BS
public int search(int[] nums, int target) {
    int lo = 0, hi = nums.length - 1;
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;  // avoid overflow
        if (nums[mid] == target) return mid;
        else if (nums[mid] < target) lo = mid + 1;
        else hi = mid - 1;
    }
    return -1;
}
```

**Key**: `lo <= hi` (inclusive bounds), return exact match.

---

## Pattern 2: Boundary Finding ⭐ (The Important One)

**Smell**: "Find FIRST element ≥ target" or "Find LAST element ≤ target"

This is where 90% of BS mistakes happen. The trick: **don't return early on match**.

### Template A: Find Leftmost (First ≥ target)

```java
// Returns the first index where nums[index] >= target
// (This is Java's Arrays.binarySearch insertion point)
public int lowerBound(int[] nums, int target) {
    int lo = 0, hi = nums.length;  // NOTE: hi = length (not length-1)
    while (lo < hi) {              // NOTE: strict < (not <=)
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] < target) {
            lo = mid + 1;          // mid is too small, search right
        } else {
            hi = mid;              // mid COULD be answer, keep it
        }
    }
    return lo;  // lo == hi == insertion point
}
```

### Template B: Find Rightmost (Last ≤ target)

```java
public int upperBound(int[] nums, int target) {
    int lo = 0, hi = nums.length;
    while (lo < hi) {
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] <= target) {
            lo = mid + 1;          // mid might work, but try right
        } else {
            hi = mid;
        }
    }
    return lo - 1;  // last element ≤ target
}
```

### Two Templates Comparison

| | Classic | Lower Bound | Upper Bound |
|---|---------|-------------|-------------|
| `hi` init | `n - 1` | `n` | `n` |
| Loop | `lo <= hi` | `lo < hi` | `lo < hi` |
| On match | `return mid` | `hi = mid` | `lo = mid + 1` |
| Returns | exact index | first ≥ | first > |

**Why they differ**: Classic wants exact match. Boundary wants to KEEP SEARCHING even after finding a match, to find the leftmost/rightmost one.

---

## Pattern 3: Binary Search on Answer Space ⭐⭐ (The Game Changer)

**Smell**: "Find minimum X such that condition(X) is true"

This is the most powerful BS pattern. Instead of searching through data, you search through **possible answers**.

### The Key Insight

If you can define a **monotonic condition** (once it becomes true, it stays true), you can binary search on it.

```
Answers:    1  2  3  4  5  6  7  8  9  10
Condition:  F  F  F  F  T  T  T  T  T  T
                         ^
                    Find this boundary!
```

### Template

```java
// Find minimum value where condition is TRUE
public int binarySearchAnswer(int lo, int hi) {
    while (lo < hi) {
        int mid = lo + (hi - lo) / 2;
        if (condition(mid)) {
            hi = mid;       // mid works, try smaller
        } else {
            lo = mid + 1;   // mid doesn't work, try bigger
        }
    }
    return lo;  // smallest value where condition is true
}
```

### Example: "Koko Eating Bananas" (LeetCode 875)

> Koko has piles of bananas. She can eat K bananas/hour. Find minimum K to finish within H hours.

```java
// What's the ANSWER SPACE? K can be from 1 to max(piles)
// CONDITION: canFinish(piles, K, H) → true/false
// As K increases, it goes from F,F,F,...T,T,T → monotonic!

int lo = 1, hi = maxPile;
while (lo < hi) {
    int mid = lo + (hi - lo) / 2;
    if (canFinish(piles, mid, h)) hi = mid;  // try eating slower
    else lo = mid + 1;                        // need to eat faster
}
return lo;
```

---

## ⚡ The BS Decision Tree

```
Problem involves searching?
├── Sorted array + find element → Pattern 1 (Classic)
├── Sorted + find first/last → Pattern 2 (Boundary)
├── "Minimum X such that..." → Pattern 3 (Answer Space)
└── Rotated sorted array → Modified Pattern 1
```

---

## 🧪 Practice Problems

### Level 1: Classic & Boundary

#### Problem 1: Binary Search (LeetCode 704)
> Find target in sorted array. Return index or -1.
> Input: `[-1,0,3,5,9,12]`, target = 9 → Output: 4

#### Problem 2: First and Last Position (LeetCode 34)
> Find first and last position of target in sorted array.
> Input: `[5,7,7,8,8,10]`, target = 8 → Output: `[3,4]`
> This uses BOTH lowerBound and upperBound!

---

### Level 2: Modified Binary Search

#### Problem 3: Search in Rotated Sorted Array (LeetCode 33)
> Array was sorted then rotated. Find target.
> Input: `[4,5,6,7,0,1,2]`, target = 0 → Output: 4
> KEY: One half is ALWAYS sorted. Determine which, then decide.

#### Problem 4: Find Minimum in Rotated Sorted Array (LeetCode 153)
> Input: `[3,4,5,1,2]` → Output: 1
> Compare mid with hi to decide which half has the minimum.

---

### Level 3: Binary Search on Answer Space ⭐⭐

#### Problem 5: Koko Eating Bananas (LeetCode 875)
> Piles = [3,6,7,11], H = 8. Min speed to finish?
> Output: 4
> Answer space: [1, max(piles)]. Condition: canFinish(speed, H).

---

### Level 4: Discrimination

Is this Binary Search? If yes, which pattern?

**A**: "Find target in sorted array"
→ BS? ___  Pattern: ___

**B**: "Find peak element (greater than neighbors)"
→ BS? ___  Pattern: ___

**C**: "Minimum speed to arrive on time"
→ BS? ___  Pattern: ___

**D**: "Find K-th largest element"
→ BS? ___  Pattern: ___

**E**: "Find square root of N (integer part)"
→ BS? ___  Pattern: ___
