// class Solution {
//     public boolean validPartition(int[] nums) {
        
//     }
// }


class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n + 1];
        dp[n] = true; // base case: empty array is valid

        for (int i = n - 1; i >= 0; i--) {

            // Case 1: two equal elements
            if (i + 1 < n && nums[i] == nums[i + 1]) {
                if (dp[i + 2]) dp[i] = true;
            }

            // Case 2: three equal elements
            if (i + 2 < n && nums[i] == nums[i + 1] && nums[i] == nums[i + 2]) {
                if (dp[i + 3]) dp[i] = true;
            }

            // Case 3: three consecutive increasing elements
            if (i + 2 < n &&
                nums[i + 1] == nums[i] + 1 &&
                nums[i + 2] == nums[i] + 2) {
                if (dp[i + 3]) dp[i] = true;
            }
        }
        return dp[0];
    }
}
