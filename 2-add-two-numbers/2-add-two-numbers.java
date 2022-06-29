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

    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // reverse both lists 
        // go through and manually add and carry, to avoid Integer Overflow.
        // store the answer in linkedList, reverse it and return. 

        int carry = 0;
        ListNode ans = new ListNode(0);
        ListNode currAns = ans;
        
        while(l1 != null || l2 != null) {
            // manually add and carry if l1.val + l2.val + (previous carry) > 10 to avoid integer overflow
            int tempSum = 0;
            if(l1 == null) {
                tempSum = l2.val + carry;
            }
            else if(l2 == null) {
                tempSum = l1.val + carry;
            }
            else {
                tempSum = l1.val + l2.val + carry;
            }
            // if tempSum is greater than 10, the value becomes tempSUm % 10 and we carry tempSUm / 10
            if(tempSum >= 10) {
                carry = tempSum / 10;
                currAns.next = new ListNode(tempSum % 10);
                
            }
            else {
                currAns.next = new ListNode(tempSum);
                carry = 0;
            }
            
            currAns = currAns.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            
        }
        
        // if we are at end of both lists and still have a carry remaining, add it to the answer 
        while(carry > 0) {
            currAns.next = new ListNode(carry % 10);
            carry = carry / 10;
        }
        
        return ans.next;
    }
}