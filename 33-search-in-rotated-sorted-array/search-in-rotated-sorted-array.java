class Solution {
    public int search(int[] nums, int target) {
        return Search(nums,target);
    }
    public int Search(int[] arr, int target){
        // int lo=0;
        // int hi=arr.length-1;
        // while(lo<hi){
        //     int mid=(lo+hi)/2;
        //     if(target==arr[mid]){
        //         return mid;
        //     }
        //     else if(target<arr[mid]){
        //         hi=mid-1;
        //     }
        //     else{
        //         lo=mid+1;
        //     }
        // }
        // return -1;

        // for(int i=0; i<arr.length; i++){
        //     if(target==arr[i]){
        //         return i;
        //     }
        // }
        // return -1;
        
        int lo=0;
        int hi = arr.length -1;
        while(lo<=hi){
            int mid= (lo+hi)/2;
            if(target==arr[mid]) return mid;

            if(arr[lo]<=arr[mid]){
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
        return -1;
    }
}