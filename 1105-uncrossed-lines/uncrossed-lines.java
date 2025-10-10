class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        // return LCSBU(nums1,nums2);
        return LCSTD(nums1,nums2,0,0,dp);

    }
    public static int LCSBU(int []s1, int []s2){
        int[][] dp = new int[s1.length+1][s2.length+1];
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(s1[i-1]==s2[j-1]){
                    dp[i][j]= 1 + dp[i - 1][j - 1];
                }
                else{
                    int fs = dp[i - 1][j];
					int ss = dp[i][j - 1];
					dp[i][j] = Math.max(fs, ss);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length-1];
    }

    public static int LCSTD(int[] s1, int[] s2, int i, int j, int[][] dp){
        if(i==s1.length || j==s2.length){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1[i]==s2[j]){
            dp[i][j]=1+ LCSTD(s1,s2,i+1,j+1,dp);
        }
        else{
            int f= LCSTD(s1,s2,i+1,j,dp);
            int s= LCSTD(s1,s2,i,j+1,dp);
            dp[i][j]=Math.max(f,s);
        }
        return dp[i][j];
    }
}