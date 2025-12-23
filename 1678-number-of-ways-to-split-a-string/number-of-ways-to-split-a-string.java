class Solution {
    public int numWays(String s) {
        return Ways(s);
    }
    public int Ways(String s){
        int mod=1000000007;
        int totalones=0;
        int n= s.length();
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='1'){
                totalones++;
            }
        }
        
        if(totalones%3!=0) return 0;

        if(totalones==0){
            long ways = (long) (n-1)*(n-2)/2;
            return (int)(ways%mod);
        }

        int k= totalones/3;
        int count=0;
        long first=0 , second=0;
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='1'){
                count++;
            }
            if(count==k){
                first++;
            }
            else if(count==2*k){
                second++;
            }
        }
        return (int)((first*second)%mod);
    }
}