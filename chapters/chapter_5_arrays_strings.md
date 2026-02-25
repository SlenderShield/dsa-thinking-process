# Chapter 5 — Arrays & Strings

## 🎯 Why Arrays First?

Arrays are the **foundation of everything**. Sliding window? Works on arrays. Two pointers? Works on arrays. DP? Often on arrays. If you can't manipulate arrays instinctively, every other pattern will feel clunky.

This chapter teaches you **5 core array patterns** that show up constantly.

---

## Pattern 1: Kadane's Algorithm (Maximum Subarray Sum)

### The Smell

- "Maximum/minimum subarray sum"
- "Best contiguous segment"
- "I need the best thing ENDING at each position"

### The Insight

At every position, you have exactly **2 choices**:

1. **Extend** the previous subarray (add current element)
2. **Start fresh** from current element

Pick whichever gives a bigger sum.

### The Template

```java
// PATTERN: Kadane's Algorithm
// USE WHEN: "maximum subarray sum" or "best contiguous segment"
public int maxSubarraySum(int[] nums) {
    int currentSum = nums[0];
    int maxSum = nums[0];

    for (int i = 1; i < nums.length; i++) {
        // Choice: extend previous OR start fresh
        currentSum = Math.max(nums[i], currentSum + nums[i]);
        maxSum = Math.max(maxSum, currentSum);
    }
    return maxSum;
}
```

### Why It Works (Proof)

- If `currentSum` goes negative, starting fresh is ALWAYS better
- At each position, we track the best subarray ending there
- The global max must end at SOME position → we check all positions
- **O(n) time, O(1) space**

### Variations

| Variation                                 | Twist                               |
| ----------------------------------------- | ----------------------------------- |
| Minimum subarray sum                      | Flip max to min                     |
| Maximum circular subarray                 | max(Kadane, totalSum - minSubarray) |
| Maximum subarray with at most K deletions | DP on 2 states                      |

---

## Pattern 2: Dutch National Flag (3-Way Partition)

### The Smell

- "Sort array with only 2-3 distinct values"
- "Partition into groups"
- "Move all X to left, Y to right"
- "Sort colors" (LeetCode 75)

### The Insight

Use **3 pointers**:

- `low`: boundary for group 1 (everything before low is group 1)
- `mid`: current element being examined
- `high`: boundary for group 3 (everything after high is group 3)

### The Template

```java
// PATTERN: Dutch National Flag (3-Way Partition)
// USE WHEN: sort with 2-3 distinct values, partition into groups
public void dutchFlag(int[] nums) {
    int low = 0, mid = 0, high = nums.length - 1;

    while (mid <= high) {
        if (nums[mid] == 0) {         // Group 1
            swap(nums, low++, mid++);
        } else if (nums[mid] == 1) {  // Group 2
            mid++;
        } else {                      // Group 3
            swap(nums, mid, high--);
            // DON'T increment mid! Swapped element needs checking
        }
    }
}

private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}
```

### Why It Works

- `low` grows from left → group 1 elements accumulate at start
- `high` shrinks from right → group 3 elements accumulate at end
- Everything between is group 2
- **O(n) time, O(1) space, single pass**

### ⚠️ Common Trap

When swapping with `high`, **don't increment mid**! The element you swapped in hasn't been checked yet.

---

## Pattern 3: Cyclic Sort

### The Smell

- "Find missing number in range [1, n]"
- "Find duplicate in range [1, n]"
- "Array contains numbers in range [0, n] or [1, n]"
- Numbers are **bounded by array size**

### The Insight

If values are in range [1, n], every number has a "correct position": number `i` belongs at index `i-1`. Put every number in its correct position, then scan for mismatches.

### The Template

```java
// PATTERN: Cyclic Sort
// USE WHEN: values in range [1, n], find missing/duplicate
public int findMissing(int[] nums) {
    int i = 0;
    // Phase 1: Place each number at its correct index
    while (i < nums.length) {
        int correctIndex = nums[i] - 1;  // number i belongs at index i-1
        if (nums[i] > 0 && nums[i] <= nums.length
            && nums[i] != nums[correctIndex]) {
            swap(nums, i, correctIndex);
        } else {
            i++;
        }
    }

    // Phase 2: Find the mismatch
    for (int j = 0; j < nums.length; j++) {
        if (nums[j] != j + 1) {
            return j + 1;  // this number is missing
        }
    }
    return nums.length + 1;
}
```

### Why It Works

- Each number visits at most 2 positions (wrong → correct) → O(n)
- After sorting, position j should hold value j+1
- Any mismatch reveals the missing/duplicate number
- **O(n) time, O(1) space**

### When to Choose Cyclic Sort vs Hashmap

| Approach    | Time | Space    | When to Use                     |
| ----------- | ---- | -------- | ------------------------------- |
| Hashmap     | O(n) | O(n)     | When values aren't bounded by n |
| Cyclic Sort | O(n) | **O(1)** | When values are in range [1, n] |

