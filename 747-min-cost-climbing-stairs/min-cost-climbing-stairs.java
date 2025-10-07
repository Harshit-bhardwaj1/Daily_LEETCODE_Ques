class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp,-1);
        int zeroth = Cost(cost,0,dp);
        int first =  Cost(cost,1,dp);
        return  Math.min(zeroth,first); 
          }
    public int Cost(int[] cost,int i, int[] dp){
        if(i>=cost.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int step1= cost[i]+Cost(cost,i+2,dp);
        int step0= cost[i]+Cost(cost,i+1,dp);
        return dp[i]= Math.min(step1,step0);
    }
}