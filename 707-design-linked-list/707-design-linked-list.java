class MyLinkedList {
    
    class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }
    
    private Node head;
    private int size;
    
    public MyLinkedList() {
        // singly linked list 
        
        
    }
    
    public int get(int index) {
        // returns value of a node at certain index oor -1 if invalid index 
        if(index >= size) return -1;
        
        Node curNode = head;
        for(int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        return curNode.val;
        
    }
    
    public void addAtHead(int val) {
        // adds a node to the head of the linkedList 
        Node prev = head;
        head = new Node(val);
        head.next = prev;
        size++;
        
    }
    
    public void addAtTail(int val) {
        // add node to end of linked list 
        Node newNode = new Node(val);
        size++;
        
        
        if(head == null) {
            head = newNode;
        }
        else {
            Node curNode = head;
            while(curNode.next != null) {
                curNode = curNode.next;
            }
            curNode.next = newNode;
        }
        
    }
    
    public void addAtIndex(int index, int val) {
        // adds a node at specified index 
        // handle adding to beginning and end of linkedList
        Node newNode = new Node(val);
        
        if(index > size) return;
        if(index == 0) {
            addAtHead(val);
        }
        else {
            size++;
            Node curNode = head;
            for(int i = 0; i < index - 1; i++) {
                curNode = curNode.next;
            }
            newNode.next = curNode.next;
            curNode.next = newNode;
        }
        
        
    }
    
    public void deleteAtIndex(int index) {
        // delete node at index, if index is valid
        if (index >= size) return;
        if(index == 0) {
            head = head.next;
            size--;
            return;
        }
        size--;
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
    }
}


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */