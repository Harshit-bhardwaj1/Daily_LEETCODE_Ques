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
//     int max_depth=0;
//     public List<Integer> rightSideView(TreeNode root) {
//         List<Integer> ll = new ArrayList<>();
//         rightView(root,1,ll);
//         return ll;
//     }
//     public void rightView(TreeNode root, int curr_level,List<Integer> ll){
//         if(root==null){
//             return;
//         }
//         if(max_depth<curr_level){
//             ll.add(root.val);
//             max_depth=curr_level;
//         }
//         rightView(root.right,curr_level+1,ll);
//         rightView(root.left,curr_level+1,ll);
//     }
// }


class Solution{
    int max_depth=0;
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> ll = new ArrayList<>();
        RightView(root,ll,1);
        return ll;
    }
    public void RightView(TreeNode root, List<Integer> ll, int curr_level){
        if(root==null){
            return;
        }
        if(max_depth< curr_level){
            ll.add(root.val);
            max_depth=curr_level;
        }
        RightView(root.right,ll,curr_level+1);
        RightView(root.left,ll,curr_level+1);
    }
}