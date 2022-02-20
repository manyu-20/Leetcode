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
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode even = null;
        ListNode curr = head;
        ListNode safe = null;
        while( curr != null && curr.next != null){
            
            ListNode next = curr.next;
            curr.next = curr.next.next;
            
            if(even == null){
                even = next;
                safe = even;
            }
            else{
                System.out.println(next.val);
                even.next = next;
                even = even.next;
            }
            
            curr = curr.next;
                  
        }
            
        if(even != null){
            even.next = null;
        }
        
        
        ListNode temp = head;
        
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = safe;
        
        ListNode move = safe;
        
        // while(move != null){
        //     System.out.println(move.val);
        //     move = move.next;
        // }
        
        return head;
    
    }
}