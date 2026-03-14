# Pattern 11 — Linked List Patterns

## Smell Triggers

- "Reverse a linked list"
- "Detect cycle" / "find cycle start"
- "Find middle"
- "Merge sorted lists"
- "Remove N-th from end"
- "Palindrome linked list"

## Template A — Reverse (The Foundation)

```java
ListNode prev = null, curr = head;
while (curr != null) {
    ListNode next = curr.next;  // save
    curr.next = prev;           // reverse
    prev = curr;                // advance prev
    curr = next;                // advance curr
}
return prev;  // new head
```

**Memorize**: `save → reverse → advance prev → advance curr`

## Template B — Fast-Slow Pointers

```java
ListNode slow = head, fast = head;
while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}
// slow = middle | fast caught slow = cycle
```

## Template C — Dummy Head

```java
ListNode dummy = new ListNode(0);
dummy.next = head;
// ... operations that might change head ...
return dummy.next;
```

**Use when**: Head node might be removed/changed.

## Template D — Two Pointers with Gap

```java
// Remove N-th from end: create gap of n
ListNode fast = dummy, slow = dummy;
for (int i = 0; i <= n; i++) fast = fast.next;
while (fast != null) {
    fast = fast.next;
    slow = slow.next;
}
slow.next = slow.next.next;  // skip target
```

## Pattern Combinations

| Problem       | Patterns Used              |
| ------------- | -------------------------- |
| Palindrome LL | Middle + Reverse + Compare |
| Reorder List  | Middle + Reverse + Merge   |
| Sort LL       | Middle + Merge Sort        |

## Common Traps

- ⚠️ Always check `node != null` before `node.next`
- ⚠️ Fast-slow: check `fast != null && fast.next != null` (both!)
- ⚠️ Use dummy head when head might change (removal, merge)
- ⚠️ Draw the pointers on paper — LL bugs are invisible in your head

## LeetCode Problems

- 206: Reverse Linked List
- 21: Merge Two Sorted Lists
- 141: Linked List Cycle
- 876: Middle of Linked List
- 19: Remove Nth From End
- 234: Palindrome Linked List
- 143: Reorder List
