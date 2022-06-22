/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // two pointers 
        // if it is a cycle, the fast node and slow node will eventually converge
        // handle short list 
        if(head == null || head.next == null || head.next.next == null) return false;
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while(fast != slow) {
            if(slow.next == null || fast.next == null || fast.next.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        // pointers meet, condition true 
        return true;
    }
}