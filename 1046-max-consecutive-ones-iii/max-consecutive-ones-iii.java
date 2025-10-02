class Solution {
    public int longestOnes(int[] nums, int k) {
        return Longest(nums,k);
    }
    public int Longest(int[] arr, int k){
        int si=0;
        int ei=0;
        int temp=k;
        int zeroes=0;
        int ans=0;
        while(ei<arr.length){
            if(arr[ei]==0){
                zeroes++;
            }
            while(zeroes>k){
                if(arr[si]==0){
                    zeroes--;
                }
                si++;
            }
            ans= Math.max(ans,ei-si+1);
            ei++;
        }
        return ans;
    }
}