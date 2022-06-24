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
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        List<Integer> vals = new ArrayList<Integer>();
        
        while(cur != null) {
            vals.add(cur.val);
            cur = cur.next;
        }
        int left = 0;
        int right = vals.size() - 1;
        while(left < right) {
            if(vals.get(left) != vals.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}