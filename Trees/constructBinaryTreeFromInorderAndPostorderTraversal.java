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
     private HashMap<Integer,Integer> map;
    private int postIndex=3000;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex=postorder.length-1;
        map=new HashMap<>();
        if(postorder[postIndex]==-1){
            return new TreeNode(-1);
        }
        int i;
        for(i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(postorder,0,inorder.length-1);
    }
    private TreeNode helper(int[] postorder,int start,int end){
        if(start>end){
            return null;
        }
        int currRoot=postorder[postIndex--];
        TreeNode root=new TreeNode(currRoot);
        int rootInorderIndex=map.get(root.val);
        root.right=helper(postorder,rootInorderIndex+1,end);
        root.left=helper(postorder,start,rootInorderIndex-1);

        return root;
    }
}
