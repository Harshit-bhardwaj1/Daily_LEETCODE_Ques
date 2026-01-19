class Solution {
    Boolean[][] dp;
    public boolean checkValidString(String s) {
        int n = s.length();
        dp = new Boolean[n + 1][n + 1];   // dp[i][p]
        // int[][] dp = new int[]
        // return String(s);
        return Dp(s,0,0);
    }
    public boolean String(String s){
        int a=0;
        int b=0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='('){
                a++;
                b++;
            }
            else if(ch==')'){
                a--;
                b--;
            }
            else{
                a--;
                b++;
            }
            if (b < 0) return false;   // too many ')'
            if (a < 0) a = 0;     
        }
        
        return a==0;
    }
    public boolean Dp(String s, int i, int p){
        if(p<0) return false;
        if(i==s.length()){
            return p==0;
        }

        if (dp[i][p] != null) {
            return dp[i][p];             // already solved
        }
        boolean ans=false;
        if(s.charAt(i)=='('){
            ans = Dp(s,i+1,p+1);
        }
        else if(s.charAt(i)==')'){
            ans = Dp(s,i+1,p-1);
        }
        else{
            boolean a = Dp(s,i+1,p+1);
            boolean b = Dp(s,i+1,p-1);
            boolean c = Dp(s,i+1,p);

            ans = a || b || c;
        }

        dp[i][p]=ans;
        return ans;
    }
}