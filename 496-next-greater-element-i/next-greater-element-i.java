class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        int idx=0;
        for(int i=0; i<nums1.length; i++){
            int j =Find(nums1[i],nums2);
            if(j==-1){
                ans[idx++]=j;
            }
            else{
                ans[idx++]=Next(j,nums1[i],nums2);
            }
        }
        return ans;
    }
    public int Find(int item, int[] nums2){
        for(int i=0; i<nums2.length; i++){
            if(nums2[i]==item){
                return i;
            }
        }
        return -1;
    }
    public int Next(int idx, int item, int[] nums){
        for(int i=idx; i<nums.length; i++){
            if(nums[i]>item){
                return nums[i];
            }
        }
        return -1;
    }
}