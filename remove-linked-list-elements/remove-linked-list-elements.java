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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            if(curr.val == val){
                if(prev == null){
                    head = curr.next;
                    curr = curr.next;
                }
                else{
                    ListNode temp = curr.next;
                    prev.next = curr.next;
                    curr = temp;
                }
            }
            else{
            prev = curr;
            curr = curr.next;
            }
        }
        return head;
    }
}