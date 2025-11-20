class Solution {
    public int minimumArea(int[][] grid) {
        int row= grid.length;
        int col = grid[0].length;

        int er= 0;
        int sr= row-1;
        int ec= 0;
        int sc= col-1;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j]==1){
                   sr=Math.min(sr,i);
                   er=Math.max(er,i);
                   sc= Math.min(sc,j);
                   ec= Math.max(ec,j);
                }
            }
        }
        int height = er-sr + 1;
        int width  = ec-sc + 1;
        return height * width;
    }
}