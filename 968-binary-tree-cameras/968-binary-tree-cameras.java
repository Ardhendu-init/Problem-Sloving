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
     int cameras = 0;

    public int minCameraCover(TreeNode root) {
        if (MinCamerasInBT_helper(root) == -1) {
            cameras++;
        }
        return cameras;
    }

    public  int MinCamerasInBT_helper(TreeNode root) {
        if (root == null) {
            return 1;
        }
        int lchild = MinCamerasInBT_helper(root.left);
        int rchild = MinCamerasInBT_helper(root.right);

        if (lchild == -1 || rchild == -1) {
            cameras++;
            return 0;
        }
        if (lchild == 0 || rchild == 0) {
            return 1;
        }

        return -1;
    }
}
