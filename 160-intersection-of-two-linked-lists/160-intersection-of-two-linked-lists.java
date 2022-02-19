/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int len1 = len(headA);
        int len2 = len(headB);
        ListNode a = headA;
        ListNode b = headB;
        
        while(len1 > len2){
            a = a.next;
            len1--;
        }
        while(len2 > len1){
            b = b.next;
            len2--;
        }
        
        while( a != null && a != b){
            a = a.next;
            b = b.next;
        }
        
        return a;
    }
    
    int len(ListNode x){
        int count = 0;
        while(x!= null){
            x = x.next;
            count++;
        }
        return count;
    }
}