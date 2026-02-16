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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        int count=0;
        double sum=0;
        q.add(root);
        int size =1;
        while(!q.isEmpty()){
            if(size==0){
                size=q.size();
                res.add(sum/count);
                sum=0;
                count=0;
            }
            TreeNode a = q.poll();
            count++;
            sum+=a.val;
            if(a.left!=null){
                q.add(a.left);
            }
            if(a.right!=null){
                q.add(a.right);
            }
            size--;
        }
        res.add(sum/count);
        return res;
    }
}