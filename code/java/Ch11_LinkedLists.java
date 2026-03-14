
/**
 * CHAPTER 11 — Linked Lists Practice Problems
 */
public class Ch11_LinkedLists {

    // ListNode definition
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Helper: build list from array
    static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int v : arr) {
            curr.next = new ListNode(v);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Helper: list to string
    static String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            if (head.next != null)
                sb.append("→");
            head = head.next;
        }
        return sb.toString();
    }

    // =====================================================
    // Level 1: Foundation
    // =====================================================

    // Problem 1: Reverse Linked List (LeetCode 206)
    // 1→2→3→4→5 → 5→4→3→2→1
    // THE most important LL skill. prev/curr/next triple.
    public static ListNode reverseList(ListNode head) {
        // TODO: prev=null, curr=head
        // Save next, reverse pointer, advance both
        return null;
    }

    // Problem 2: Merge Two Sorted Lists (LeetCode 21)
    // l1: 1→2→4, l2: 1→3→4 → 1→1→2→3→4→4
    // Use dummy head, compare and attach smaller
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // TODO: Dummy head, compare l1.val vs l2.val
        // Attach smaller, advance that pointer
        // At end, attach remaining list
        return null;
    }

    // =====================================================
    // Level 2: Two-Pointer Tricks
    // =====================================================

    // Problem 3: Linked List Cycle (LeetCode 141)
    // Fast-slow: if they meet → cycle
    public static boolean hasCycle(ListNode head) {
        // TODO: slow moves 1, fast moves 2
        // If fast catches slow → cycle
        return false;
    }

    // Problem 4: Middle of Linked List (LeetCode 876)
    // 1→2→3→4→5 → 3 (middle)
    // 1→2→3→4→5→6 → 4 (second middle)
    public static ListNode middleNode(ListNode head) {
        // TODO: When fast reaches end, slow is at middle
        return null;
    }

    // Problem 5: Remove Nth Node From End (LeetCode 19)
    // 1→2→3→4→5, n=2 → 1→2→3→5
    // Use two pointers with gap of n
    // HINT: Use dummy head (what if n = list length?)
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // TODO: Move 'fast' n steps ahead
        // Then move both until fast reaches end
        // 'slow' is now just before the node to remove
        return null;
    }

    // =====================================================
    // Level 3: Combined Patterns ⭐⭐
    // =====================================================

    // Problem 6: Palindrome Linked List (LeetCode 234)
    // 1→2→2→1 → true
    // 1→2→3 → false
    // Combines: find middle + reverse second half + compare
    // Must solve in O(1) space (no arrays!)
    public static boolean isPalindrome(ListNode head) {
        // TODO: Step 1: Find middle (fast-slow)
        // Step 2: Reverse second half
        // Step 3: Compare first half with reversed second half
        return false;
    }

    // =====================================================
    // Level 4: Discrimination
    // =====================================================
    /*
     * A: "Reverse nodes in pairs"
     * LinkedList? ___ Pattern: ___
     *
     * B: "Find intersection of two linked lists"
     * LinkedList? ___ Pattern: ___
     *
     * C: "Sort a linked list in O(n log n)"
     * LinkedList? ___ Pattern: ___
     *
     * D: "Remove duplicates from sorted list"
     * LinkedList? ___ Pattern: ___
     *
     * E: "Flatten a nested list"
     * LinkedList? ___ Pattern: ___
     */

    // -------------------------------------------------------
    // Test cases
    // -------------------------------------------------------
    public static void main(String[] args) {
        System.out.println("--- Level 1 ---");

        ListNode rev = reverseList(buildList(new int[] { 1, 2, 3, 4, 5 }));
        System.out.println("P1: " + listToString(rev)
                + " (expected 5→4→3→2→1)");

        ListNode merged = mergeTwoLists(
                buildList(new int[] { 1, 2, 4 }),
                buildList(new int[] { 1, 3, 4 }));
        System.out.println("P2: " + listToString(merged)
                + " (expected 1→1→2→3→4→4)");

        System.out.println("\n--- Level 2 ---");

        // Cycle test: 1→2→3→4 (4 points back to 2)
        ListNode cycleHead = buildList(new int[] { 1, 2, 3, 4 });
        ListNode node2 = cycleHead.next;
        ListNode node4 = node2.next.next;
        node4.next = node2; // create cycle
        System.out.println("P3: " + hasCycle(cycleHead)
                + " (expected true)");
        System.out.println("P3b: " + hasCycle(buildList(new int[] { 1, 2, 3 }))
                + " (expected false)");

        ListNode mid = middleNode(buildList(new int[] { 1, 2, 3, 4, 5 }));
        System.out.println("P4: " + (mid != null ? mid.val : "null")
                + " (expected 3)");
        ListNode mid2 = middleNode(buildList(new int[] { 1, 2, 3, 4, 5, 6 }));
        System.out.println("P4b: " + (mid2 != null ? mid2.val : "null")
                + " (expected 4)");

        ListNode rem = removeNthFromEnd(buildList(new int[] { 1, 2, 3, 4, 5 }), 2);
        System.out.println("P5: " + listToString(rem)
                + " (expected 1→2→3→5)");
        ListNode rem2 = removeNthFromEnd(buildList(new int[] { 1 }), 1);
        System.out.println("P5b: " + listToString(rem2)
                + " (expected )");

        System.out.println("\n--- Level 3 ---");
        System.out.println("P6: " + isPalindrome(buildList(new int[] { 1, 2, 2, 1 }))
                + " (expected true)");
        System.out.println("P6b: " + isPalindrome(buildList(new int[] { 1, 2, 3 }))
                + " (expected false)");
    }
}
