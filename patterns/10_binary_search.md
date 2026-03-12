# Pattern 10 — Binary Search

## Smell Triggers
- "Sorted array" + search / find
- "First/last occurrence"
- "Minimum/maximum satisfying condition"
- "Rotated sorted array"
- Constraint demands **O(log n)**

## Template A — Classic (Find Exact)

```java
int lo = 0, hi = nums.length - 1;
while (lo <= hi) {
    int mid = lo + (hi - lo) / 2;
    if (nums[mid] == target) return mid;
    else if (nums[mid] < target) lo = mid + 1;
    else hi = mid - 1;
}
return -1;
```

## Template B — Lower Bound (First ≥ target)

```java
int lo = 0, hi = nums.length;     // hi = length, NOT length-1
while (lo < hi) {                  // strict <, NOT <=
    int mid = lo + (hi - lo) / 2;
    if (nums[mid] < target) lo = mid + 1;
    else hi = mid;                 // mid COULD be answer
}
return lo;
```

## Template C — Binary Search on Answer Space ⭐⭐

```java
int lo = MIN_POSSIBLE, hi = MAX_POSSIBLE;
while (lo < hi) {
    int mid = lo + (hi - lo) / 2;
    if (condition(mid)) hi = mid;   // works → try smaller
    else lo = mid + 1;              // doesn't work → try bigger
}
return lo;
```

**Requirement**: `condition(x)` must be **monotonic** — once true, stays true.

## The Critical Differences

| | Classic | Boundary | Answer Space |
|---|---------|----------|-------------|
| `hi` init | `n-1` | `n` | max answer |
| Loop | `lo <= hi` | `lo < hi` | `lo < hi` |
| On match | **return** | keep searching | keep searching |
| Result | exact or -1 | boundary index | min valid answer |

## Common Traps
- ⚠️ `mid = lo + (hi - lo) / 2` NOT `(lo + hi) / 2` (overflow!)
- ⚠️ Classic: `lo <= hi`. Boundary: `lo < hi`. Mixing causes infinite loops
- ⚠️ Rotated: one half is ALWAYS sorted — check that half first

## LeetCode Problems
- 704: Binary Search
- 34: First and Last Position
- 33: Search in Rotated Sorted Array
- 153: Find Minimum in Rotated Sorted
- 875: Koko Eating Bananas
- 1011: Capacity to Ship Packages
- 69: Sqrt(x)
