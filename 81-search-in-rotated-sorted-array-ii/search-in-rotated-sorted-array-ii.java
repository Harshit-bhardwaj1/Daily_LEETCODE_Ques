class Solution {
    public boolean search(int[] nums, int target) {
        return Search(nums,target);
    }
    public boolean Search(int[] arr, int target){
        int lo=0;
        int hi=arr.length-1;
        while(lo<=hi){
            int mid= (lo+hi)/2;
            if(arr[lo]==target || arr[mid]==target || arr[hi]==target){
                return true;
            }
            if(arr[lo] == arr[mid] && arr[mid]==arr[hi]){
                lo++;
                hi--;
            }
            else if(arr[lo]<=arr[mid]){
                if(arr[lo]<=target && target < arr[mid]){
                    hi =mid-1;
                }
                else{
                    lo=mid+1;
                }
            }
            else{
                if(arr[mid] < target && target <= arr[hi]){
                    lo=mid+1;
                }
                else{
                    hi = mid-1;
                }
            }
        }
        return false;
        }
}