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
    public void reorderList(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode save = slow.next;
        
        slow.next = null;
        
        ListNode temp = save;
        
        while(temp != null){
            st.push(temp);
            temp = temp.next;
        }
        
        temp = head;
        
        while( !st.isEmpty() && temp != null && temp.next != null){
            ListNode next = temp.next;
            st.peek().next = null;
            temp.next = st.pop();
            temp.next.next = next;
            temp = temp.next.next;
        }
        
        
        
        
    }
}