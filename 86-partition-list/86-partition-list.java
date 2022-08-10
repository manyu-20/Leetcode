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
    public ListNode partition(ListNode A, int B) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode node = A;
        while(node != null){
            if(node.val < B){
                arr.add(node.val);
            }
            node = node.next;
        }
        
        node = A;
        while(node != null){
            if(node.val >= B){
                arr.add(node.val);
            }
            node = node.next;
        }
        
        node = A;
        int i = 0;
        while(node != null){
            node.val = arr.get(i);
            node = node.next;
            i++;
        }
        
        return A;
    }
}