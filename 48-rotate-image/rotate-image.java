class Solution {
    public void rotate(int[][] matrix) {
        Rotate(matrix);
    }
    public void Rotate(int[][] matrix){
        int n= matrix.length;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }


        for(int i=0; i<n; i++){
            int lo=0;
            int hi=matrix[0].length-1;
            while(lo<hi){
                int temp = matrix[i][lo];
                matrix[i][lo] = matrix[i][hi];
                matrix[i][hi] = temp;
                lo++;
                hi--;
            }
        }
    }
}