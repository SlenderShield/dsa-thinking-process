# Chapter 11 — Linked Lists (Deep Dive)

## 🎯 When Does Linked List Fire?

### Instant Triggers

- "Reverse a linked list"
- "Detect cycle"
- "Merge sorted lists"
- "Find middle"
- "Remove N-th from end"
- Any problem giving you `ListNode head`

### The Core Idea

A linked list is **sequential access only** — you can't jump to index 5. Every operation requires traversal. The trade-off: **O(1) insert/delete** (if you have the node) vs **O(n) access**.

---

## Pattern 1: Traversal & Dummy Head

**Smell**: "Build/modify a list where the head might change"

```java
// TEMPLATE: Dummy Head
ListNode dummy = new ListNode(0);
dummy.next = head;
ListNode prev = dummy;

// ... operations that might remove/change head ...

return dummy.next;  // new head
```

**Why dummy?** Without it, removing the head node is a special case. Dummy eliminates edge cases.

---

## Pattern 2: Fast-Slow Pointers (Floyd's) ⭐

**Smell**: "Find middle", "Detect cycle", "Find cycle start"

### Find Middle

```java
ListNode slow = head, fast = head;
while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}
// slow is at middle (for even length: second middle)
```

### Detect Cycle

```java
ListNode slow = head, fast = head;
while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
    if (slow == fast) return true;  // cycle!
}
return false;
```

### Find Cycle Start (LeetCode 142)

```java
// After slow == fast, reset one pointer to head
// Move both at speed 1 → they meet at cycle start
slow = head;
while (slow != fast) {
    slow = slow.next;
    fast = fast.next;
}
return slow;  // cycle start
```

---

## Pattern 3: Reverse Linked List ⭐⭐ (The Foundation)

**Smell**: "Reverse", "palindrome check", "reorder"

This is the **most important linked list skill**. It's a sub-routine used in many problems.

```java
// TEMPLATE: Iterative Reverse
public ListNode reverse(ListNode head) {
    ListNode prev = null, curr = head;
    while (curr != null) {
        ListNode next = curr.next;  // save next
        curr.next = prev;           // reverse pointer
        prev = curr;                // advance prev
        curr = next;                // advance curr
    }
    return prev;  // new head
}
```

**Visualization**:

```
Before: 1 → 2 → 3 → null
Step 1: null ← 1   2 → 3 → null   (prev=1, curr=2)
Step 2: null ← 1 ← 2   3 → null   (prev=2, curr=3)
Step 3: null ← 1 ← 2 ← 3          (prev=3, curr=null)
Return prev (3)
```

**The 3 variables**: `prev`, `curr`, `next` — memorize this triple.

---

## Pattern 4: Merge Two Sorted Lists

**Smell**: "Merge sorted", "combine lists in order"

```java
public ListNode merge(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    while (l1 != null && l2 != null) {
        if (l1.val <= l2.val) {
            curr.next = l1;
            l1 = l1.next;
        } else {
            curr.next = l2;
            l2 = l2.next;
        }
        curr = curr.next;
    }
    curr.next = (l1 != null) ? l1 : l2;  // attach remainder
    return dummy.next;
}
```

---

## ⚡ Key Linked List Rules

1. **Always check `null`** before accessing `.next` or `.val`
2. **Use dummy head** when the head node might change
3. **Draw the pointers** — don't try to solve in your head
4. **`prev`, `curr`, `next`** — the holy triple for any pointer manipulation

---

## 🧪 Practice Problems

### Level 1: Foundation

#### Problem 1: Reverse Linked List (LeetCode 206)

> Reverse a singly linked list.
> Input: 1→2→3→4→5 → Output: 5→4→3→2→1
> This is THE fundamental skill. Must be instant.

#### Problem 2: Merge Two Sorted Lists (LeetCode 21)

> Merge two sorted linked lists into one sorted list.
> Input: 1→2→4, 1→3→4 → Output: 1→1→2→3→4→4

---

### Level 2: Two-Pointer Tricks

#### Problem 3: Linked List Cycle (LeetCode 141)

> Detect if linked list has a cycle.
> Fast-slow pointers — if they meet, there's a cycle.

#### Problem 4: Middle of Linked List (LeetCode 876)

> Find the middle node. If even length, return second middle.
> Input: 1→2→3→4→5 → Output: 3

#### Problem 5: Remove N-th Node From End (LeetCode 19) ⭐

> Remove the n-th node from the end in ONE pass.
> Input: 1→2→3→4→5, n=2 → Output: 1→2→3→5
> HINT: Use two pointers with gap of n between them.

---

### Level 3: Combined Patterns

#### Problem 6: Palindrome Linked List (LeetCode 234) ⭐⭐

> Check if linked list is a palindrome in O(1) space.
> This combines THREE patterns: find middle + reverse second half + compare!

---

### Level 4: Discrimination

**A**: "Reverse nodes in pairs"
→ LinkedList? **_ Pattern: _**

**B**: "Find intersection of two linked lists"
→ LinkedList? **_ Pattern: _**

**C**: "Sort a linked list in O(n log n)"
→ LinkedList? **_ Pattern: _**

**D**: "Remove duplicates from sorted list"
→ LinkedList? **_ Pattern: _**

**E**: "Flatten a nested list"
→ LinkedList? **_ Pattern: _**
