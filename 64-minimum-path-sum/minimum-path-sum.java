class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        // return pathSum(grid, 0, 0, dp);
        return Path_Sum_BU(grid);
    }
    public static int pathSum(int[][] grid, int cr, int cc, int[][] dp) {
        if (cr == grid.length - 1 && cc == grid[0].length - 1) {
            return grid[cr][cc];
        }
        if (cr >= grid.length || cc >= grid[0].length) {
            return Integer.MAX_VALUE;
        }

        if (dp[cr][cc] != -1) {
            return dp[cr][cc];
        }
        int right = pathSum(grid, cr, cc + 1, dp);
        int down = pathSum(grid, cr + 1, cc, dp);
        return dp[cr][cc] = Math.min(right, down) + grid[cr][cc];
    }
    public static int Path_Sum_BU(int[][] grid){
        int[][] dp = new int[grid.length][grid[0].length];

        int sum=0;
        for(int i=0; i<grid.length; i++){
            sum+=grid[i][0];
            dp[i][0]=sum;
        }
        sum=0;
        for(int i=0; i<grid[0].length; i++){
            sum+=grid[0][i];
            dp[0][i]=sum;
        }
        for(int i=1; i<grid.length; i++){
            for(int j=1; j<grid[0].length; j++){
                int right = dp[i-1][j];
                int down= dp[i][j-1];
                dp[i][j]= Math.min(right,down)+grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}