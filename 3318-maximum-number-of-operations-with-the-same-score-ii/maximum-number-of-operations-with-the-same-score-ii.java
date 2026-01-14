import java.util.*;

class Solution {
    private Map<String, Integer> memo = new HashMap<>();

    private int dfs(int[] nums, int i, int j, int target) {
        if (i >= j) return 0; // Base case: No valid operations left
        
        String key = i + "," + j + "," + target;
        if (memo.containsKey(key)) return memo.get(key); // Return memoized result

        int res = 0;

        // Option 1: Remove first two elements
        if (i + 1 <= j && nums[i] + nums[i + 1] == target) {
            res = Math.max(res, 1 + dfs(nums, i + 2, j, target));
        }
        // Option 2: Remove last two elements
        if (i <= j - 1 && nums[j] + nums[j - 1] == target) {
            res = Math.max(res, 1 + dfs(nums, i, j - 2, target));
        }
        // Option 3: Remove first and last element
        if (nums[i] + nums[j] == target) {
            res = Math.max(res, 1 + dfs(nums, i + 1, j - 1, target));
        }

        memo.put(key, res);
        return res;
    }

    public int maxOperations(int[] nums) {
        int n = nums.length;
        return Math.max(
            dfs(nums, 2, n - 1, nums[0] + nums[1]),  // Start with first two elements
            Math.max(
                dfs(nums, 0, n - 3, nums[n - 1] + nums[n - 2]),  // Start with last two elements
                dfs(nums, 1, n - 2, nums[0] + nums[n - 1])  // Start with first and last element
            )
        ) + 1;
    }
}
