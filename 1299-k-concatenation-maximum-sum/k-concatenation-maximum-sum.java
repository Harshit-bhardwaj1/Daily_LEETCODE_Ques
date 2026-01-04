// class Solution {
//     public int kConcatenationMaxSum(int[] arr, int k) {
        
//     }
// }


class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        long MOD = 1000000007;

        long totalSum = 0;
        for (int x : arr) totalSum += x;

        long kadaneOnce = kadane(arr);
        if (k == 1) return (int)(kadaneOnce % MOD);

        long kadaneTwice = kadaneTwice(arr);

        if (totalSum <= 0) {
            return (int)(kadaneTwice % MOD);
        }

        long maxPrefix = prefixMax(arr);
        long maxSuffix = suffixMax(arr);

        long result = maxPrefix + maxSuffix + (k - 2) * totalSum;
        return (int)(result % MOD);
    }

    private long kadane(int[] arr) {
        long max = 0, curr = 0;
        for (int x : arr) {
            curr = Math.max(x, curr + x);
            max = Math.max(max, curr);
        }
        return max;
    }

    private long kadaneTwice(int[] arr) {
        long max = 0, curr = 0;
        for (int t = 0; t < 2; t++) {
            for (int x : arr) {
                curr = Math.max(x, curr + x);
                max = Math.max(max, curr);
            }
        }
        return max;
    }

    private long prefixMax(int[] arr) {
        long sum = 0, max = 0;
        for (int x : arr) {
            sum += x;
            max = Math.max(max, sum);
        }
        return max;
    }

    private long suffixMax(int[] arr) {
        long sum = 0, max = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            sum += arr[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}
