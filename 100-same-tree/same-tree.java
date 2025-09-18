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
// class Solution {
//     public boolean isSameTree(TreeNode p, TreeNode q) {
        
//     }
// }


class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // both are null → same
        if (p == null && q == null) return true;
        // one null, one not → not same
        if (p == null || q == null) return false;
        // values don’t match → not same
        if (p.val != q.val) return false;
        
        // check left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}