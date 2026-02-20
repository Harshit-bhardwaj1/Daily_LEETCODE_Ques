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
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        inorder(root);

        List<List<Integer>> ans = new ArrayList<>();

        for (int q : queries) {
            int floor = getFloor(q);
            int ceil = getCeil(q);

            ans.add(Arrays.asList(floor, ceil));
        }

        return ans;
    }
    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    private int getFloor(int target) {
        int l = 0, r = list.size() - 1;
        int res = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (list.get(mid) <= target) {
                res = list.get(mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return res;
    }

    private int getCeil(int target) {
        int l = 0, r = list.size() - 1;
        int res = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (list.get(mid) >= target) {
                res = list.get(mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return res;
    }
}