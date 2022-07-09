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
    public ListNode rotateRight(ListNode head, int k) { 
        // O(N * k) 
        
        // handle best case/ base case 
        if(head == null) return null;
        if(head.next == null) return head;
        
        // find the end node and turn the linkedList into a circular linked list 
        ListNode tail = head;
        int size;
        for(size = 1; tail.next != null; size++) {
            tail = tail.next;
        }
        tail.next = head;
        
        ListNode newTail = head;
        
        // rotate the circular list to find new tail and new head 
        for(int i = 0; i < size - (k % size) - 1; i++) {
            newTail = newTail.next;
        }
        // break the circular linked list so its just a regular linkedList and return it
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
        
    }
}