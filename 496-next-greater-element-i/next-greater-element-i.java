class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        return Greater(nums1,nums2);
    }
    public int[] Greater(int[] nums1, int[] nums2){
        int idx=0;
        int[] arr = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            arr[idx++] = Find(nums1[i],nums2);
        }
        return arr;
    }
    public int Find(int item, int[] nums2){
        int temp=0;
        for(int i=0; i<nums2.length; i++){
            if(item==nums2[i]){
                temp=i;
                break;
            }
        }
        if(temp==nums2.length-1) return -1;

        for(int i=temp; i<nums2.length; i++){
            if(nums2[i]>nums2[temp]) return nums2[i];
        }

        return -1;
    }
}