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
    static int count;
    public int getDecimalValue(ListNode head) {
        count = 0;
        if(head.next == null){
            return head.val;
        }
        return fun(head);
    }
    
    private int fun(ListNode head){
        if(head.next == null){
            return head.val * (int)Math.pow(2,count++);
        }
        int tot = fun(head.next);
        int sum = head.val * (int)Math.pow(2,count);
        count++;
        return tot + sum;
    }
}