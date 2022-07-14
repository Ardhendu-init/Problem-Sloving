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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i < inorder.length ; i++){
            map.put(inorder[i], i);
        }
        return build(preorder , 0 , preorder.length-1 , inorder , 0 , inorder.length-1 , map);
    }
    static TreeNode build (int [] preorder , int pst , int pend , int [] inorder , int inst , int inend , HashMap<Integer, Integer>map ){
       if(inst > inend || pst> pend){
           return null;
       }
        TreeNode root = new TreeNode(preorder[pst]);
        int pos = map.get(root.val);
        int range = pos-inst;
        
        root.left = build(preorder , pst+1 , pst+range , inorder , inst , pos-1, map);
        root.right = build(preorder , pst+range+1 , pend , inorder , pos+1  , inend, map);
        return root;
    }
}