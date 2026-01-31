// class Solution {
//     public int minNonZeroProduct(int p) {
        
//     }
// }


class Solution {
    static final long MOD = 1_000_000_007;

    public int minNonZeroProduct(int p) {
        long max = (1L << p) - 1;
        long exp = (1L << (p - 1)) - 1;

        long pow = modPow(max - 1, exp);
        long ans = (pow * (max % MOD)) % MOD;

        return (int) ans;
    }

    private long modPow(long base, long exp) {
        long res = 1;
        base %= MOD;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }
}
