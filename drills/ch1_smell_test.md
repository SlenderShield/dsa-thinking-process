# Chapter 1 — Practice: The Smell Test

## Exercise: Identify the Brute Force Pain → Pattern

### Problem A: "Find pair summing to target"

- **Your Answer**: Two loops → hashmap → ✅ **Perfect**
- **Pain**: Redundant search (searching for complement)
- **Pattern**: Hashmap

### Problem B: "Longest substring without repeats"

- **Your Answer**: Look for each subarray → sliding window → ✅ **Correct**
- **Pain**: Rechecking window (re-examining characters)
- **Pattern**: Sliding Window + HashSet
- **Refinement needed**: Articulate the specific waste more precisely

### Problem C: "Jobs with dependencies, find valid order"

- **Your Answer**: Couldn't process → ❌ **Missed (learning moment)**
- **Pain**: O(n!) trying all orderings when dependencies define the order
- **Pattern**: Topological Sort
- **Smell trigger**: "dependencies" / "prerequisites" → Topo Sort (burn this in!)

### Problem D: "Kth largest element"

- **Your Answer**: Loop n\*k times → heap → ✅ **Correct**
- **Pain**: Sorting everything when you only need K elements
- **Pattern**: Heap (min-heap of size K)

### Problem E: "Max profit buy/sell stock once"

- **Your Answer**: Loop buy/sell pairs → two pointers → 🔶 **Pain correct, pattern wrong**
- **Pain**: O(n²) checking every buy-sell pair ✅
- **Pattern**: NOT two pointers → "Track minimum so far" (running state / Kadane's)
- **Lesson**: Two pointers needs sorted data or movement toward target

---

## Smells Unlocked

| Trigger                        | Pattern                  |
| ------------------------------ | ------------------------ |
| "Searching for complement"     | Hashmap                  |
| "Contiguous + constraint"      | Sliding Window           |
| "Dependencies / prerequisites" | Topological Sort         |
| "Top K / Kth element"          | Heap                     |
| "Need best thing before me"    | Running state / Kadane's |

## Score: 3.5/5
