class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;

        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int[] a : dp) {
            Arrays.fill(a, -99999);
        }

        for (int col = 0; col < matrix[0].length; col++) {
            ans = Math.min(ans, min_falling_path_sum(matrix, 0, col, dp));
        }
        return ans;
        // return min_falling_path_sum_BU(matrix);
    }
    public static int min_falling_path_sum(int[][] arr, int cr, int cc, int[][] dp) {
        if (cc < 0 || cc >= arr[0].length) {
            return Integer.MAX_VALUE;
        }
        if (cr == arr.length - 1) {
            return arr[cr][cc];
        }
        if (dp[cr][cc] != -99999) {
            return dp[cr][cc];
        }
        int ld = min_falling_path_sum(arr, cr + 1, cc - 1, dp); // Left Diagonal
        int down = min_falling_path_sum(arr, cr + 1, cc, dp);
        int rd = min_falling_path_sum(arr, cr + 1, cc + 1, dp); // Right diagonal
        return dp[cr][cc] = Math.min(Math.min(ld, rd), down) + arr[cr][cc];
    }
    public static int min_falling_path_sum_BU(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i=0; i<grid[0].length; i++){
            dp[grid.length-1][i]=grid[grid.length-1][i];
        }

        for(int i=n-2; i>=0; i--){
            for(int j=0; j<m; j++){
                int ld = (j-1)>=0 ? dp[i+1][j-1] : Integer.MAX_VALUE;
                int down = dp[i+1][j];
                int rd = (j < m - 1) ? dp[i + 1][j + 1] : Integer.MAX_VALUE;
                dp[i][j] = Math.min(ld,Math.min(down,rd))+ grid[i][j];
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<grid[0].length; i++){
            ans= Math.min(ans,dp[0][i]);
        }
        return ans;
    }
    public int minimum(int[][] grid, int cc, int cr, int[][] dp){
        if(cc==grid[0].length-1 && cr==grid.length-1 ){
            return grid[cr][cc];
        }
        if(cc>=grid[0].length || cc<0 || cr<0 ||  cr >= grid.length){
            return 0;
        }
        if(dp[cr][cc]!=-1){
            return dp[cr][cc];
        }
        int down = minimum(grid,cc,cr+1,dp);
        int left = minimum(grid,cc-1,cr+1,dp);
        int right = minimum(grid,cc+1,cr+1,dp);
        return dp[cr][cc]=Math.min(down,Math.min(left,right)) + grid[cr][cc];
    }
}