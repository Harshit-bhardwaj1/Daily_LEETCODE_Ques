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
//     public boolean isSymmetric(TreeNode root) {
        
//     }
// }


// class Solution {
//     public boolean isSymmetric(TreeNode root) {
//         if (root == null) return true;

//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root.left);
//         queue.add(root.right);

//         while (!queue.isEmpty()) {
//             TreeNode left = queue.poll();
//             TreeNode right = queue.poll();

//             if (left == null && right == null) continue;
//             if (left == null || right == null) return false;
//             if (left.val != right.val) return false;

//             // Add opposite children to check mirror property
//             queue.add(left.left);
//             queue.add(right.right);

//             queue.add(left.right);
//             queue.add(right.left);
//         }

//         return true;
//     }
// }


class Solution {
    public boolean isSymmetric(TreeNode root){
        return check(root.left,root.right);
    }

    public boolean check(TreeNode n1, TreeNode n2){
        if(n1==null && n2==null){
            return true;
        }
        if(n1==null || n2==null){
            return false;
        }
        if(n1.val!=n2.val){
            return false;
        }
        boolean left = check(n1.left,n2.right);
        boolean right = check(n1.right, n2.left);
        return left && right;
    }
}
