class Solution {
    public int subarraySum(int[] nums, int k) {
        return countSubarrays(nums,k);
    }
    // public int Print(int[] arr, int k){
    //     int count=0;
    //     for(int i=0; i<arr.length-1; i++){
    //         int lo=i+1;
    //         if(arr[i]==k){
    //             count++;
    //         }
    //         else if(check(arr,i,k,lo)==1){
    //             count++;
    //         }
    //     }
    //     return count;
    // }
    // public static int check(int[] arr, int i, int k, int lo){
    //     int sum=arr[i];
    //     while(lo<arr.length){
    //         sum+=arr[lo];
    //         if(sum==k){;
    //             return 1;
    //         }
    //         else if(sum<k){
    //             lo++;
    //         }
    //         else{
    //             return -1;
    //         }
    //     }
    //     return -1;
    // }

    public int countSubarrays(int[] arr, int k) {
        int count = 0;

        // Loop through each starting index
        for (int i = 0; i < arr.length; i++) {
            int sum = 0; // Initialize the sum for the current subarray

            // Calculate the sum of subarrays starting at index i
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                // Check if the sum equals k
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}