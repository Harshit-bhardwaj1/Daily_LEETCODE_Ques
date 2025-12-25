// class Solution {
//     public int countNicePairs(int[] nums) {
        
//     }
// }


class Solution {
    public int countNicePairs(int[] nums) {
        int MOD = 1000000007;
        HashMap<Integer, Long> map = new HashMap<>();
        long ans = 0;

        for (int num : nums) {
            int rev = reverse(num);
            int key = num - rev;

            long count = map.getOrDefault(key, 0L);
            ans = (ans + count) % MOD;

            map.put(key, count + 1);
        }

        return (int) ans;
    }

    private int reverse(int n) {
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + (n % 10);
            n /= 10;
        }
        return rev;
    }
}
