// class Solution {
//     public int minimumBuckets(String hamsters) {
        
//     }
// }


class Solution {
    public int minimumBuckets(String street) {
        int n = street.length();
        boolean[] bucket = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (street.charAt(i) == 'H') {

                // already served by left bucket
                if (i - 1 >= 0 && bucket[i - 1]) {
                    continue;
                }

                // place bucket on right if possible
                if (i + 1 < n && street.charAt(i + 1) == '.') {
                    bucket[i + 1] = true;
                    count++;
                }
                // else place on left
                else if (i - 1 >= 0 && street.charAt(i - 1) == '.') {
                    bucket[i - 1] = true;
                    count++;
                }
                // impossible
                else {
                    return -1;
                }
            }
        }
        return count;
    }
}
