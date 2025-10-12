class Solution {
    public int minFallingPathSum(int[][] grid) {
        int ans = Integer.MAX_VALUE;

        int[][] dp = new int[grid.length][grid[0].length];
        for (int[] a : dp) {
            Arrays.fill(a, -99999);
        }

        // for (int col = 0; col < grid[0].length; col++) {
        //     ans = Math.min(ans, min_falling_path_sum(grid, 0, col, dp));
        // }
        // return ans;
        return min_falling_path_sum_BU(grid);
    }
    public static int min_falling_path_sum(int[][] arr, int cr, int cc, int[][] dp) {
        // if (cc < 0 || cc >= arr[0].length) {
        //     return 10000000;
        // }
        if (cr == arr.length - 1) {
            return arr[cr][cc];
        }
        if (dp[cr][cc] != -99999) {
            return dp[cr][cc];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr[0].length; i++) {
            if (i == cc) {
                continue;
            }
            ans = Math.min(ans, min_falling_path_sum(arr, cr + 1, i, dp));
        }
        return dp[cr][cc] = ans + arr[cr][cc];
    }
    public static int min_falling_path_sum_BU(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int i=0; i<m; i++){
            dp[n-1][i]= grid[n-1][i];
        }
        for(int i=n-2; i>=0; i--){
            for(int j=0; j<m; j++){
                int ans= Integer.MAX_VALUE;
                for(int nc=0; nc<m; nc++){
                    if(nc==j){
                        continue;
                    }
                    ans= Math.min(ans, dp[i+1][nc]);
                }
                dp[i][j] = ans+grid[i][j];
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<m; i++){
            ans = Math.min(ans,dp[0][i]);
        }
        return ans;
    }
}  