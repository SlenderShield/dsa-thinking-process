# Chapter 9 — Stacks & Monotonic Structures (Deep Dive)

## 🎯 When Does Stack Fire?

### Instant Triggers

- "Matching pairs" (parentheses, brackets, tags)
- "Next greater/smaller element"
- "Undo" operations
- "Most recent" / "last seen"
- "Histogram" / "area" problems
- "Evaluate expression" / "calculator"
- Anything involving **LIFO** (Last In, First Out) logic

### The Core Idea

A stack answers: **"What's the most recent thing I haven't resolved yet?"**

Every time you push onto a stack, you're saying _"I'll deal with this later."_
Every time you pop, you're saying _"Now I can resolve this."_

---

## Pattern 1: Matching / Validation

**Smell**: "Valid parentheses", "matching brackets", "balanced"

```java
// TEMPLATE: Matching Brackets
public boolean isValid(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    for (char c : s.toCharArray()) {
        if (c == '(' || c == '{' || c == '[') {
            stack.push(c);
        } else {
            if (stack.isEmpty()) return false;
            char top = stack.pop();
            if ((c == ')' && top != '(') ||
                (c == '}' && top != '{') ||
                (c == ']' && top != '['))
                return false;
        }
    }
    return stack.isEmpty();
}
```

**Why stack works**: Opening brackets wait for their match. The MOST RECENT opener should match FIRST → LIFO.

---

## Pattern 2: Monotonic Stack ⭐ (The Big One)

This is the **most important pattern** in this chapter. Shows up constantly in interviews.

### The Smell

- "Next greater element"
- "Next smaller element"
- "Previous greater/smaller element"
- "How many days until warmer?"
- "Largest rectangle in histogram"

### The Core Insight

A **monotonic stack** maintains elements in sorted order (either increasing or decreasing). When a new element breaks the monotonic property, you POP and resolve.

### Monotonic Decreasing Stack (for "Next Greater Element")

```text
Processing: [2, 1, 4, 3]

Stack state at each step:
Step 1: push 2           Stack: [2]
Step 2: push 1 (1 < 2)   Stack: [2, 1]      ← still decreasing
Step 3: 4 > 1? YES → pop 1, nextGreater[1]=4
        4 > 2? YES → pop 2, nextGreater[0]=4
        push 4            Stack: [4]
Step 4: push 3 (3 < 4)   Stack: [4, 3]

Result: nextGreater = [4, 4, -1, -1]
```

### The Template

```java
// TEMPLATE: Next Greater Element (Monotonic Decreasing Stack)
// Stack stores INDICES (not values) so we can compute distances
public int[] nextGreaterElement(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    Arrays.fill(result, -1);
    Deque<Integer> stack = new ArrayDeque<>(); // stores indices

    for (int i = 0; i < n; i++) {
        // Pop everything SMALLER than current (they found their next greater)
        while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
            result[stack.pop()] = nums[i];
        }
        stack.push(i);
    }
    return result;
}
```

### The 4 Variants

| Variant          | Stack Type | Pop Condition             | Use Case           |
| ---------------- | ---------- | ------------------------- | ------------------ |
| Next Greater     | Decreasing | `stack.peek() < current`  | Daily temperatures |
| Next Smaller     | Increasing | `stack.peek() > current`  | Stock span         |
| Previous Greater | Decreasing | `stack.peek() <= current` | Histogram          |
| Previous Smaller | Increasing | `stack.peek() >= current` | Histogram          |

**Memory trick**:

- Want "next GREATER"? → Keep stack **decreasing** (pop when something bigger comes)
- Want "next SMALLER"? → Keep stack **increasing** (pop when something smaller comes)

---

## Pattern 3: Stack for State Tracking

**Smell**: "Nested structures", "evaluating expressions", "decode strings"

### Example: Decode String `"3[a2[c]]"` → `"accaccacc"`

```java
// Use stack to track "context" at each nesting level
Deque<StringBuilder> strStack = new ArrayDeque<>();
Deque<Integer> countStack = new ArrayDeque<>();
```

Each `[` pushes current context. Each `]` pops and repeats.

---

## ⚡ Key Decision: Stack vs Other Patterns

| Situation                 | Pattern                 | Why Not Stack?             |
| ------------------------- | ----------------------- | -------------------------- |
| Need next greater element | **Stack** (monotonic)   | Perfect fit                |
| Need overall max/min      | **Just track variable** | Stack is overkill          |
| Need K-th largest         | **Heap**                | Stack doesn't support K-th |
| Need sliding window max   | **Monotonic Deque**     | Need both ends             |
| LIFO processing           | **Stack**               | Definition of stack        |
| FIFO processing           | **Queue**               | Opposite order             |

---

## 🧪 Practice Problems

### Level 1: Basic Stack

#### Problem 1: Valid Parentheses (LeetCode 20)

> Input: `"()[]{}"` → true, `"(]"` → false
> This is the foundation. Get it clean.

#### Problem 2: Min Stack (LeetCode 155)

> Design a stack that supports push, pop, top, and getMin in O(1).
> Hint: Use two stacks — one normal, one tracking minimums.

---

### Level 2: Monotonic Stack

#### Problem 3: Daily Temperatures (LeetCode 739) ⭐

> Given temperatures, for each day find how many days until warmer.
> Input: `[73,74,75,71,69,72,76,73]`
> Output: `[1,1,4,2,1,1,0,0]`
>
> This IS the "next greater element" pattern with distances.

#### Problem 4: Next Greater Element I (LeetCode 496)

> Two arrays nums1, nums2. For each in nums1, find next greater in nums2.
> Input: nums1 = `[4,1,2]`, nums2 = `[1,3,4,2]`
> Output: `[-1,3,-1]`

---

### Level 3: Advanced Monotonic

#### Problem 5: Largest Rectangle in Histogram (LeetCode 84) ⭐⭐ HARD

> Given heights, find largest rectangle area.
> Input: `[2,1,5,6,2,3]`
> Output: 10 (width 2 × height 5)
>
> KEY INSIGHT: For each bar, find how far LEFT and RIGHT it can extend
> → Previous Smaller + Next Smaller → one monotonic stack pass!

---

### Level 4: Discrimination

Is this a Stack problem? YES or NO, and what pattern?

**A**: "Check if string of brackets is balanced"
→ Stack? **_ Pattern: _**

**B**: "Find maximum element in sliding window of size K"
→ Stack? **_ Pattern: _**

**C**: "For each element, find nearest smaller to the left"
→ Stack? **_ Pattern: _**

**D**: "Evaluate postfix expression: 2 3 + 5 \*"
→ Stack? **_ Pattern: _**

**E**: "Find shortest path in grid"
→ Stack? **_ Pattern: _**
