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
    long total = 0;
    long maxProduct = 0;
    int MOD = 1000000007;
    public int maxProduct(TreeNode root) {
        total = totalSum(root);
        findMax(root);
        return (int)(maxProduct % MOD);
    }
    public int totalSum(TreeNode root){
        if(root==null){
            return 0;
        }
        return root.val + totalSum(root.left)+ totalSum(root.right);
    }
    private long findMax(TreeNode node) {
        if (node == null) return 0;

        long left = findMax(node.left);
        long right = findMax(node.right);

        long subSum = node.val + left + right;

        maxProduct = Math.max(maxProduct, subSum * (total - subSum));

        return subSum;
    }
}