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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return toBST(head,null);
    }
    
    public TreeNode toBST(ListNode head, ListNode tail) {
        if(head == tail) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != tail && fast.next.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode n = new TreeNode(slow.val);
        n.left = toBST(head, slow);
        n.right = toBST(slow.next, tail);
        return n;
    }
}