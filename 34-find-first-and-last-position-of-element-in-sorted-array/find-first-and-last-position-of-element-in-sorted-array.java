// class Solution {
//     public int[] searchRange(int[] nums, int target) {
//         return SearchRange(nums,target);
//     }
//     public int[] SearchRange(int [] arr, int target){
//         int i=0;
//         int j=arr.length-1;
//         int [] n= new int [2];
//         while(i<=j){
//             if(arr[i]==target && arr[j]==target){
//                 n[0]=i;
//                 n[1]=j;
//                 return n;
//             }
//             else if(arr[i]!=target){
//                 i++;
//             }
//             else{
//                 j--;
//             }
//         }
//         return new int[]{-1,-1};
//     }
// }


class Solution{
    public int[] searchRange(int[] nums, int target){
        int[] arr = new int[2];
        arr[0]=search(nums,target,0);
        arr[1]=search(nums,target,1);
        return arr;
    }
    public int search(int[] nums, int target, int pos){
        int lo=0;
        int hi= nums.length-1;
        int ans=-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]==target){
                ans=mid;
                if(pos==0){
                    hi=mid-1;
                }
                else{
                    lo=mid+1;
                }
            }
            else if(nums[mid]>target){
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
}