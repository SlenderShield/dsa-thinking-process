# 🎓 DSA Mentorship Roadmap - Systematic Deep Dive

## 🧠 The Intuition Building System

### Why Intuition Matters

Most students memorize: "Use sliding window for subarrays"  
Elite solvers **smell**: "This problem has the sliding window shape"

**The Goal**: Train your brain to recognize patterns in < 30 seconds

---

## 🔬 How I Build Your Intuition (The 4-Layer System)

### Layer 1: Pattern Exposure (Recognition)

**What**: First encounter with a pattern  
**How**:

- I present the **pure problem** (no hints)
- You try brute force
- We identify the bottleneck together
- I reveal the pattern name AFTER you feel the pain

**Why**: Your brain learns "this pain = this pattern"

**Example**:

```
Problem: "Find max sum subarray of size k"
↓
You code: O(n*k) nested loops
↓
Pain: "I'm recalculating the same window repeatedly"
↓
Pattern revealed: "That pain is called Sliding Window"
```

---

### Layer 2: Pattern Practice (Variation)

**What**: 5-7 variations of the same pattern  
**How**:

- Slight twists on the core pattern
- You code without me showing solutions
- I provide "gradient hints" (questions, not answers)

**Why**: Your brain builds the pattern's "shape memory"

**Example Progression**:

1. Fixed window size
2. Variable window with condition
3. Window with multiple constraints
4. Window on 2D array
5. Window with preprocessing

---

### Layer 3: Pattern Mixing (Discrimination)

**What**: Problems that LOOK like pattern A but are pattern B  
**How**:

- I give you ambiguous problems
- You must identify: "Is this X or Y?"
- We analyze the **decision factors**

**Why**: You learn the pattern boundaries (critical for interviews)

**Example**:

```
"Find longest substring with K distinct characters"
↓
Looks like: Two pointers
Actually is: Sliding window with hashmap
Decision factor: Need to track frequency, not just presence
```

---

### Layer 4: Pattern Instinct (Automation)

**What**: Speed drills - Pattern identification in 30 seconds  
**How**:

- I give you 10 problem statements (no coding)
- You identify pattern + time complexity
- Timed: 30 seconds each

**Why**: Interview conditions - you need instant pattern matching

---

## 📚 Complete Mentorship Curriculum

### PART I — THE UNIVERSAL SOLVER OS (Weeks 1-2)

#### Session 1: The DSA Mindset

- How elite solvers think differently
- The pattern recognition mental model
- Building your "smell system"

#### Session 2: The Universal Checklist

- Brute Force → Bottleneck → Pattern → Proof → Template
- Practicing the 5-step system
- **Drill**: Apply to 5 unseen problems

#### Session 3: Pattern Recognition System

- The 5 master questions
- Pattern decision tree
- Constraint-to-pattern mapping

#### Session 4: Complexity & Constraint Intuition

- Reading constraints like a code
- `n ≤ 10⁵` means what?
- Time complexity ceiling detection

---

### PART II — CORE INTERVIEW WEAPONS (Weeks 3-6)

#### Chapter 5: Arrays & Strings (Week 3, Days 1-2)

**Core Patterns**:

- In-place manipulation
- Kadane's algorithm
- Dutch National Flag
- Cyclic sort

**Variations**:

- Rotate array
- Missing number detection
- Duplicate finding
- String reversal patterns

**Intuition Builder**:

- When can we modify in-place?
- When do we need extra space?
- Reading the "modifiable" constraint smell

**Practice Problems**: 8-10 problems, Layer 1-3

---

#### Chapter 6: Sliding Window (Week 3, Days 3-5)

**Core Patterns**:

- Fixed-size window
- Variable-size window (expand/shrink)
- Window with hashmap/set
- Window on strings

**Variations**:

- Max/min in window
- All subarrays with property X
- Longest/shortest window
- Multiple constraints window

**Intuition Builder**:

- The "contiguous" smell test
- When to expand vs shrink
- Window vs Two Pointers decision

**Mixing Exercise**: "Is this sliding window or two pointers?"

**Practice Problems**: 12-15 problems, all 4 layers

---

#### Chapter 7: Two Pointers (Week 4, Days 1-3)

**Core Patterns**:

- Opposite ends (start/end)
- Same direction (fast/slow)
- Three pointers (Dutch flag)
- K-way pointers

**Variations**:

- Sorted array pairs
- Palindrome checking
- Partitioning
- Cycle detection

**Intuition Builder**:

