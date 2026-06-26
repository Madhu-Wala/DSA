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
    private int preIndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map=new HashMap<>();
        if(preorder[0]==-1){
            return new TreeNode(-1);
        }
        int i;
        for(i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder,0,inorder.length-1);

    }
    private TreeNode helper(int[] preorder,int start,int end){
        if(start>end){
            return null;
        }
        int currRoot=preorder[preIndex++];
        TreeNode root=new TreeNode(currRoot);
        int rootInorderIndex=map.get(root.val);

        root.left=helper(preorder,start,rootInorderIndex-1);
        root.right=helper(preorder,rootInorderIndex+1,end);

        return root;
    }
}
