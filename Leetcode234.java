class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true; 
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next; 
        }

        ListNode secondHalfHead = reverseList(slow);
        ListNode firstHalfHead = head;
        ListNode copySecondHalf = secondHalfHead; 
        while (secondHalfHead != null) {
            if (firstHalfHead.val != secondHalfHead.val) {
                reverseList(copySecondHalf); 
                return false;
            }
            firstHalfHead = firstHalfHead.next;
            secondHalfHead = secondHalfHead.next;
        }
        reverseList(copySecondHalf);
        return true;
    }
    private ListNode reverseList(ListNode head) {
        ListNode prev = null, next = null;
        while (head != null) {
            next = head.next; 
            head.next = prev; 
            prev = head; 
            head = next;
        }
        return prev; 
    }
}