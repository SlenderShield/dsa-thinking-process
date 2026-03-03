# Pattern 06 — Two Pointers

## Smell Triggers

- "Sorted array" + pair/triplet condition
- "In-place" removal or modification
- "Palindrome check"
- "Linked list cycle"

## Template A — Opposite Ends (Converging)

```java
int left = 0, right = nums.length - 1;
while (left < right) {
    int current = compute(nums[left], nums[right]);
    if (current == target) {
        return result;
    } else if (current < target) {
        left++;
    } else {
        right--;
    }
}
```

**Use when**: Sorted + pair condition (sum, difference)

## Template B — Same Direction (Read-Write)

```java
int slow = 0;
for (int fast = 0; fast < nums.length; fast++) {
    if (shouldKeep(nums[fast])) {
        nums[slow++] = nums[fast];
    }
}
```

**Use when**: In-place modification without extra space

## Template C — Fast-Slow (Floyd's Cycle Detection)

```java
ListNode slow = head, fast = head;
while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
    if (slow == fast) break;  // cycle detected
}
```

**Use when**: Cycle detection, find middle of list

## Core Decisions

| Situation                     | Variant                            |
| ----------------------------- | ---------------------------------- |
| Sorted + pair sum             | Opposite Ends                      |
| Remove/partition in-place     | Same Direction                     |
| Cycle / middle of list        | Fast-Slow                          |
| Unsorted + pair sum           | **NOT TP → HashMap**               |
| Pair with difference (sorted) | **Same direction** (not opposite!) |

## Complexity

- Time: **O(n)** (all variants)
- Space: **O(1)**

## Common Traps

- ⚠️ Window size = `right - left + 1`, don't track separately
- ⚠️ Same-direction: `slow` = next WRITE position (not last written)
- ⚠️ Three Sum: skip duplicates for ALL pointers after finding match

## LeetCode Problems

- 167: Two Sum II (sorted)
- 11: Container With Most Water
- 125: Valid Palindrome
- 26: Remove Duplicates
- 283: Move Zeroes
- 15: Three Sum
- 141: Linked List Cycle
- 876: Middle of Linked List
