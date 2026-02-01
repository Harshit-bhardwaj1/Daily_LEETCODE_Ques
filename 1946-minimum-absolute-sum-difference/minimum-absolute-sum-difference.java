// class Solution {
//     public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        
//     }
// }



class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int MOD = 1_000_000_007;

        int[] sorted = nums1.clone();
        Arrays.sort(sorted);

        long totalDiff = 0;
        long maxGain = 0;

        for (int i = 0; i < n; i++) {
            long currDiff = Math.abs(nums1[i] - nums2[i]);
            totalDiff += currDiff;

            // Binary search for closest value to nums2[i]
            int idx = Arrays.binarySearch(sorted, nums2[i]);

            if (idx < 0) idx = -idx - 1;

            // Check right neighbor
            if (idx < n) {
                long newDiff = Math.abs(sorted[idx] - nums2[i]);
                maxGain = Math.max(maxGain, currDiff - newDiff);
            }

            // Check left neighbor
            if (idx > 0) {
                long newDiff = Math.abs(sorted[idx - 1] - nums2[i]);
                maxGain = Math.max(maxGain, currDiff - newDiff);
            }
        }

        return (int)((totalDiff - maxGain) % MOD);
    }
}
