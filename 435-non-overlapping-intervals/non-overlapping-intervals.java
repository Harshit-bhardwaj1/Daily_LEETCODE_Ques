class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        return Overlap(intervals);
    }
    public int Overlap(int[][] arr){
        Arrays.sort(arr, (a,b) -> Integer.compare(a[1],b[1]));
        int end = arr[0][1];
        int count=0;
        for(int i=1; i<arr.length; i++){
            if(end<=arr[i][0]){
                end=arr[i][1];
            }
            else{
                count++;
            }
        }
        return count;
    }
}