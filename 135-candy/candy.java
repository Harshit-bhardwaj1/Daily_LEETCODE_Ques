// class Solution {
//     public int candy(int[] ratings) {
//         return Candy(ratings);
//     }
//     public int Candy(int[] nums){
//         int n= nums.length;
//         int[] left = new int[nums.length];
//         int[] right = new int[nums.length];

//         for(int i=0; i<n; i++){
//             left[i]=1;
//             if(i>0 && nums[i]>nums[i-1]){
//                 left[i]=left[i-1]+1;
//             }
//         }

//         for(int i=n-1; i>=0; i--){
//             right[i]=1;
//             if(i<n-1 && nums[i]>nums[i+1]){
//                 right[i]=right[i+1]+1;
//             }
//         }

//         int count=0;
//         for(int i=0; i<n; i++){
//             count+=Math.max(left[i],right[i]);
//         }
//         return count;
//     }
// }


class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        
        // Step 1: Left to right
        candies[0] = 1;
        for (int i = 1; i < n; i++) {
            candies[i] = 1;
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        // Step 2: Right to left and sum up directly
        int total = candies[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            total += candies[i];
        }
        
        return total;
    }
}