---

## Pattern 4: Prefix Sum

### The Smell

- "Sum of subarray from i to j"
- "Multiple range sum queries"
- "Subarray sum equals K"
- "Cumulative" anything

### The Insight

Build a cumulative sum array. Then any subarray sum = one subtraction.

```
Array:      [3, 1, 4, 1, 5]
Prefix Sum: [0, 3, 4, 8, 9, 14]

Sum(1..3) = prefix[4] - prefix[1] = 9 - 3 = 6
              (sum of elements at indices 1, 2, 3)
```

### The Template

```java
// PATTERN: Prefix Sum
// USE WHEN: range sum queries, subarray sum problems
public int[] buildPrefixSum(int[] nums) {
    int[] prefix = new int[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
        prefix[i + 1] = prefix[i] + nums[i];
    }
    return prefix;
    // Sum from index l to r (inclusive) = prefix[r+1] - prefix[l]
}
```

### Advanced: Subarray Sum Equals K (with HashMap!)

This combines **Prefix Sum + Hashmap**:

```java
// "Count subarrays with sum exactly K"
// KEY INSIGHT: if prefix[j] - prefix[i] == k, then subarray [i+1..j] sums to k
public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> prefixCount = new HashMap<>();
    prefixCount.put(0, 1); // empty prefix
    int sum = 0, count = 0;

    for (int num : nums) {
        sum += num;
        // If (sum - k) was seen before, those subarrays sum to k
        count += prefixCount.getOrDefault(sum - k, 0);
        prefixCount.merge(sum, 1, Integer::sum);
    }
    return count;
}
```

### When Prefix Sum vs Sliding Window

| Technique      | Use When                                                    |
| -------------- | ----------------------------------------------------------- |
| Sliding Window | Contiguous + positive values + max/min length               |
| Prefix Sum     | Range sum queries + **negative values allowed** + exact sum |

---

## Pattern 5: In-Place Array Manipulation

### The Smell

- "Modify array without extra space"
- "O(1) space"
- "Rotate array"
- "Move zeros to end"

### Common Techniques

#### Technique A: Two-Pointer Partition (Move Zeros)

```java
// Move all zeros to end, maintain order of non-zeros
public void moveZeros(int[] nums) {
    int insertPos = 0;
    for (int num : nums) {
        if (num != 0) {
            nums[insertPos++] = num;
        }
    }
    while (insertPos < nums.length) {
        nums[insertPos++] = 0;
    }
}
```

#### Technique B: Reverse Trick (Rotate Array)

```java
// Rotate array right by k positions
// [1,2,3,4,5] rotate 2 → [4,5,1,2,3]
// Trick: reverse all, reverse first k, reverse rest
public void rotate(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);  // [5,4,3,2,1]
    reverse(nums, 0, k - 1);            // [4,5,3,2,1]
    reverse(nums, k, nums.length - 1);  // [4,5,1,2,3]
}

private void reverse(int[] nums, int left, int right) {
    while (left < right) {
        int temp = nums[left];
        nums[left++] = nums[right];
        nums[right--] = temp;
    }
}
```

---

## 📊 Pattern Quick Reference

| Pattern     | Smell Trigger                         | Complexity             |
| ----------- | ------------------------------------- | ---------------------- |
| Kadane's    | "max subarray sum", "best contiguous" | O(n), O(1)             |
| Dutch Flag  | "sort 2-3 values", "partition"        | O(n), O(1)             |
| Cyclic Sort | "missing/duplicate in [1,n]"          | O(n), O(1)             |
| Prefix Sum  | "range sum", "subarray sum = K"       | O(n) build, O(1) query |
| In-Place    | "no extra space", "O(1) space"        | O(n), O(1)             |

---

## 🧪 Practice Problems

### Problem 1: Kadane's (Easy)

> Given `[-2, 1, -3, 4, -1, 2, 1, -5, 4]`, find the maximum subarray sum.
>
> Apply the 5-step checklist, then code in Java.

### Problem 2: Dutch National Flag (Medium)

> Given `[2, 0, 2, 1, 1, 0]`, sort it in-place using only one pass.
> Values are only 0, 1, 2.
>
> Code in Java using the Dutch Flag template.

### Problem 3: Missing Number (Easy)

> Given `[3, 0, 1]` (range [0, n]), find the missing number.
> Do it in O(1) space.
>
> Choose: Cyclic Sort or Math trick? Why?

### Problem 4: Subarray Sum Equals K (Medium)

> Given `[1, 1, 1]` and k = 2, count subarrays that sum to k.
>
> Why can't sliding window work here? What pattern do you use?

### Problem 5: Rotate Array (Easy)

> Given `[1,2,3,4,5,6,7]`, rotate right by 3.
> Do it in-place with O(1) space.
>
> Use the reverse trick.

---

**Solve Problems 1-5, then share your solutions and pop quiz answers!** 💪
