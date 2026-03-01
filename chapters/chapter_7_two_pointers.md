# Chapter 7 — Two Pointers (Deep Dive)

## 🎯 When Does Two Pointers Fire?

### Instant Triggers

- "Sorted array" + condition on pair/triplet
- "In-place" removal or modification
- "Linked list cycle detection"
- "Partition" or "rearrange"
- "Palindrome check"

### ❌ NOT Two Pointers When

- Data is unsorted AND you need pair with target → HashMap (O(n)) is better
- You need ALL subarrays → Sliding Window or Prefix Sum
- The "two" things aren't in the same linear structure

---

## The 3 Variants

### Variant A: Opposite Ends (Converging)

**Smell**: Sorted array + find pair + condition

```text
[1, 2, 3, 5, 8, 11]
 ↑                ↑
 left          right      → move inward
```

```java
// TEMPLATE: Opposite Ends
int left = 0, right = nums.length - 1;
while (left < right) {
    int current = compute(nums[left], nums[right]);
    if (current == target) {
        // FOUND — process result
        return result;
    } else if (current < target) {
        left++;     // need bigger → move left forward
    } else {
        right--;    // need smaller → move right backward
    }
}
```

**When to use**: Sorted data + pair condition (sum, difference, product)

**Why it works**: Sorted order means moving left increases value, moving right decreases value. This creates a binary-search-like narrowing.

---

### Variant B: Same Direction (Fast-Slow for Arrays)

**Smell**: "Remove duplicates", "remove element", "partition in-place"

```text
[0, 1, 0, 3, 12]
 ↑
 slow (write position)
    ↑
    fast (scan position)
```

```java
// TEMPLATE: Same Direction (Read-Write)
int slow = 0;  // write position
for (int fast = 0; fast < nums.length; fast++) {
    if (shouldKeep(nums[fast])) {
        nums[slow++] = nums[fast];
    }
}
// Everything [0..slow-1] is valid, rest is garbage
```

**When to use**: In-place array modification without extra space

**Key examples**:

- Remove duplicates from sorted array
- Move zeros to end
- Remove element
- Partition even/odd

---

### Variant C: Fast-Slow (Linked Lists / Cycle Detection)

**Smell**: "Detect cycle", "find middle", "find start of cycle"

```java
// TEMPLATE: Floyd's Cycle Detection
ListNode slow = head, fast = head;
while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;

    if (slow == fast) {
        // CYCLE DETECTED
        break;
    }
}
// If loop exited naturally: no cycle
// If slow == fast: cycle exists
```

**Why it works**: If there's a cycle, fast "laps" slow. Like two runners on a circular track — the faster one will catch up.

**Finding cycle start (Phase 2)**:

```java
// After detecting cycle:
ListNode entry = head;
while (entry != slow) {
    entry = entry.next;
    slow = slow.next;
}
// entry == slow == cycle start
```

---

## Two Pointers vs Other Patterns

| Situation             | Pattern                           | Why                     |
| --------------------- | --------------------------------- | ----------------------- |
| Sorted + pair sum     | **Two Pointers**                  | O(n), O(1) space        |
| Unsorted + pair sum   | **HashMap**                       | Need O(n) lookup        |
| Sorted + triplet sum  | **Two Pointers** (nested)         | Fix one, TP on rest     |
| Subarray condition    | **Sliding Window**                | Not pairs, it's a range |
| In-place modification | **Two Pointers** (same direction) | Read-write pattern      |
| Cycle detection       | **Fast-Slow**                     | Floyd's algorithm       |

---

## ⚠️ Common Traps

### Trap 1: Using Two Pointers on Unsorted Data for Target Sum

```text
Unsorted [3, 1, 4, 2] find pair sum = 5
Two pointers DON'T WORK (needs sorted property)
Use HashMap instead!
```

### Trap 2: Forgetting to Skip Duplicates in Three Sum

```java
// After finding a triplet, skip duplicates:
while (left < right && nums[left] == nums[left + 1]) left++;
while (left < right && nums[right] == nums[right - 1]) right--;
left++;
right--;
```

### Trap 3: Off-by-One in Same-Direction

```text
slow points to NEXT WRITE POSITION (not last written)
After loop: valid elements = [0, slow - 1]
Return slow (the count), not slow - 1
```

---

## 🧪 Practice Problems

### Level 1: Opposite Ends (Converging)

#### Problem 1: Two Sum II — Sorted (LeetCode 167)

> Sorted array, find two numbers that sum to target. Return 1-indexed positions.
> Input: `[2, 7, 11, 15]`, target = 9
> Output: `[1, 2]`

#### Problem 2: Container With Most Water (LeetCode 11)

> Given heights array, find two lines that form container with most water.
> Input: `[1, 8, 6, 2, 5, 4, 8, 3, 7]`
> Output: 49
>
> Why do we move the SHORTER line? Think about it before coding.

#### Problem 3: Valid Palindrome (LeetCode 125)

> Check if string is palindrome, ignoring non-alphanumeric and case.
> Input: "A man, a plan, a canal: Panama"
> Output: true

---

### Level 2: Same Direction

#### Problem 4: Remove Duplicates from Sorted Array (LeetCode 26)

> Remove duplicates in-place, return new length.
> Input: `[1, 1, 2]`
> Output: 2, array becomes `[1, 2, ...]`

#### Problem 5: Move Zeroes (LeetCode 283)

> Move all zeros to end, maintain order of non-zeros. In-place.
> Input: `[0, 1, 0, 3, 12]`
> Output: `[1, 3, 12, 0, 0]`
>
> This is the revision problem from above!

---

### Level 3: Multi-Pointer

#### Problem 6: Three Sum (LeetCode 15) ⭐

> Find all unique triplets that sum to zero.
> Input: `[-1, 0, 1, 2, -1, -4]`
> Output: `[[-1, -1, 2], [-1, 0, 1]]`
>
> Strategy: Sort → fix one element → Two Pointers on the rest
> TRAP: Skip duplicates!

---

### Level 4: Linked List (Fast-Slow)

#### Problem 7: Linked List Cycle (LeetCode 141)

> Detect if linked list has a cycle.
> Use Floyd's algorithm.

#### Problem 8: Middle of Linked List (LeetCode 876)

> Find the middle node. When fast reaches end, slow is at middle.

---

### Level 5: Discrimination

Is this Two Pointers? YES or NO, and if NO, what pattern?

**A**: "Find longest substring without repeating chars"
→ TP? **_ Pattern: _**

**B**: "Remove duplicates from sorted linked list"
→ TP? **_ Pattern: _**

**C**: "Find pair with given difference in sorted array"
→ TP? **_ Pattern: _**

**D**: "Find subarray with max sum"
→ TP? **_ Pattern: _**

**E**: "Merge two sorted arrays in-place"
→ TP? **_ Pattern: _**
