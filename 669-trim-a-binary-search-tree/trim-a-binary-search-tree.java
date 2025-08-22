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
//     public TreeNode trimBST(TreeNode root, int low, int high) {
        
//     }
// }



class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;

        // If current node < low, drop left subtree and go right
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }

        // If current node > high, drop right subtree and go left
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        // Otherwise, fix both sides
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
