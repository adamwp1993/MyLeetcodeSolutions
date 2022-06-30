/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node current = head;
        Node sentinel = new Node(0);
        sentinel.next = head;
        // find a node that has a child.
        // when we find a child, we find its first and last pointers, then insert that entire list into the top level at once. 
        while(current != null) {
            if(current.child != null) {
                Node first = current.child;
                Node last = current.child;
                Node after = current.next;
                // find last node of the sublevel
                while(last.next != null) {
                    last = last.next;
                }
                // update pointers so we insert the sublevel behind the current node and before the node after current.
                first.prev = current;
                current.next = first;
                last.next = after;
                if(after != null) {
                    after.prev = last;
                }
                current.child = null;
                
            }
            current = current.next;
        }
        return sentinel.next;
    }
}