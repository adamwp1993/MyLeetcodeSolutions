/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // two pointers 
        // find shorter linkedList 
        int countA = length(headA);
        int countB = length(headB);
        // move to same start
        while(countA > countB) {
            headA = headA.next;
            countA--;
        }
        while(countB > countA) {
            headB = headB.next;
            countB--;
        }
        
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
        

        
        
    }
    
    private int length(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }
     
}