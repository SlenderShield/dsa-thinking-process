# Chapter 3 — Pattern Recognition Drill

## The 5 Master Questions Applied

### Problem A: "Sorted array, two numbers sum to target"

- **Your Answer**: Q1 (contiguous) → Two Pointers → O(n)
- **Correction**: Q5 (sorted/ordering) → Two Pointers → O(n) ✅
- **Why Q5 not Q1**: Looking for ANY two elements, not contiguous subarray. Sorted property is the trigger.

### Problem B: "Min steps in grid (0,0) to (n,m)"

- **Your Answer**: Q2 (optimal) → BFS → O(n log n)
- **Correction**: Q2 ✅ → BFS ✅ → **O(n × m)** not O(n log n)
- **Rule**: BFS = O(V+E), no log. Dijkstra has log: O(E log V)

### Problem C: "Meeting intervals, minimum rooms"

- **Your Answer**: Q5 → Sort + Interval → O(n log n) → 💯 **Perfect**

### Problem D: "Distinct subsequences"

- **Your Answer**: Q3 → DP/Memo → ✅ **Correct** (complexity: O(n×m))

### Problem E: "Courses with prerequisites"

- **Your Answer**: Don't know → DP
- **Correct**: Q4 (relationships) → **Topological Sort** ❌
- 🚨 **MISSED TWICE** — "prerequisites" = dependencies = TOPO SORT, never DP

### Problem F: "Longest increasing subsequence" (skipped)

- **Answer**: Q2 + Q3 → DP → O(n²) basic, O(n log n) optimized

## Score: 3.4/5

## Key Weakness: Q4 (dependencies → Topological Sort)
