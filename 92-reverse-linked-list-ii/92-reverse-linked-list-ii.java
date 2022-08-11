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
    public ListNode reverseBetween(ListNode A, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = A;
        ListNode curr1 = dummy;
        ListNode prev = null;
        
        for(int i = 0;i<m;i++){
            prev = curr1;
            curr1 = curr1.next;
        }
        
        ListNode curr2 = curr1;
        ListNode prev2 = prev;
        
        for(int i = m;i<=n;i++){
            ListNode next = curr2.next;
            curr2.next = prev2;
            prev2  = curr2;
            curr2 = next;
        }
        
        prev.next = prev2;
        curr1.next = curr2;
        
        return dummy.next;
    }
}