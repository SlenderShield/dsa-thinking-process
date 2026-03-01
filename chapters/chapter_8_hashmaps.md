# Chapter 8 — Hashmaps (Deep Dive)

## 🎯 When Does HashMap Fire?

### Instant Triggers

- "Find pair with target sum" (unsorted)
- "Count frequency"
- "Check if exists" in O(1)
- "Group by" / "anagram grouping"
- "First non-repeating"
- "Subarray sum equals K" (with negatives)

### ❌ NOT HashMap When

- Data is sorted → Two Pointers is better (O(1) space)
- Need ordering/sorting → TreeMap or sort first
- Values bounded by small range → use array instead of HashMap

---

## The 5 HashMap Patterns

### Pattern 1: Complement Lookup (Two Sum)

**Smell**: "Find pair that satisfies X" in unsorted data

```java
// For each element, check if its COMPLEMENT exists
Map<Integer, Integer> seen = new HashMap<>();
for (int i = 0; i < nums.length; i++) {
    int complement = target - nums[i];
    if (seen.containsKey(complement)) {
        return new int[]{seen.get(complement), i};
    }
    seen.put(nums[i], i);
}
```

**Key**: Store value → index. Check complement BEFORE inserting.

---

### Pattern 2: Frequency Count

**Smell**: "Most frequent", "least frequent", "count occurrences"

```java
Map<Character, Integer> freq = new HashMap<>();
for (char c : s.toCharArray()) {
    freq.merge(c, 1, Integer::sum);
}
// Find most frequent:
char maxChar = Collections.max(freq.entrySet(),
    Map.Entry.comparingByValue()).getKey();
```

**Optimization**: If characters are lowercase a-z, use `int[26]` instead.

---

### Pattern 3: Grouping (Anagrams)

**Smell**: "Group items by property", "all anagrams together"

```java
// Group strings by sorted version (anagram signature)
Map<String, List<String>> groups = new HashMap<>();
for (String s : strs) {
    char[] chars = s.toCharArray();
    Arrays.sort(chars);
    String key = new String(chars);
    groups.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
}
return new ArrayList<>(groups.values());
```

**Alternative key**: Use frequency array as key (faster than sorting).

---

### Pattern 4: Prefix Sum + HashMap (Subarray Sum)

**Smell**: "Count/find subarrays with sum = K" (negative values present)

```java
Map<Integer, Integer> prefixCount = new HashMap<>();
prefixCount.put(0, 1);  // empty prefix
int sum = 0, count = 0;
for (int num : nums) {
    sum += num;
    count += prefixCount.getOrDefault(sum - k, 0);
    prefixCount.merge(sum, 1, Integer::sum);
}
```

**You already know this from Chapter 5!** This is revision.

---

### Pattern 5: Existence Check / Seen Set

**Smell**: "Contains duplicate", "first unique", "has appeared before"

```java
Set<Integer> seen = new HashSet<>();
for (int num : nums) {
    if (!seen.add(num)) {
        return true;  // duplicate found
    }
}
return false;
```

---

## HashMap vs Other Structures

| Need                 | Structure    | Time     | Space |
| -------------------- | ------------ | -------- | ----- |
| Key-Value lookup     | HashMap      | O(1) avg | O(n)  |
| Ordered keys         | TreeMap      | O(log n) | O(n)  |
| Just existence       | HashSet      | O(1) avg | O(n)  |
| Bounded values (a-z) | int[26]      | O(1)     | O(1)  |
| Sorted + pair        | Two Pointers | O(n)     | O(1)  |

**Interview rule**: If you can use `int[]` instead of HashMap (bounded range), DO IT — faster constant factor.

---

## 🧪 Practice Problems

### Level 1: Complement / Existence

#### Problem 1: Two Sum (LeetCode 1)

> Find two indices whose values sum to target. Return indices.
> Input: `[2, 7, 11, 15]`, target = 9
> Output: `[0, 1]`

#### Problem 2: Contains Duplicate (LeetCode 217)

> Return true if any value appears at least twice.
> Input: `[1, 2, 3, 1]`
> Output: true

---

### Level 2: Frequency

#### Problem 3: First Unique Character (LeetCode 387)

> Find first non-repeating character, return its index.
> Input: "leetcode"
> Output: 0 ('l')

#### Problem 4: Top K Frequent Elements (LeetCode 347)

> Return k most frequent elements.
> Input: `[1,1,1,2,2,3]`, k = 2
> Output: `[1, 2]`

---

### Level 3: Grouping

#### Problem 5: Group Anagrams (LeetCode 49)

> Group strings that are anagrams of each other.
> Input: `["eat","tea","tan","ate","nat","bat"]`
> Output: `[["eat","tea","ate"], ["tan","nat"], ["bat"]]`

---

### Level 4: Advanced

#### Problem 6: Longest Consecutive Sequence (LeetCode 128) ⭐

> Find length of longest consecutive elements sequence. Must be O(n).
> Input: `[100, 4, 200, 1, 3, 2]`
> Output: 4 (sequence: [1, 2, 3, 4])
>
> Hint: Use HashSet. Only start counting from sequence START (element with no predecessor).

---

### Level 5: Discrimination

Is this a HashMap problem? YES or NO, and what pattern?

**A**: "Find two numbers in sorted array summing to target"
→ HashMap? **_ Pattern: _**

**B**: "Group words by their first letter"
→ HashMap? **_ Pattern: _**

**C**: "Find longest substring without repeating characters"
→ HashMap? **_ Pattern: _**

**D**: "Check if two strings are anagrams"
→ HashMap? **_ Pattern: _**

**E**: "Find missing number in range [1, n]"
→ HashMap? **_ Pattern: _**
