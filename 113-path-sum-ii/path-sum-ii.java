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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        dfs(result,ll,targetSum,root);
        return result;
    }
    private void dfs(List<List<Integer>> result, List<Integer> ll, int targetSum, TreeNode root){
        if(root==null){
            return;
        }
        ll.add(root.val);
        targetSum-= root.val;
        if(root.left==null && root.right==null && targetSum==0){
            result.add(new ArrayList<>(ll));

        }
        else{
            dfs(result,ll,targetSum,root.left);
            dfs(result,ll,targetSum,root.right);

        }
        ll.remove(ll.size()-1);
    }
}