class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        return Count(grid);
    }
    public int Count(int[][] arr){
        int max=0;
        
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j]==1){
                    int area = dfs(arr,i,j);
                    max = Math.max(max,area);
                }
            }
        }
        return max;
    }
    public int dfs(int[][] arr, int i, int j){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]==0){
            return 0;
        }

        arr[i][j]=0;
        int area=1;

        area = area + dfs(arr, i+1,j);
        area = area + dfs(arr, i-1,j);
        area = area + dfs(arr, i,j-1);
        area = area + dfs(arr, i,j+1);

        return area;
    }
}