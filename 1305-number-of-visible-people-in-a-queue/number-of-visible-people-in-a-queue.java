class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int[] ans = new int[heights.length];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<heights.length; i++){

            while(!st.isEmpty() && heights[st.peek()]<=heights[i]){
                ans[st.peek()]++;
                st.pop();
            }

            if(!st.isEmpty()){
                ans[st.peek()]++;
            }
            st.push(i);
        }
        return ans;
    }
}