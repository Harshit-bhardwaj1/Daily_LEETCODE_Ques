class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        // return Min_Ops(word1,word2, 0,0,dp);
        return Min_Ops_BU(word1,word2);
    }
    public static int Min_Ops(String s, String t , int i, int j,int[][] dp){
        if(i == s.length()){
            return t.length()-j;
        }
        if(j == t.length()){
            return s.length()-i;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }

        int ans=0;
        if(s.charAt(i)== t.charAt(j)){
            ans= Min_Ops(s, t, i+1, j+1,dp);
        }
        else{
            int D = Min_Ops(s, t, i+1, j,dp);
            int R = Min_Ops(s, t, i+1, j+1,dp);
            int I = Min_Ops(s, t, i, j+1,dp);
            ans= Math.min(D, Math.min(R,I))+1;
        }
        return dp[i][j]=ans;
    }

    public static int Min_Ops_BU(String s, String t){
    int[][] dp = new int[s.length()+1][t.length()+1];

    for(int i =0; i<=t.length(); i++){
        dp[0][i]=i;
    }
    for(int i=0; i<=s.length(); i++){
        dp[i][0]=i;
    }

    for(int  i=1; i<=s.length(); i++){
        for(int j=1; j<=t.length(); j++){
            if(s.charAt(i-1)==t.charAt(j-1)){
                dp[i][j]=dp[i-1][j-1];
            }
            else{
                int D = dp[i-1][j];
                int I = dp[i][j-1];
                int R = dp[i-1][j-1];
                dp[i][j] = Math.min(D, Math.min(I,R))+1;
            }
        }
    }
    return dp[s.length()][t.length()];
    }
}