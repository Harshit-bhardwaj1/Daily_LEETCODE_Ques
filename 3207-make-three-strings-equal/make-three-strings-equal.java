class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        return Find(s1,s2,s3);
    }
    public int Find(String s1, String s2, String s3){
        int n = Math.min(s1.length(),Math.min(s2.length(),s3.length()));
        if(s1.charAt(0)!=s2.charAt(0) || s1.charAt(0)!=s3.charAt(0) || s2.charAt(0)!=s3.charAt(0)) {
            return -1;
        }
        int ans=0;
        int count=1;
        for(int i=1; i<n; i++){
            char c1= s1.charAt(i);
            char c2= s2.charAt(i);
            char c3= s3.charAt(i);
            if(c1!=c3 || c2!=c3 || c1!=c3){
                break;
            }
            else{
                count++;
            }
        }
        ans+=(s1.length()-count)+(s2.length()-count)+(s3.length()-count);
        return ans;
    }
}