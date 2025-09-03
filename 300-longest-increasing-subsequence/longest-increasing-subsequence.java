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
        return lis(nums, n);
    }

    // LIS Ending with all element

    public int lis(int[] arr, int n) {
        // TODO Auto-generated method stub
        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
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
}