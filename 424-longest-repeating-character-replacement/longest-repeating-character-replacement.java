// class Solution {
//     public int characterReplacement(String s, int k) {
//         return Print(s,k);
//     }
//     public int Print(String s, int k){
//         int ans=0;
//         int n=s.length();
//         for(char c='A'; c<='Z'; c++){
//             int i=0;
//             int j=0; 
//             int repeated=0;
//             while(j<n){
//                 if(s.charAt(j)==c){
//                     j++;
//                 }
//                 else if(repeated<k){
//                     j++;
//                     repeated++;
//                 }
//                 else if(s.charAt(i)==c){
//                     i++;
//                 }
//                 else{
//                     i++;
//                     repeated--;
//                 }
//                 ans=Math.max(ans, j-i);
//             }
//         }
//         return ans;
//     }
// }


class Solution{
    public int characterReplacement(String s, int k){
        return Print(s,k);
    }
    public int Print(String s, int k){
        int[] charCount = new int[26];
        int si=0;
        int ei=0;
        int ans=0;
        int max=0;
        while(ei<s.length()){
            char ch = s.charAt(ei);
            charCount[ch-'A']++;
            max = Math.max(max,charCount[ch-'A']);

            if((ei-si+1)-max>k){
                charCount[s.charAt(si)-'A']--;
                si++;
            }
            ans=Math.max(ans,ei-si+1);
            ei++;
        }
        return ans;
    }
}