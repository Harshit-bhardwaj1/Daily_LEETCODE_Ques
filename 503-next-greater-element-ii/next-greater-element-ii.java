// class Solution {
//     public int[] nextGreaterElements(int[] nums) {
        
//     }
// }


class Solution {
    public int[] nextGreaterElements(int[] nums) {
        return Find(nums);
        // int n = nums.length;
        // int[] res = new int[n];
        // Stack<Integer> st = new Stack<>();

        // for (int i = 2 * n - 1; i >= 0; i--) {
        //     int idx = i % n;

        //     while (!st.isEmpty() && st.peek() <= nums[idx]) {
        //         st.pop();
        //     }

        //     if (st.isEmpty()) {
        //         res[idx] = -1;
        //     } else {
        //         res[idx] = st.peek();
        //     }

        //     st.push(nums[idx]);
        // }

        // return res;
    }
    public int[] Find(int [] nums){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[nums.length];
        Arrays.fill(ans,-1);
        int n = nums.length;
        for(int i=0; i<2*n; i++){
            int num = nums[i%n];

            while(!st.isEmpty() && num> nums[st.peek()]){
                ans[st.pop()]=num;
            }
            if(i<n) st.push(i);
        }
        return ans;
    }
}
