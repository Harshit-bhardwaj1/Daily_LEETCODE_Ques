class Solution {
    public int minimumArea(int[][] grid) {
        int row= grid.length;
        int col = grid[0].length;

        int r_min= Integer.MAX_VALUE;
        int c_min= Integer.MAX_VALUE;
        int r_max= Integer.MIN_VALUE;
        int c_max= Integer.MIN_VALUE;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j]==1){
                    if (i < r_min) r_min = i;
                    if (i > r_max) r_max = i;
                    if (j < c_min) c_min = j;
                    if (j > c_max) c_max = j;
                }
            }
        }
        int height = r_max - r_min + 1;
        int width  = c_max - c_min + 1;
        return height * width;
    }
}