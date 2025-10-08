// class Solution {
//     public int maxProduct(int[] nums) {
//         return Product(nums);
//     }
//     public int Product(int[] nums){
//         int product = 1;
//         int maxProduct = Integer.MIN_VALUE;

//         int si = 0, ei = 0;
//         while (ei < nums.length) {
//             product *= nums[ei];
//             maxProduct = Math.max(maxProduct, product);

//             // if product becomes 0, reset window
//             if (product == 0) {
//                 product = 1;
//                 si = ei + 1;
//             }
//             ei++;
//         }

//         // handle negatives by doing another pass from right to left
//         product = 1;
//         for (int i = nums.length - 1; i >= 0; i--) {
//             product *= nums[i];
//             maxProduct = Math.max(maxProduct, product);
//             if (product == 0) product = 1;
//         }

//         return maxProduct;
//     }
// }

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxHere = nums[0];
        int minHere = nums[0]; // track min because negatives can flip
        int result = nums[0];
        
        for (int i = 1; i < n; i++) {
            int temp = maxHere;

            // choose between current number alone or extending product
            maxHere = Math.max(nums[i], Math.max(maxHere * nums[i], minHere * nums[i]));
            minHere = Math.min(nums[i], Math.min(temp * nums[i], minHere * nums[i]));

            result = Math.max(result, maxHere);
        }
        
        return result;
    }
}
