// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         return FindKthLargest(nums,k);
//     }
//     public int FindKthLargest(int[] arr, int k){
//         Arrays.sort(arr);
//         return arr[arr.length-k];
//     }
// }

// class Solution {
//     public int findKthLargest(int [] nums, int k){

//     }

//     public static int Kth_Largest_Element(int [] arr, int k){
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
//         for(int i=0; i<k; i++){
//             pq.add(arr[i]);
//         }
//         for(int i=k; i<arr.length; i++){
//             if()
//         }
//     }
// }


class Solution {
    public int findKthLargest(int[] nums, int k) {
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for(int i = 0; i<k; i++) {
				pq.add(nums[i]);
			}
			for(int i = k; i<nums.length; i++) {
				if(nums[i]>pq.peek()) {
					pq.poll();
					pq.add(nums[i]);
				}
			}
			return pq.peek();
		}
}