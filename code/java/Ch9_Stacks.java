import java.util.*;

/**
 * CHAPTER 9 — Stacks & Monotonic Structures Practice Problems
 */
public class Ch9_Stacks {

    // =====================================================
    // Level 1: Basic Stack
    // =====================================================

    // Problem 1: Valid Parentheses (LeetCode 20)
    // Input: "()[]{}" -> true, "(]" -> false, "([)]" -> false
    public static boolean isValid(String s) {
        Stack<Character> openCharacters = new Stack<>();
        Map<Character, Character> match = new HashMap<>();
        match.put(')', '(');
        match.put(']', '[');
        match.put('}', '{');
        for (char ch : s.toCharArray()) {
            if (match.containsKey(ch)) {
                if (openCharacters.isEmpty())
                    return false;
                if (!openCharacters.pop().equals(match.get(ch)))
                    return false;
            } else {
                openCharacters.push(ch);
            }
        }
        return openCharacters.isEmpty();
    }

    // Problem 2: Min Stack (LeetCode 155)
    // Design stack with push, pop, top, getMin — ALL O(1)
    // Hint: Use a second stack to track the minimum at each level
    static class MinStack {
        // TODO: Define your data structures
        Deque<Integer> stack;
        Deque<Integer> minStack;

        public MinStack() {
            stack = new ArrayDeque<>();
            minStack = new ArrayDeque<>();
        }

        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
        }

        public void pop() {
            if (stack.pop().equals(minStack.peek())) {
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    // =====================================================
    // Level 2: Monotonic Stack ⭐
    // =====================================================

    // Problem 3: Daily Temperatures (LeetCode 739)
    // Input: [73,74,75,71,69,72,76,73]
    // Output: [1,1,4,2,1,1,0,0]
    // For each day, how many days until a WARMER temperature?
    // This is "next greater element" with DISTANCE instead of value.
    public static int[] dailyTemperatures(int[] temperatures) {
        // TODO: Monotonic decreasing stack (stores indices)
        // When you pop, distance = current_index - popped_index
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int idx = 0; idx < temperatures.length; idx++) {

            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[idx]) {
                result[stack.peek()] = idx - stack.pop();
            }
            stack.push(idx);
        }
        return result;
    }

    // Problem 4: Next Greater Element I (LeetCode 496)
    // nums1 = [4,1,2], nums2 = [1,3,4,2]
    // For each element in nums1, find next greater in nums2
    // Output: [-1,3,-1]
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // TODO: Build nextGreater map from nums2 using monotonic stack
        // Then look up each nums1 element in the map
        int n = nums1.length;
        Map<Integer, Integer> check = new HashMap<>();
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>(); // stores indices

        for (int i = 0; i < n; i++) {
            // Pop everything SMALLER than current (they found their next greater)
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                check.put(nums2[stack.pop()], nums2[i]);
            }
            stack.push(i);
        }
        for (int idx = 0; idx < nums1.length; idx++) {
            result[idx] = check.getOrDefault(nums1[idx], -1);
        }
        return result;
    }

    // =====================================================
    // Level 3: Advanced Monotonic ⭐⭐
    // =====================================================

    // Problem 5: Largest Rectangle in Histogram (LeetCode 84)
    // Input: [2,1,5,6,2,3]
    // Output: 10
    // For each bar: how far left and right can it extend?
    // That's "previous smaller" + "next smaller" → monotonic stack!
    public static int largestRectangleArea(int[] heights) {
        // TODO: For each bar, find left boundary (prev smaller) and
        // right boundary (next smaller), then area = height * width
        return -1;
    }

    // =====================================================
    // Level 4: Discrimination
    // =====================================================
    /*
     * A: "Check if string of brackets is balanced"
     * Stack? Yes Pattern: check for every close if open exist
     *
     * B: "Find maximum element in sliding window of size K"
     * Stack? No Pattern: normal condition
     *
     * C: "For each element, find nearest smaller to the left"
     * Stack? Yes Pattern: monotonic
     *
     * D: "Evaluate postfix expression: 2 3 + 5 *"
     * Stack? Yes Pattern: pop values on experssion
     *
     * E: "Find shortest path in grid"
     * Stack? No Pattern: Graph
     */

    // -------------------------------------------------------
    // Test cases
    // -------------------------------------------------------
    public static void main(String[] args) {
        System.out.println("--- Level 1 ---");
        System.out.println("P1a: " + isValid("()[]{}") + " (expected true)");
        System.out.println("P1b: " + isValid("(]") + " (expected false)");
        System.out.println("P1c: " + isValid("([)]") + " (expected false)");
        System.out.println("P1d: " + isValid("{[]}") + " (expected true)");

        System.out.println("\nP2: MinStack test");
        MinStack ms = new MinStack();
        ms.push(-2);
        ms.push(0);
        ms.push(-3);
        System.out.println("  getMin: " + ms.getMin() + " (expected -3)");
        ms.pop();
        System.out.println("  top: " + ms.top() + " (expected 0)");
        System.out.println("  getMin: " + ms.getMin() + " (expected -2)");

        System.out.println("\n--- Level 2 ---");
        System.out.println("P3: " + Arrays.toString(
                dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 }))
                + " (expected [1,1,4,2,1,1,0,0])");

        System.out.println("P4: " + Arrays.toString(
                nextGreaterElement(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 }))
                + " (expected [-1,3,-1])");

        System.out.println("\n--- Level 3 ---");
        System.out.println("P5: " + largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 })
                + " (expected 10)");
        System.out.println("P5b: " + largestRectangleArea(new int[] { 2, 4 })
                + " (expected 4)");
    }
}
