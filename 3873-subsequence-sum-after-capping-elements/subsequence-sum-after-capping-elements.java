// class Solution {
//     public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        
//     }
// }


import java.util.*;

class Solution {
    public boolean[] subsequenceSumAfterCapping(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);

        boolean[] sum = new boolean[k + 1];
        boolean[] ans = new boolean[n];
        sum[0] = true;

        // sum[i] = can we form sum i using elements < x
        // ans[i] = can we form sum k using all elements capped at i+1

        int i = 0;
        for (int x = 1; x <= n; x++) {

            // classic knapsack using elements < x
            while (i < n && arr[i] < x) {
                int val = arr[i];
                for (int j = k; j >= val; j--) {
                    if (sum[j - val]) {
                        sum[j] = true;
                    }
                }
                i++;
            }

            int bigger = n - i; // elements >= x

            // try using j elements capped at x
            for (int cnt = 0; cnt <= bigger && cnt * x <= k; cnt++) {
                if (sum[k - cnt * x]) {
                    ans[x - 1] = true;
                    break;
                }
            }
        }
        return ans;
    }
}
