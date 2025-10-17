// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         return LIS(nums);
//     }
//     public static int LIS(int[] arr){
//         int [] dp = new int[arr.length];
//         Arrays.fill(dp,1);
//         for(int i=1; i<dp.length; i++){
//             for(int j=i-1)
//         }
//     }
// }


class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // return lis(nums, n);
        // return LIS_NLogn(nums);
        return LIS_Nlogn2(nums,n);
    }

    // LIS Ending with all element

    public int lis(int[] arr, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--){
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        //			int maxx = arr[0];
        //			for(int i = 1; i<n; i++) {
        //				maxx = Math.max(arr[i], maxx);
        //			}
        return Arrays.stream(dp).max().getAsInt();
    }
    public int LIS_NLogn(int[] arr){
        int[] lis = new int[arr.length];
        Arrays.fill(lis,1);
        lis[0]=arr[0];
        int len=1;

        for(int i=1; i<arr.length; i++){
            if(lis[len-1]<arr[i]){
                lis[len]=arr[i];
                len++;
            }
            else{
                int idx = BinarySearch(lis,0,len-1,arr[i]);
                lis[idx]=arr[i];
            }
        }
        return len;
    }
    public int BinarySearch(int[] lis, int lo, int hi, int item){
        int idx=0;
        while(lo<=hi){
            int mid= (lo+hi)/2;
            if(lis[mid]>=item){
                idx=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return idx;
    }

    public int Wine_BU(int [] wine){
        int n = wine.length;
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++){
            dp[i][i]=wine[i]*n;
        }
        int y = n-1;
        for(int d=1; d<n; d++){
            for(int j=d; j<n; j++){
                int i = j-d;
                int down = wine[i]*y + dp[i+1][j];
                int left = wine[j]*y + dp[i][j-1];
                dp[i][j]= Math.max(left,down);
            }
            y--;
        }
        return dp[0][n-1];
    }
    public int LIS_Nlogn2(int [] arr, int n){
        int[] lis = new int[n];
        Arrays.fill(lis,1);
        lis[0]=arr[0];
        int len =1;

        for(int i=1; i<n; i++){
            if(lis[len-1]<arr[i]){
                lis[len]=arr[i];
                len++;
            }
            else{
                int idx = Binarysearch(lis,0, len-1, arr[i]);
                lis[idx]=arr[i];
            }
        }
        return len;
    }
    public int Binarysearch(int[] lis, int lo, int hi, int item){
        int idx=0;
        while(lo<=hi){
            int mid= (lo+hi)/2;
            if(lis[mid]>=item){
                idx=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return idx;
    }
}