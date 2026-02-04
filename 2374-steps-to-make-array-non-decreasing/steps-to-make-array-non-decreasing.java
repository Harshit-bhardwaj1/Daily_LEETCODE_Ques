// class Solution {
//     public int totalSteps(int[] nums) {
        
//     }
// }


class Solution {
    public int totalSteps(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Stack<Integer> st = new Stack<>();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int maxStep = 0;

            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                maxStep = Math.max(maxStep, dp[st.pop()]);
            }

            if (st.isEmpty()) {
                dp[i] = 0;
            } else {
                dp[i] = maxStep + 1;
            }

            ans = Math.max(ans, dp[i]);
            st.push(i);
        }

        return ans;
    }
}
