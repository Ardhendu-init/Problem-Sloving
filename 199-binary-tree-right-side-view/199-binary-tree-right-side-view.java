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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>ans = new ArrayList<>();
        if(root == null){
            return ans ;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(q.size()>0){
            ans.add(q.peek().val);
            int size = q.size();
            while(size --> 0){
                TreeNode rem = q.remove();
                if(rem.right != null){
                    q.add(rem.right);
                }
                if(rem.left != null){
                    q.add(rem.left);
                }
            }
        }
        return ans ;
    }
}