// class Solution {
//     public int countHousePlacements(int n) {
        
//     }
// }


class Solution {
    long MOD = 1_000_000_007;
    long[] dp;

    public int countHousePlacements(int n) {
        dp = new long[n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }

        long oneSide = ways(n);
        return (int)((oneSide * oneSide) % MOD);
    }

    // ways to place houses on ONE side
    private long ways(int n) {
        if (n == 0) return 1; // empty
        if (n == 1) return 2; // E, H

        if (dp[n] != -1) return dp[n];

        long empty = ways(n - 1); // place empty
        long house = ways(n - 2); // place house

        dp[n] = (empty + house) % MOD;
        return dp[n];
    }
}
