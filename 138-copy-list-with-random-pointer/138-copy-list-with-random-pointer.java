/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if( head == null) { 
            return null;
        }
        
        // create sentinel node 
        Node sentinel = new Node(0);
        sentinel.next = head;
        
        // interweave the list - 1st pass
        Node current = head;
        while(current != null) {
            Node newNode = new Node(current.val);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
            
        }
        // update random pointers - 2nd pass through 
        current = head;
        while(current != null) {
            if(current.random != null) {
                current.next.random = current.random.next;
            }
            else {
                current.next.random = null;
            }
            current = current.next.next;
        }
        // remove the old nodes - unweave the list 
        Node oldListCurrent = head;
        Node newListCurrent = head.next;
        Node newHead = head.next;
        
        while(oldListCurrent != null) {
            oldListCurrent.next = oldListCurrent.next.next;
            if(newListCurrent.next != null) {
                newListCurrent.next = newListCurrent.next.next;
            }
            else {
                newListCurrent.next = null;
            }
            oldListCurrent = oldListCurrent.next;
            newListCurrent = newListCurrent.next;
        }
        return newHead;
    }
}