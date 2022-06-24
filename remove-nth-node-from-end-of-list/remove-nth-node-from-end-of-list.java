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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        int count = 0;
        
        while(fast != null) {
            fast = fast.next;
            count++;
            if(count > n) {
                prev = slow;
                slow = slow.next;
            }
        }
        // if prev == null, we are deleting element from head, so just return head.next 
        if(prev == null) return head.next;
        prev.next = slow.next;
        return head;
    }
}