class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return Search(matrix,target);
    }
    public boolean Search(int[][] arr, int target){
        int row=arr.length;
        int col=arr[0].length;
        for(int i=0; i<row; i++){
            if(target>=arr[i][0] && target<=arr[i][col-1]){
                int lo=0;
                int hi=col-1;
                while(lo<=hi){
                    int mid= (lo+hi)/2;
                    if(arr[i][mid]==target){
                        return true;
                    }
                    else if(arr[i][mid]<target){
                        lo=mid+1;
                    }
                    else{
                        hi=mid-1;
                    }
                }
            }
        }
        return false;
    }
}