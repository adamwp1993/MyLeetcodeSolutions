/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node sentinel = new Node(0, head);
        // handle empty list
        if(head == null) {
            Node temp = new Node(insertVal);
            temp.next = temp;
            sentinel.next = temp;
            return sentinel.next;
        }
        // create two pointers 
        Node prev = head;
        Node current = head.next;
        // handle list w/ only 1 node 
        if(prev == current) {
            Node temp = new Node(insertVal, current);
            current.next = temp;
            return sentinel.next;
        }
        //
        do {
            // do while guarantees code to run at least once 
            // if we find a suitable spot (value before is less than and after is greater than), insert
            if(prev.val <= insertVal && current.val >= insertVal) {
                Node temp = new Node(insertVal, current);
                prev.next = temp;
                return sentinel.next;
            }
            // if we are at the smallest node and insertVal is smaller than smallest node value, then we insert before the  smallest value 
            else if(prev.val > current.val && (insertVal >= prev.val || insertVal <= current.val)) {
                Node temp = new Node(insertVal, current);
                prev.next = temp;
                return sentinel.next;
            }
            prev = prev.next;
            current = current.next;
            
        } while (prev != head);
        
        // if we make it all the way through, then all values were the same so we insert on the end 
        prev.next = new Node(insertVal, current);
        return sentinel.next;
        
        
    }
}