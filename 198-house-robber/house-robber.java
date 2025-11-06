class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return Robber(nums,0,dp);
    }
    public static int Robber(int[] arr, int i, int[] dp){
        if(i>=arr.length){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int rob= arr[i] + Robber(arr, i+2, dp);
        int Dont_rob=Robber(arr, i+1, dp);
        return dp[i]= Math.max(rob, Dont_rob);
    }
    public static int RobberBU(int[] arr) {
    int n = arr.length;
    int[] dp = new int[n + 2]; // +2 so that i+2 access na ho out of bound
    
    for (int i = n - 1; i >= 0; i--) {
        int rob = arr[i] + dp[i + 2];
        int dontRob = dp[i + 1];
        dp[i] = Math.max(rob, dontRob);
    }
    return dp[0];
    }
}