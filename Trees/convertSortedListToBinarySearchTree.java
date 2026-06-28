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
        if(head==null) return null;
        return createChild(head,null);
    }
    private TreeNode createChild(ListNode start,ListNode end){
        if(start==end){
            return null;
        }
        ListNode turtle=start;
        ListNode hare=start;
        while(hare!=end && hare.next!=end){
            hare=hare.next.next;
            turtle=turtle.next;
        }
        TreeNode root=new TreeNode(turtle.val);
        root.left=createChild(start,turtle);
        root.right=createChild(turtle.next,end);
        return root;
    }
}
