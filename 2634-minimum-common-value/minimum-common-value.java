class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        return GetCommon(nums1,nums2);
    }
    public static int GetCommon(int[] arr1, int[] arr2){
        int i=0;
        int j=0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]==arr2[j]){
                return arr1[i];
            }
            else if(arr1[i]<arr2[j]){
                i++;
            }
            else{
                j++;
            }
        }
        return -1;
    }
}