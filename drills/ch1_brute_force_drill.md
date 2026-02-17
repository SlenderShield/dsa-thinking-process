# Chapter 1 — Practice: Brute Force Translation

## Exercise: The 3 Shapes

For each problem identify: Human approach + Brute force shape

### Problem 1: "Max sum subarray"

- **Your Answer**: for every i, for every j, compute sum, keep max → ✅
- **Shape**: Pairs ✅ (subarray = start, end pair)
- **Correction**: You said "subsets" — remember: subarray = pairs, subset = subsets

### Problem 2: "Min coins to make amount 27"

- **Your Answer**: for every coin, combine with same/different to reach target → ✅ (roughly)
- **Shape**: Subsets ✅ (order doesn't matter, include/exclude decision)
- **Correction**: You said "ordering" — ordering is when arrangement matters

### Problem 3: "Is string a palindrome?"

- **Your Answer**: check from both sides, two indices comparing → ✅ Perfect
- **Shape**: None needed — already O(n), no optimization required
- **Key lesson**: Not everything needs a pattern!

### Problem 4: "Shortest path in grid"

- **Your Answer**: check adjacent which is less → ❌ That's greedy, not brute force
- **Correct**: Try ALL possible paths → record shortest
- **Shape**: Orderings ✅ (you got this right)
- **Correction**: Greedy ≠ brute force. Brute force = try everything.

### Problem 5: "All triplets summing to zero"

- **Your Answer**: loop i, loop j, loop k, check sum → ✅ Perfect
- **Shape**: "Pairs (3 values)" → ✅ Correct (pairs generalized)

---

## 3 Rules Learned

1. **Subarray/substring → Pairs** | **Subsequence/subset → Subsets**
2. **Order matters? → Orderings** | **Order doesn't matter? → Subsets**
3. **Check if brute force is already O(n)** before optimizing
