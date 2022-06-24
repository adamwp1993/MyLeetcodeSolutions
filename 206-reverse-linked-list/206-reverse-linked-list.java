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
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        
        
        while(current != null) {
            // get the node in front of current node. 
            ListNode temp = current.next;
            // point the pointer of current node, at the node before it. 
            current.next = prev;
            // now the current node becomes previous 
            prev = current;
            // and we move to the right (we saved the node in front because we broke our pointer when we re-directed)
            current = temp;
        }
        return prev;
    }
}