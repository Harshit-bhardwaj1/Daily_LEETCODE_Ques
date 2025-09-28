// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int p1 = m - 1; // Pointer for the last element in nums1's initial part
//         int p2 = n - 1; // Pointer for the last element in nums2
//         int p = m + n - 1; // Pointer for the last position in nums1

//         while (p1 >= 0 && p2 >= 0) {
//             if (nums1[p1] > nums2[p2]) {
//                 nums1[p] = nums1[p1];
//                 p1--;
//             } else {
//                 nums1[p] = nums2[p2];
//                 p2--;
//             }
//             p--;
//         }

//         // Copy remaining elements from nums2, if any
//         while (p2 >= 0) {
//             nums1[p] = nums2[p2];
//             p2--;
//             p--;
//         }
//     }
// }


class Solution{
    public void merge(int[] nums1, int m, int[] nums2, int n){
        int i= m-1;
        int j=n-1;
        int idx= m+n-1;

        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
                nums1[idx]=nums1[i];
                i--;
                idx--;
            }
            else{
                nums1[idx]=nums2[j];
                j--;
                idx--;
            }
        }
        while(j>=0){
            nums1[idx]=nums2[j];
            j--;
            idx--;
        }
    }
}