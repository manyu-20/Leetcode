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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-100000);
        
        for(int i = 0;i<lists.length;i++){
            head = merge(head,lists[i]);
        }
        
        return head.next;
    }
    
    ListNode merge(ListNode head,ListNode list){
        ListNode temp = new ListNode(-100000);
        ListNode save = temp;
        while(head != null && list != null){
            if(head.val <= list.val){
                temp.next = head;
                head = head.next;
            }
            else{
                temp.next = list;
                list = list.next;
            }
            temp = temp.next;
        }
        
        if(head != null){
            temp.next = head;
        }
        if(list != null){
            temp.next = list;
        }
        
        return save.next;
    }
}