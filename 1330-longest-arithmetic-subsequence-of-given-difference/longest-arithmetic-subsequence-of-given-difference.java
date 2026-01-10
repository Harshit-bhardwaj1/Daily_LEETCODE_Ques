// class Solution {
//     public int longestSubsequence(int[] arr, int difference) {
        
//     }
// }


class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        int ans = 0;

        for (int x : arr) {
            int prev = x - difference;
            int len = dp.getOrDefault(prev, 0) + 1;
            dp.put(x, len);
            ans = Math.max(ans, len);
        }

        return ans;
    }
}
