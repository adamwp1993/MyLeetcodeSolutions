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
    public ListNode deleteMiddle(ListNode head) {
        
        // create sentinel node to protect from nullPointers 
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        // fast and slow pointers 
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = sentinel;
        // fast moves two nodes, slow 1. 
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            prev = prev.next;
        }
        // when loop terminates we have found node to be deleted 
        prev.next = slow.next;
        return sentinel.next;
        
    }
}