- Two pointers vs Sliding window (critical!)
- When sorting helps
- The "move towards target" smell

**Practice Problems**: 12-15 problems

---

#### Chapter 8: Hashmaps (Week 4, Days 4-5)

**Core Patterns**:

- Frequency counting
- Index tracking
- Complement finding
- Grouping/anagram detection

**Variations**:

- Two sum family
- Subarray sum = k
- LRU cache
- First unique character

**Intuition Builder**:

- "Need to remember something" → hashmap
- Space-time tradeoff recognition
- When hashset vs hashmap

**Practice Problems**: 10-12 problems

---

#### Chapter 9: Stacks & Monotonic Structures (Week 5)

**Core Patterns**:

- Monotonic increasing stack
- Monotonic decreasing stack
- Next greater element
- Stock span pattern

**Variations**:

- Histogram problems
- Valid parentheses
- Expression evaluation
- Trap water variations

**Intuition Builder**:

- The "next greater/smaller" smell
- When LIFO matters
- Stack vs Queue decision

**Practice Problems**: 12-15 problems

---

#### Chapter 10: Binary Search (Answer Space) (Week 6)

**Core Patterns**:

- Search in sorted array
- First/last occurrence
- Search in rotated array
- Binary search on answer space

**Variations**:

- Find minimum in rotated
- Kth smallest element
- Split array largest sum
- Capacity to ship packages

**Intuition Builder**:

- The "monotonic answer space" smell
- When to BS on index vs value
- "Minimize maximum" → BS smell

**Practice Problems**: 15-18 problems

---

### PART III — RECURSION WORLDS (Weeks 7-10)

#### Chapter 11: Linked Lists (Week 7)

**Core Patterns**:

- Fast/slow pointers
- Reversal (iterative/recursive)
- Dummy node technique
- Merging lists

**Variations**:

- Cycle detection
- Middle node
- Reverse in groups
- Reorder list

**Intuition Builder**:

- Runner technique recognition
- When to use dummy node
- Recursion vs iteration tradeoff

**Practice Problems**: 12-15 problems

---

#### Chapter 12: Trees (Week 8)

**Core Patterns**:

- DFS traversals (pre/in/post)
- BFS (level order)
- Top-down recursion
- Bottom-up recursion

**Variations**:

- Max depth/height
- Path sum problems
- Lowest common ancestor
- Serialize/deserialize

**Intuition Builder**:

- "Process node when?" → traversal type
- Top-down vs bottom-up decision
- The "return from children" pattern

**Practice Problems**: 15-20 problems

---

#### Chapter 13: Binary Search Trees (Week 9)

**Core Patterns**:

- BST property validation
- In-order = sorted
- Kth smallest
- Insert/delete

**Variations**:

- Range sum queries
- Convert to balanced
- Two sum in BST
- Trim BST

**Intuition Builder**:

- When BST property helps
- BST vs Binary Tree decision
- In-order traversal as default

**Practice Problems**: 10-12 problems

---

#### Chapter 14: Tries (Week 10)

**Core Patterns**:

- Insert/search
- Prefix matching
- Word search
- Autocomplete

**Variations**:

- Word dictionary (with wildcards)
- Replace words
- Stream of characters
- Maximum XOR

**Intuition Builder**:

- "Prefix operations" → Trie smell
- Trie vs Hashmap decision
- Space-time tradeoff

**Practice Problems**: 8-10 problems

---

### PART IV — GRAPH MASTERY (Weeks 11-14)

#### Chapter 15: DFS/BFS as State Machines (Week 11)

**Core Patterns**:

- Connected components
- Island problems
- Flood fill
- Matrix BFS

**Variations**:

- Number of islands (all versions)
- Walls and gates
- Surrounded regions
- Word ladder

**Intuition Builder**:

- Graph vs tree (visited set!)
- DFS vs BFS decision
- State representation in graphs

**Practice Problems**: 15-18 problems

---

#### Chapter 16: Topological Sort (Week 12, Days 1-2)

**Core Patterns**:

- Kahn's algorithm (BFS)
- DFS-based topo sort
- Cycle detection

**Variations**:

- Course schedule
- Alien dictionary
- Build order
- Sequence reconstruction

**Intuition Builder**:

- "Dependencies" → topo sort smell
- DAG detection
- When multiple valid orders exist

**Practice Problems**: 8-10 problems

---

#### Chapter 17: Shortest Paths (Week 12, Days 3-5)

**Core Patterns**:

