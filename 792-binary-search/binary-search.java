// class Solution {
//     public int search(int[] nums, int target) {
//         return Search(nums,target);
//     }
//     public static int Search(int[] arr, int target){
//         int lo=0;
//         int hi=arr.length-1;
//         while(lo<=hi){
//             int mid= lo+(hi-lo)/2;
//             if(arr[mid]==target){
//                 return mid;
//             }
//             else if(arr[mid]<target){
//                 lo=mid+1;
//             }
//             else{
//                 hi=mid-1;
//             }
//         }
//         return -1;
//     }
// }


class Solution{
    public int search(int[] nums, int target){
        return Search(nums,target);
    }
    public int Search(int[] arr, int target){
        int lo=0;
        int hi=arr.length-1;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]>target){
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return -1;
    }
}