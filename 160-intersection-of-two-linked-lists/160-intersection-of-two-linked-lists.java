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
        // O(N + M) runtime O(N) space - brute force 
        // how can we avoid using O(N) space? could a fast and slow pointer work here?
        // loop through with fast and slow pointers, until we get a match. 
        // if
        HashSet<ListNode> seen = new HashSet<ListNode>();
        // store all nodes from one list into hashset 
        ListNode current = headA;
        while(current != null) {
            seen.add(current);
            current = current.next;
        }
        // return first node that exists in both 
        current = headB;
        while(current != null) {
            if(seen.contains(current)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}