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
        int count = 0;
        // create sentinel node to protect from nullPointers 
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        
        // get length of list 
        ListNode current = head;
        while(current != null) {
            count++;
            current = current.next;
        }
        int mid = count / 2;
        count = 0;
        // navigate to middle node 
        ListNode prev = sentinel;
        current = head;
        while(count != mid) {
            count++;
            prev = current;
            current = current.next;
        }
        // once node is found, update pointer and return 
        prev.next = current.next;
        return sentinel.next;
    }
}