// class Solution {
//     public int findMinimumTime(List<Integer> strength, int k) {
        
//     }
// }


class Solution {
    public int findMinimumTime(List<Integer> strength, int k) {
        int n = strength.size();
        int N = 1 << n;
        
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int mask = 0; mask < N; mask++) {
            int broken = Integer.bitCount(mask);
            int x = 1 + broken * k;
            
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) == 0) {
                    int nextMask = mask | (1 << i);
                    int time = (strength.get(i) + x - 1) / x;
                    
                    dp[nextMask] = Math.min(
                        dp[nextMask],
                        dp[mask] + time
                    );
                }
            }
        }
        
        return dp[N - 1];
    }
}
