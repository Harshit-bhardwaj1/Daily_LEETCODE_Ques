class Solution {
    public int minimumBuckets(String hamsters) {
        return Buckets(hamsters);
    }

    public int Buckets(String str) {
        int n = str.length();
        boolean[] arr = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'H') {

                // already served by left bucket
                if (i - 1 >= 0 && arr[i - 1]) {
                    continue;
                }

                // place bucket on right
                if (i + 1 < n && str.charAt(i + 1) == '.') {
                    if (!arr[i + 1]) {
                        arr[i + 1] = true;
                        count++;
                    }
                }
                // place bucket on left
                else if (i - 1 >= 0 && str.charAt(i - 1) == '.') {
                    if (!arr[i - 1]) {
                        arr[i - 1] = true;
                        count++;
                    }
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
