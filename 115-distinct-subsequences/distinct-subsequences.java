class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int[] a: dp){
            Arrays.fill(a,-1);
        }
        // return Distinct(s,t,0,0,dp);
        return Distinct_BU(s,t);
    }
    public int Distinct(String s, String t, int i,int j, int[][] dp){
        if(t.length()==j){
            return 1;
        }
        if(i==s.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int inc=0;
        if(s.charAt(i)==t.charAt(j)){
            inc = Distinct(s,t,i+1,j+1,dp);
        }
        int exc= Distinct(s,t,i+1,j,dp);
        return dp[i][j]= inc+exc;
    }
    public int Distinct_BU(String s, String t){
        int[][] dp = new int[s.length()+1][t.length()+1];

        for(int i=0; i<dp.length; i++){
            dp[i][0]=1;
        }

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                int inc=0;
                if(s.charAt(i-1)==t.charAt(j-1)){
                    inc = dp[i-1][j-1];
                }
                int exc = dp[i-1][j];
                dp[i][j]= inc+exc;
            }
        }
        return dp[s.length()][t.length()];
    }
}