# Pattern 07 — HashMap Patterns

## Smell Triggers

- "Find pair with target" (unsorted)
- "Count frequency", "most/least frequent"
- "Group by" / "anagram grouping"
- "First non-repeating"
- "Check if exists" in O(1)

## Template 1 — Complement Lookup (Two Sum)

```java
Map<Integer, Integer> seen = new HashMap<>();
for (int i = 0; i < nums.length; i++) {
    int complement = target - nums[i];
    if (seen.containsKey(complement)) {
        return new int[]{seen.get(complement), i};
    }
    seen.put(nums[i], i);
}
```

## Template 2 — Frequency Count

```java
Map<Character, Integer> freq = new HashMap<>();
for (char c : s.toCharArray()) {
    freq.merge(c, 1, Integer::sum);
}
```

**Optimization**: Use `int[26]` for lowercase a-z, `int[128]` for ASCII.

## Template 3 — Grouping (Anagrams)

```java
Map<String, List<String>> groups = new HashMap<>();
for (String s : strs) {
    char[] chars = s.toCharArray();
    Arrays.sort(chars);
    String key = new String(chars);
    groups.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
}
```

**Faster key**: Use frequency array `Arrays.toString(new int[26])` → O(k) vs O(k log k).

## Template 4 — Existence Check (HashSet)

```java
Set<Integer> seen = new HashSet<>();
for (int num : nums) {
    if (!seen.add(num)) return true;  // duplicate
}
```

## HashMap vs Alternatives

| Need                 | Best Choice  | Why                      |
| -------------------- | ------------ | ------------------------ |
| Unsorted pair sum    | HashMap      | O(1) lookup              |
| Sorted pair sum      | Two Pointers | O(1) space               |
| Bounded values (a-z) | int[26]      | Faster than HashMap      |
| Need ordering        | TreeMap      | O(log n) but sorted keys |

## Complexity

- Time: **O(1)** average per operation
- Space: **O(n)**

## LeetCode Problems

- 1: Two Sum
- 217: Contains Duplicate
- 387: First Unique Character
- 347: Top K Frequent Elements
- 49: Group Anagrams
- 128: Longest Consecutive Sequence
