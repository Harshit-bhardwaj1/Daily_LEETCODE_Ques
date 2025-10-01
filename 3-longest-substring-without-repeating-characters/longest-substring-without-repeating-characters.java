class Solution {
    public int lengthOfLongestSubstring(String s) {
        return Print2(s);

    }
    
//     public int Print(String s) {
//     int si = 0; // Start index of the sliding window
//     int ei = 0; // End index of the sliding window
//     int ans = 0; // Maximum length of substring without repeating characters

//     int[] freq = new int[256]; // Frequency array for characters (ASCII size)

//     while (ei < s.length()) {
//         char currentChar = s.charAt(ei);
//         freq[currentChar]++;

//         // Shrink the window if the character is repeated
//         while (freq[currentChar] > 1) {
//             freq[s.charAt(si)]--;
//             si++;
//         }

//         // Update the maximum length
//         ans = Math.max(ans, ei - si + 1);
//         ei++;
//     }

//     return ans;
// }

    // public int Print(String s){
    //     int si=0; 
    //     int ei=0;
    //     int ans=0;
    //     int[] arr= new int[256];
    //     while(ei<s.length()){
    //         arr[s.charAt(ei)]++;

    //         while(arr[s.charAt(ei)]>1){
    //             arr[s.charAt(si)]--;
    //             si++;
    //         }
    //         ans= Math.max(ans,ei-si+1);
    //         ei++;
    //     }
    //     return ans;
    // }


    public int Print(String s){
        int[] freq=new int[256];
        int ans=0;
        int ei=0;
        int si=0;
        while(ei<s.length()){
            char ch= s.charAt(ei);
            freq[ch]++;

            while(freq[ch]>1){
                freq[s.charAt(si)]--;
                si++;
            }

            ans=Math.max(ans,ei-si+1);
            ei++;
        }
        return ans;
    }
    public int Print2(String s){
        int ans=0;
        int ei=0;
        int si=0;
        Set<Character> set = new HashSet<>();
        while(ei<s.length()){
            if(!set.contains(s.charAt(ei))){
                set.add(s.charAt(ei));
                ans= Math.max(ans,ei-si+1);
                ei++;
            }
            else{
                set.remove(s.charAt(si));
                si++;
            }
        }
        return ans;
    }
}