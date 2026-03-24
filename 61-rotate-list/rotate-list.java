class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // Base case: empty list, single node, or no rotation needed
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 1. Calculate the length and find the current tail
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // 2. Connect the tail to the head to make it circular
        tail.next = head;

        // 3. Find the new tail: it is at (length - (k % length) - 1)
        // If length is 5 and k is 2, the new tail is at index 2 (the 3rd node)
        k = k % length;
        int stepsToNewTail = length - k;
        
        ListNode newTail = tail; 
        while (stepsToNewTail-- > 0) {
            newTail = newTail.next;
        }

        // 4. The new head is the node after the new tail
        ListNode newHead = newTail.next;

        // 5. Break the circle
        newTail.next = null;

        return newHead;
    }
}