- BFS (unweighted)
- Dijkstra (weighted)
- Bellman-Ford (negative weights)
- Floyd-Warshall (all pairs)

**Variations**:

- Network delay time
- Cheapest flights K stops
- Path with minimum effort
- Swim in rising water

**Intuition Builder**:

- Weighted vs unweighted decision
- When Dijkstra vs BFS
- State-space graphs (critical!)

**Practice Problems**: 12-15 problems

---

#### Chapter 18: Union Find (Week 13-14)

**Core Patterns**:

- Basic union-find
- Path compression
- Union by rank
- Connected components

**Variations**:

- Number of provinces
- Redundant connection
- Accounts merge
- Smallest string with swaps

**Intuition Builder**:

- "Connectivity" → Union-Find smell
- When UF vs DFS
- Dynamic connectivity problems

**Practice Problems**: 10-12 problems

---

### PART V — DYNAMIC PROGRAMMING GOD MODE (Weeks 15-21)

#### Chapter 19: DP Foundations (Week 15)

**Core Patterns**:

- Memoization (top-down)
- Tabulation (bottom-up)
- State definition
- Recurrence relation

**Variations**:

- Fibonacci
- Climbing stairs
- Min cost climbing
- House robber

**Intuition Builder**:

- "Overlapping subproblems" smell
- State identification skill
- DP vs recursion decision

**Practice Problems**: 10-12 problems

---

#### Chapter 20: Knapsack Universe (Week 16)

**Core Patterns**:

- 0/1 Knapsack
- Unbounded knapsack
- Bounded knapsack
- Multi-dimensional knapsack

**Variations**:

- Partition equal subset
- Target sum
- Coin change (all versions)
- Minimum subset difference

**Intuition Builder**:

- "Include/exclude decision" → knapsack
- Bounded vs unbounded
- Optimization vs counting vs existence

**Practice Problems**: 15-18 problems

---

#### Chapter 21: Subsequence DP (Week 17-18)

**Core Patterns**:

- LCS (longest common subsequence)
- LIS (longest increasing subsequence)
- Edit distance
- Palindromic subsequences

**Variations**:

- Minimum deletions to make sorted
- Shortest common supersequence
- Distinct subsequences
- Interleaving strings

**Intuition Builder**:

- "Subsequence" vs "subarray" (critical!)
- Two-string DP pattern
- Delete vs insert vs replace

**Practice Problems**: 15-20 problems

---

#### Chapter 22: Interval DP (Week 19)

**Core Patterns**:

- Burst balloons
- Minimum cost tree from leaves
- Palindrome partitioning
- Matrix chain multiplication

**Variations**:

- Remove boxes
- Strange printer
- Merge stones

**Intuition Builder**:

- "Split into parts" → interval DP
- Why we iterate k (split point)
- Range DP characteristic shape

**Practice Problems**: 10-12 problems

---

#### Chapter 23: Tree DP (Week 20)

**Core Patterns**:

- House robber III
- Diameter of tree
- Binary tree cameras
- Max path sum

**Variations**:

- Distribute coins
- Time to inform employees
- Longest path in tree

**Intuition Builder**:

- "Decision at each node" → tree DP
- Include/exclude parent pattern
- Post-order traversal characteristic

**Practice Problems**: 10-12 problems

---

#### Chapter 24: DP Pattern Library (Week 21)

**Advanced Patterns**:

- State machine DP (buy/sell stock)
- Bitmask DP
- DP on grids
- Probability DP

**Complete DP Decision Tree**

**Speed Drill**: 20 problems in 10 minutes (pattern ID only)

**Practice Problems**: 15-20 problems

---

### PART VI — ADVANCED INTERVIEW EDGE (Weeks 22-25)

#### Chapter 25: Greedy Proof Thinking (Week 22)

**Core Patterns**:

- Activity selection
- Interval merging
- Jump game
- Partition labels

**Intuition Builder**:

- When greedy works vs DP
- Exchange argument proofs
- Greedy choice property

**Practice Problems**: 12-15 problems

---

#### Chapter 26: Heaps & Top-K (Week 23)

**Core Patterns**:

- Min/max heap
- K closest elements
- Median maintenance
- Merge K sorted

**Variations**:

- Top K frequent
- Kth largest element
- Meeting rooms II
- Task scheduler

**Intuition Builder**:

- "Top K" → heap smell (instant)
- Min heap vs max heap
- When heap vs sorting

**Practice Problems**: 12-15 problems

---

#### Chapter 27: Segment Trees & Fenwick (Week 24)

**Core Patterns**:

