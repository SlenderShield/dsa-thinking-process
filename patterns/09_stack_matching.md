# Pattern 09 — Stack (Matching / Validation)

## Smell Triggers

- "Valid parentheses" / "balanced brackets"
- "Matching pairs" (tags, brackets)
- "Evaluate expression" / "calculator"
- "Decode nested string"
- "Undo" operations
- Anything **LIFO** (Last In, First Out)

## Template — Matching Brackets

```java
public boolean isValid(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    for (char c : s.toCharArray()) {
        if (c == '(' || c == '{' || c == '[') {
            stack.push(c);
        } else {
            if (stack.isEmpty()) return false;
            char top = stack.pop();
            if ((c == ')' && top != '(') ||
                (c == '}' && top != '{') ||
                (c == ']' && top != '['))
                return false;
        }
    }
    return stack.isEmpty();
}
```

## Template — Min Stack (O(1) getMin)

```java
Deque<Integer> stack = new ArrayDeque<>();
Deque<Integer> minStack = new ArrayDeque<>();

void push(int val) {
    stack.push(val);
    minStack.push(minStack.isEmpty() ? val : Math.min(val, minStack.peek()));
}
void pop() { stack.pop(); minStack.pop(); }
int top() { return stack.peek(); }
int getMin() { return minStack.peek(); }
```

## Core Insight

A stack answers: **"What's the most recent thing I haven't resolved yet?"** Push = "deal with later." Pop = "now I can resolve."

## Complexity

- Time: **O(1)** per push/pop
- Space: **O(n)**

## Stack vs Queue

| Need                     | Structure |
| ------------------------ | --------- |
| Most recent first (LIFO) | Stack     |
| Oldest first (FIFO)      | Queue     |
| Both ends                | Deque     |

## LeetCode Problems

- 20: Valid Parentheses
- 155: Min Stack
- 394: Decode String
- 150: Evaluate Reverse Polish Notation
- 71: Simplify Path
