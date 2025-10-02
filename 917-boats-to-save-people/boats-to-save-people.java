class Solution {
    public int numRescueBoats(int[] people, int limit) {
        return Rescue(people,limit);
    }
    public int Rescue(int[] arr, int limit) {
        Arrays.sort(arr);
        int i = 0;                 // lightest
        int j = arr.length - 1;    // heaviest
        int boats = 0;

        while (i <= j) {
            if (arr[i] + arr[j] <= limit) {
                i++;  // pair lightest with heaviest
            }
            j--;      // heaviest always goes
            boats++;
        }

        return boats;
    }
}