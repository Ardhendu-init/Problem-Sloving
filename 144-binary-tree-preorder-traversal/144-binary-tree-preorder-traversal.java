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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode>st = new Stack<>();
        TreeNode temp = root;
        while(true){
            if(temp != null){
                st.push(temp);
                res.add(temp.val);
                temp = temp.left;
            }else if(st.size()==0){
                break;
            }else{
                temp = st.pop();
                temp = temp.right;
            }
        }
        return res;
    }
}