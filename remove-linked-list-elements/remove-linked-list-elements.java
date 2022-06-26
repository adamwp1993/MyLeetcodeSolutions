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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        // create a sentinel node 
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode current = head;
        ListNode prev = sentinel;
        
        while(current != null) {
            // if node.val == val, update pointer of previous node to pass the current node.
            if(current.val == val) {
                    prev.next = current.next;
            }
            else {
                prev = current;
            }
            current = current.next;
        }
        
        return sentinel.next;
    }
}