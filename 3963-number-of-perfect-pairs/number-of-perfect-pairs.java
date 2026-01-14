// class Solution {
//     public long perfectPairs(int[] nums) {
        
//     }
// }


import java.util.*;

class Solution {
    public long perfectPairs(int[] nums) {
        int n = nums.length;
        long[] arr = new long[n];

        // take absolute values
        for (int i = 0; i < n; i++) {
            arr[i] = Math.abs((long) nums[i]);
        }

        // sort
        Arrays.sort(arr);

        long count = 0;
        int j = 0;

        // sliding window
        for (int i = 0; i < n; i++) {
            while (j < n && arr[j] <= 2 * arr[i]) {
                j++;
            }
            // all indices from i+1 to j-1 form perfect pairs with i
            count += (j - i - 1);
        }

        return count;
    }
}
