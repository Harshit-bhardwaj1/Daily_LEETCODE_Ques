class Solution {
    public int maxProduct(int[] nums) {
        return Product(nums);
    }
    public int Product(int[] nums){
        int product = 1;
        int maxProduct = Integer.MIN_VALUE;

        int si = 0, ei = 0;
        while (ei < nums.length) {
            product *= nums[ei];
            maxProduct = Math.max(maxProduct, product);

            // if product becomes 0, reset window
            if (product == 0) {
                product = 1;
                si = ei + 1;
            }
            ei++;
        }

        // handle negatives by doing another pass from right to left
        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            product *= nums[i];
            maxProduct = Math.max(maxProduct, product);
            if (product == 0) product = 1;
        }

        return maxProduct;
    }
}
