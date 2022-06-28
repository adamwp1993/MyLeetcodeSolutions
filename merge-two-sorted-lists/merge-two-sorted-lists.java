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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // two pointers 
        ListNode sentinel = new ListNode(0);
        sentinel.next = list1;
        ListNode curr1 = list1;
        ListNode prev = sentinel;
        ListNode curr2 = list2;
        
        while(curr2 != null) {
            // we find a val in list two and traverse list 1 until we find a place to insert it. 
            // if we have reached end of list 1 we can just append the nodes. 
            if(curr1 == null) {
                // if we have hit end of list1 we can just append remaining nodes and return since theyre already sorted
                prev.next = curr2;
                return sentinel.next;
            }
            else if(curr2.val <= curr1.val) {
                // insert current node in list 2 behind current node in list 1
                ListNode tempNext = curr2.next;
                curr2.next = curr1;
                prev.next = curr2;
                prev = curr2;
                curr2 = tempNext;
            }
            else {
                // if curr2 val is greater, we increment the pointer in list one, until we find a spot to insert that node. 
                curr1 = curr1.next;
                prev = prev.next;
            }
        }
        return sentinel.next;
    }
}