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
    public ListNode swapPairs(ListNode head) {
        return fun(head);
        
    }
    
    ListNode fun(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode save = head.next.next;
        head.next.next = null;
        ListNode sec = head.next;
        head.next = null;
        
        sec.next = head;
        
        head.next = fun(save);
        
        return sec;
         
    }
}