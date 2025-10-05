// class Solution {
//     public int numSubarrayProductLessThanK(int[] nums, int k) {
//         return MaxProduct(nums,k);
//     }
//     public int MaxProduct(int[] arr, int k){
//         int p=1, ans=0, si=0, ei=0;
//         while(ei<arr.length){
//             // grow

//             p=p*arr[ei];

//             // shrink
//             while(p>=k && si<=ei){
//                 p=p/arr[si];
//                 si++;
//             }

//             // ans update
//             ans=ans+(ei-si+1);
//             ei++;
//         }
//         return ans;
//     }
// }


class Solution{
    public int numSubarrayProductLessThanK(int[] nums, int k){
        return maxProduct(nums,k);
    }
    public int maxProduct(int[] arr, int k){
        int ei=0;
        int si=0;
        int temp=0;
        int product=1;
        while(ei<arr.length){
            product*=arr[ei];
            
            while(product>=k && si<=ei){
                product/=arr[si];
                si++;
            }
            temp+=ei-si+1;
            ei++;
        }
        return temp;
    }
}