- Range query + point update
- Range update + range query
- Binary indexed tree

**Intuition Builder**:

- When prefix sum isn't enough
- Segment tree vs Fenwick decision

**Practice Problems**: 8-10 problems

---

#### Chapter 28: Bit Manipulation Patterns (Week 25)

**Core Patterns**:

- XOR properties
- Bit masks
- Power of 2 tricks
- Subset generation

**Variations**:

- Single number (all versions)
- Hamming distance
- Maximum XOR
- Bitwise AND of range

**Intuition Builder**:

- XOR self-cancellation
- When bit tricks optimize

**Practice Problems**: 10-12 problems

---

### PART VII — BECOMING UNBREAKABLE (Weeks 26-28)

#### Chapter 29: How to Break Down Any Problem (Week 26)

- Unknown problem → pattern system
- Multi-pattern problems
- Edge case enumeration
- The debugging checklist

**Practice**: 10 multi-pattern problems

---

#### Chapter 30: The 100 Pattern Drill System (Week 27)

- Curated 100 problem set
- Speed solving (timer)
- Pattern mixing stress test

---

#### Chapter 31: Interview Execution Framework (Week 28)

- Communication templates
- Whiteboard strategies
- Time management
- Behavioral story bank

**Mock Interviews**: 5 full sessions

---

## 🎯 Session Structure (Every Session)

### Phase 1: Pattern Introduction (15 min)

- I explain the pattern's "shape"
- Show the canonical example
- Derive the template together

### Phase 2: Guided Problem (20 min)

- You solve with my gradient hints
- No solution peeking
- We debug your approach

### Phase 3: Independent Problems (30 min)

- You code 2-3 variations solo
- I review & provide pattern feedback

### Phase 4: Mixing Challenge (10 min)

- "Is this pattern X or Y?"
- Decision factor analysis

### Phase 5: Speed Drill (5 min)

- Rapid-fire pattern identification
- Build the instinct muscle

---

## 📊 Progress Tracking System

### After Each Pattern:

✅ Pattern Recognition Speed (target: < 30s)  
✅ Template Recall (code from memory)  
✅ Variation Handling (5+ solved)  
✅ Mixing Accuracy (90%+ correct ID)

### Weekly Review:

- Pattern library update
- Weak spot identification
- Speed drill benchmark

---

## 🧪 Why This Builds Intuition

### Traditional Learning:

```
Teacher: "Use sliding window here"
You: "OK" (but don't know WHY)
Interview: Different twist → panic
```

### My System:

```
Layer 1: You FEEL the pain → pattern revealed
Layer 2: You see 7 variations → shape memorized
Layer 3: You discriminate A vs B → boundaries learned
Layer 4: Speed drills → instinct automated
```

**Result**: Your brain has a pattern database indexed by:

- Problem shape
- Constraint signatures
- Pain points
- Decision factors

When you see: "longest substring with K distinct chars"  
Your brain auto-fires: "Sliding window + hashmap, O(n), watch for shrinking condition"

---

## 🚀 Java Implementation Philosophy

### Every Pattern Gets:

1. **Pure template** (language-agnostic pseudocode)
2. **Java implementation** (with comments mapping to template)
3. **Common variations** (with diff from base)
4. **Edge case checklist**

### Example Structure:

```java
// PATTERN: Sliding Window (Variable Size)
// TEMPLATE:
//   1. Expand window (add right element)
//   2. While (invalid): shrink (remove left)
//   3. Update result

public int solve(int[] nums, int target) {
    int left = 0, windowSum = 0, result = 0;

    for (int right = 0; right < nums.length; right++) {
        windowSum += nums[right];  // Expand

        while (windowSum > target) {  // Shrink
            windowSum -= nums[left++];
        }

        result = Math.max(result, right - left + 1);  // Update
    }

    return result;
}
```

---

## 📅 Time Commitment

**Per Session**: 1.5 - 2 hours  
**Per Week**: 5-6 sessions  
**Total Duration**: ~28 weeks (7 months)

**Accelerated Path**: 4 months (10 sessions/week)

---

## 🎓 Graduation Criteria

You've mastered DSA intuition when you can:

✅ Identify pattern in < 30 seconds (95% accuracy)  
✅ Code solution in < 15 minutes (for mediums)  
✅ Explain time/space complexity instantly  
✅ Handle twists without panic  
✅ Solve 3/3 in a mock interview

---

**Ready to start?** 🚀

Next: Chapter 1 — The DSA Mindset (Deep Dive)
