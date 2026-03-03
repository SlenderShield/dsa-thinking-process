import java.util.*;

/**
 * CHAPTER 8 — HashMap Practice Problems
 */
public class Ch8_Hashmaps {

    // =====================================================
    // Level 1: Complement / Existence
    // =====================================================

    // Problem 1: Two Sum (LeetCode 1)
    // Input: [2, 7, 11, 15], target = 9 -> Output: [0, 1]
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> calcMap = new HashMap<>();
        int len = nums.length;
        for (int idx = 0; idx < len; idx++) {

            if (calcMap.containsKey(target - nums[idx])) {
                return new int[] { calcMap.get(target - nums[idx]), idx };
            }
            calcMap.put(nums[idx], idx);
        }
        return new int[] { -1, -1 };
    }

    // Problem 2: Contains Duplicate (LeetCode 217)
    // Input: [1, 2, 3, 1] -> Output: true
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        for (int idx = 0; idx < len; idx++) {
            if (set.contains(nums[idx])) {
                return true;
            }
            set.add(nums[idx]);
        }
        return false;
    }

    // =====================================================
    // Level 2: Frequency
    // =====================================================

    // Problem 3: First Unique Character (LeetCode 387)
    // Input: "leetcode" -> Output: 0
    public static int firstUniqChar(String s) {
        int[] characters = new int[26];
        int len = s.length();
        for (int idx = 0; idx < len; idx++) {
            characters[s.charAt(idx) - 'a']++;
        }
        for (int idx = 0; idx < len; idx++) {
            if (characters[s.charAt(idx) - 'a'] == 1)
                return idx;
        }
        return -1;
    }

    // Problem 4: Top K Frequent Elements (LeetCode 347)
    // Input: [1,1,1,2,2,3], k = 2 -> Output: [1, 2]
    public static int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.getValue(), b.getValue()));
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> en : freq.entrySet()) {
            queue.offer(en);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] res = new int[k];
        int i = 0;
        while (!queue.isEmpty()) {
            res[i++] = queue.poll().getKey();
        }
        return res;
    }

    // =====================================================
    // Level 3: Grouping
    // =====================================================

    // Problem 5: Group Anagrams (LeetCode 49)
    // Input: ["eat","tea","tan","ate","nat","bat"]
    // Output: [["eat","tea","ate"], ["tan","nat"], ["bat"]]
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> check = new HashMap<>();
        for (String str : strs) {
            String key = compare(str);
            if (check.containsKey(key)) {
                check.get(key).add(str);
            } else {
                check.put(key, new ArrayList<>(Arrays.asList(str)));
            }
        }
        for (List<String> list : check.values()) {
            result.add(list);
        }
        return result;
    }

    public static String compare(String check) {
        int[] chars = new int[26];
        for (char ch : check.toCharArray()) {
            chars[ch - 'a']++;
        }
        return Arrays.toString(chars);
    }

    // =====================================================
    // Level 4: Advanced
    // =====================================================

    // Problem 6: Longest Consecutive Sequence (LeetCode 128) ⭐
    // Input: [100, 4, 200, 1, 3, 2] -> Output: 4
    // Hint: HashSet + only count from sequence START (no predecessor)
    public static int longestConsecutive(int[] nums) {
        Set<Integer> consec = new HashSet<>();
        for (int num : nums) {
            consec.add(num);
        }
        int maxCount = 0;
        for (int num : consec) {
            if (!consec.contains(num - 1)) {
                int count = 1;
                int currNum = num;
                while (consec.contains(currNum + 1)) {
                    count++;
                    currNum++;
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }

    // =====================================================
    // Level 5: Discrimination
    // =====================================================
    /*
     * A: "Find two numbers in sorted array summing to target"
     * HashMap? No Pattern: Two pointer is better as it is sorted
     *
     * B: "Group words by their first letter"
     * HashMap? Yes Pattern: we have key as first letter
     *
     * C: "Find longest substring without repeating characters"
     * HashMap? No Pattern: sliding window can be used here
     *
     * D: "Check if two strings are anagrams"
     * HashMap? No Pattern: Freq map can be used as it is better approach
     *
     * E: "Find missing number in range [1, n]"
     * HashMap? No Pattern: Array with indexing
     */

    // -------------------------------------------------------
    // Test cases
    // -------------------------------------------------------
    public static void main(String[] args) {
        System.out.println("--- Level 1 ---");
        System.out.println("P1: " + Arrays.toString(twoSum(new int[] { 2, 7, 11, 15 }, 9))
                + " (expected [0, 1])");
        System.out.println("P2: " + containsDuplicate(new int[] { 1, 2, 3, 1 })
                + " (expected true)");
        System.out.println("P2b: " + containsDuplicate(new int[] { 1, 2, 3, 4 })
                + " (expected false)");

        System.out.println("\n--- Level 2 ---");
        System.out.println("P3: " + firstUniqChar("leetcode")
                + " (expected 0)");
        System.out.println("P3b: " + firstUniqChar("aabb")
                + " (expected -1)");
        System.out.println("P4: " + Arrays.toString(topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2))
                + " (expected [1, 2])");

        System.out.println("\n--- Level 3 ---");
        System.out.println("P5: " + groupAnagrams(
                new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));

        System.out.println("\n--- Level 4 ---");
        System.out.println("P6: " + longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 })
                + " (expected 4)");
        System.out.println("P6b: " + longestConsecutive(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 })
                + " (expected 9)");
    }
}
