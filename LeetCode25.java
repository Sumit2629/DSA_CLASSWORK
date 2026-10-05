class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode temp = head;
        int count = 0;
        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }
        if (count < k) return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode agla = null;
        count = 0;
        while (count < k) {
            agla = curr.next;
            curr.next = prev;
            prev = curr;
            curr = agla;
            count++;
        }
        head.next = reverseKGroup(curr, k);
        return prev;
    }
}
