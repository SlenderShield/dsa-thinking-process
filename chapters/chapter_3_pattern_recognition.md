# Chapter 3 — Pattern Recognition System

## The 5 Master Questions (Decision Tree)

Run these in order. By Q3, you have the pattern 90% of the time.

---

### Q1: Is the data CONTIGUOUS?

_"subarray", "substring", "window", "consecutive"_

| Clue                                 | Pattern                 |
| ------------------------------------ | ----------------------- |
| Fixed size window                    | Fixed Sliding Window    |
| "Longest/shortest with condition"    | Variable Sliding Window |
| "Sum of subarray" (no window needed) | Prefix Sum              |
| Sorted array + target                | Two Pointers            |

---

### Q2: Is it asking for OPTIMAL?

_"minimum steps", "shortest path", "least cost", "maximum profit"_

| Space Type             | Pattern                 |
| ---------------------- | ----------------------- |
| Unweighted graph/grid  | BFS                     |
| Weighted graph         | Dijkstra                |
| Sequence of choices    | DP                      |
| DAG                    | DP or Topo Sort         |
| "Minimize the maximum" | Binary Search on Answer |

---

### Q3: Does brute force REPEAT work?

_"How many ways", "Can you reach", "Minimum cost to..."_

→ Draw recursion tree → same call appears twice? → **DP**

---

### Q4: Is there a RELATIONSHIP between elements?

_"connected", "prerequisite", "dependency", "network"_

| Clue                           | Pattern              |
| ------------------------------ | -------------------- |
| "Connected components"         | Union Find / DFS     |
| "Prerequisites / dependencies" | **Topological Sort** |
| "Shortest path"                | BFS / Dijkstra       |
| Tree structure                 | Tree DFS             |

---

### Q5: Is there HIDDEN ORDERING?

_"Closest pair", "merge intervals", "meeting rooms"_

→ Sort first, then: Two Pointers / Interval merge / Heap

---

## Complete Flowchart

```text
READ PROBLEM
  ├─ Q1: Contiguous?  → Sliding Window / Prefix Sum / Two Pointers
  ├─ Q2: Optimal?     → BFS / Dijkstra / DP / BS on Answer
  ├─ Q3: Repeats?     → DP / Memoization
  ├─ Q4: Relations?   → Graph (DFS/BFS/TopoSort/UnionFind)
  └─ Q5: Ordering?    → Sort first → Two Pointers / Greedy
```

## Combo Patterns (when 2 questions fire)

| Combo   | Example                                  | Pattern              |
| ------- | ---------------------------------------- | -------------------- |
| Q1 + Q3 | Longest subarray with complex constraint | Sliding Window or DP |
| Q2 + Q4 | Shortest path in graph                   | BFS / Dijkstra       |
| Q3 + Q4 | Count paths in graph                     | DFS + Memo           |
| Q4 + Q5 | Merge accounts                           | Sort + Union Find    |
