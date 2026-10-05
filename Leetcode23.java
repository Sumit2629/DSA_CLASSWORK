/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int totalSize = 0;
        for (int i = 0; i < lists.length; i++) {
            ListNode curr = lists[i];
            while (curr != null) {
                totalSize++;
                curr = curr.next;
            }
        }
        int[] merged = new int[totalSize];
        int index = 0;
        for (int i = 0; i < lists.length; i++) {
            ListNode curr = lists[i];
            while (curr != null) {
                merged[index++] = curr.val;
                curr = curr.next;
            }
        }
        Arrays.sort(merged);
        ListNode temp=new ListNode(0);
        ListNode t=temp;
        for(int i=0;i<merged.length;i++){
            t.next=new ListNode(merged[i]);
            t=t.next;
        }
        return temp.next;
    }
}