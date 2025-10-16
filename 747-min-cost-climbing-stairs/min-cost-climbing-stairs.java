// class Solution {
//     public int minCostClimbingStairs(int[] cost) {
//         int[] dp = new int[cost.length];
//         Arrays.fill(dp,-1);
//         int zeroth = Cost(cost,0,dp);
//         int first =  Cost(cost,1,dp);
//         return  Math.min(zeroth,first); 
//           }
//     public int Cost(int[] cost,int i, int[] dp){
//         if(i>=cost.length){
//             return 0;
//         }
//         if(dp[i]!=-1){
//             return dp[i];
//         }
//         int step1= cost[i]+Cost(cost,i+2,dp);
//         int step0= cost[i]+Cost(cost,i+1,dp);
//         return dp[i]= Math.min(step1,step0);
//     }
// }


// class Solution{
//     public int minCostClimbingStairs(int[] cost){
//         int[] dp = new int[cost.length];
//         Arrays.fill(dp,-1);
//         int zero =Cost(cost,dp,0);
//         int one =Cost(cost,dp,1);
//         return Math.min(zero,one);
//     }
//     public int Cost(int[] cost,int[] dp, int idx){
//         if(idx>=cost.length){
//             return 0;
//         }
//         if(dp[idx]!=-1){
//             return dp[idx];
//         }
//         int step1= Cost(cost,dp,idx+1);
//         int step2= Cost(cost,dp,idx+2);
//         return dp[idx]= cost[idx] + Math.min(step1,step2);
//     }
// }


class Solution{
    public int minCostClimbingStairs(int[] cost){
        int zero =Cost_BU(cost,0);
        int one =Cost_BU(cost,1);
        return Math.min(zero,one);
    }
    public int Cost_BU(int [] cost,int idx){
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp,0);
        dp[cost.length-1]=cost[cost.length-1];
        for(int i=cost.length-2; i>=0; i--){
            int step1=cost[i]+dp[i+1];
            int step2=cost[i]+dp[i+2];
            dp[i]= Math.min(step1,step2);
        }
        return dp[idx];
    }
}