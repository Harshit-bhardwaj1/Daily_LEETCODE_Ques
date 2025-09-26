class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        return Max(nums);
    }
    public int Max(int[] nums){
        int total=0;
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            total+=nums[i];
            ans= Math.max(ans,nums[i]);
        }

        int sum=0;
        int minsum=0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            minsum=Math.min(minsum,sum);
            if(sum>0){
                sum=0;
            }
        }

        sum=0;
        int maxsum=Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            maxsum=Math.max(maxsum,sum);
            if(sum<0){
                sum=0;
            }
        }
        int res= Math.max(maxsum,total-minsum);

        return (res==0) ? ans :res;
    }
}