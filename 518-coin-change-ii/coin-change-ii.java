class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount+1][coins.length];
        for(int [] i: dp){
            Arrays.fill(i, -1);
        }
        // return Coin_Change(coins,amount,0,dp);
        return Coin_Change_BU(coins,amount);

    }
    // TD
    public static int Coin_Change(int[] coin, int amount, int i, int[][] dp){
        if(amount==0){
            return 1;
        }
        if(i== coin.length){
            return 0;
        }
        if(dp[amount][i] != -1){
            return dp[amount][i];
        }
        int inc=0, exc =0;
        if(amount >= coin[i]){
            inc= Coin_Change(coin, amount-coin[i], i, dp);
        }
        exc = Coin_Change(coin, amount, i+1, dp);
        return dp[amount][i] = inc+exc;
    }
    public static int Coin_Change_BU(int[] coin, int amount){
        int[][] dp = new int[amount+1][coin.length+1];

        for(int i=0; i<dp[0].length; i++){
            dp[0][i]=1;
        }
        for(int am=1; am<dp.length; am++){
            for(int i=1; i<dp[0].length; i++){
                int inc=0, exc=0;
                if(coin[i-1]<=am){
                    inc = dp[am-coin[i-1]][i];
                }
                exc = dp[am][i-1];
                dp[am][i]=inc+exc;
            }
        }
        return dp[amount][coin.length];
    }
}