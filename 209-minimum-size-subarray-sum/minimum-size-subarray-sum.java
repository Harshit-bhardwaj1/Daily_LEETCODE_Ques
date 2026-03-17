class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int si=0;
        int ei=0;
        int sum=0;
        int ans=Integer.MAX_VALUE;
        while(ei<nums.length){
            sum+=nums[ei];
            while(sum>=target){
                ans=Math.min(ans,ei-si+1);
                sum-=nums[si];
                si++;
            }
            ei++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}