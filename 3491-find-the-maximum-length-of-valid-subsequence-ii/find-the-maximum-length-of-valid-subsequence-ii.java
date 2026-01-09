// class Solution {
//     public int maximumLength(int[] nums, int k) {
        
//     }
// }


class Solution {
    public int maximumLength(int[] nums, int k) {
        // dp[i][j] = longest valid subsequence where
        // last element mod k = i and second-last mod k = j
        int[][] dp = new int[k][k];
        int result = 0;
        
        for (int num : nums) {
            int r = num % k;
            // Try extending every possible pair
            for (int prev = 0; prev < k; prev++) {
                dp[r][prev] = dp[prev][r] + 1;
                result = Math.max(result, dp[r][prev]);
            }
        }
        return result;
    }
}
