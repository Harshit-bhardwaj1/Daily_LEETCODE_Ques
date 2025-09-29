class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] pmax= new int[nums.length];
        int[] smax= new int[nums.length];
        int[] ans = new int[n-k+1];
        pmax[0]=nums[0];
        for(int i=1; i<pmax.length; i++){
            if(i%k==0){
                pmax[i]=nums[i];
            }
            else{
                pmax[i]=Math.max(pmax[i-1],nums[i]);
            }
        }
        smax[n-1]=nums[n-1];
        for(int i=n-2; i>=0; i--){
            if((i+1)%k==0){
                smax[i]=nums[i];
            }
            else{
                smax[i]=Math.max(smax[i+1],nums[i]);
            }
        }
        for(int i=0; i<ans.length; i++){
            ans[i]=Math.max(smax[i],pmax[i+k-1]);
        }
        return ans;
    }
}