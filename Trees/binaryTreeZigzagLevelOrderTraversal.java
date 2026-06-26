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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> visited=new ArrayList<>();
        if(root==null) return visited;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        boolean f=true;
        while(!q.isEmpty()){
            int currLevel=q.size();
            List<Integer> currentNodes=new ArrayList<>();
            for(int i=0;i<currLevel;i++){
                TreeNode curr=q.poll();
                currentNodes.add(curr.val);
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
            if(f){
                visited.add(currentNodes);
                f=false;
            }
            else{
                Collections.reverse(currentNodes);
                visited.add(currentNodes);
                f=true;
            }
        }

        return visited;
    }
}
