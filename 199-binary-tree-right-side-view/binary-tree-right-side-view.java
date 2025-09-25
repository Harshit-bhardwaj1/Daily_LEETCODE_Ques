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
        List<Integer> ll = new ArrayList<>();
        RightView(root,ll,1);
        return ll;
    }
    int maxd=0;
    public void RightView(TreeNode root, List<Integer> ll,int cl){
        if(root==null){
            return;
        }
        if(maxd<cl){
            ll.add(root.val);
            maxd=cl;
        }
        RightView(root.right,ll, cl+1);
        RightView(root.left,ll,cl+1);
    }
}