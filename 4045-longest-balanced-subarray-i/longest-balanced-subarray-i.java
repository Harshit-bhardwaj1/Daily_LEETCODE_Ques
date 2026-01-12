// class Solution {
//     public int longestBalanced(int[] nums) {
        
//     }
// }


class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int ans = 0;

        // Track counts of distinct evens and odds in a sliding window
        for (int left = 0; left < n; left++) {
            HashMap<Integer, Integer> evenCount = new HashMap<>();
            HashMap<Integer, Integer> oddCount = new HashMap<>();
            for (int right = left; right < n; right++) {
                int val = nums[right];
                if (val % 2 == 0) {
                    evenCount.put(val, evenCount.getOrDefault(val, 0) + 1);
                } else {
                    oddCount.put(val, oddCount.getOrDefault(val, 0) + 1);
                }
                if (evenCount.size() == oddCount.size()) {
                    ans = Math.max(ans, right - left + 1);
                }
            }
        }
        return ans;
    }
}
