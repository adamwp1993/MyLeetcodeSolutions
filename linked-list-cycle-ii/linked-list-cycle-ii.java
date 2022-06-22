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
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> seen = new HashSet<ListNode>();
        if(head == null || head.next == null) return null;
        ListNode currentNode = head.next;
        seen.add(head);
        
        while(!seen.contains(currentNode)) {
            if(currentNode.next == null) return null;
            seen.add(currentNode);
            currentNode = currentNode.next;
        }
        return currentNode;
    }
}