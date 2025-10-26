class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        return Asteroid(asteroids);
    }
    public int[] Asteroid(int[] nums){
        Stack<Integer> st = new Stack<>();

        for(int a : nums){
            boolean destroyed = false;
            while(!st.isEmpty() && a<0 && st.peek()>0){
                if(Math.abs(a)>st.peek()){
                    st.pop();
                }
                else if(Math.abs(a)==st.peek()){
                    st.pop();
                    destroyed=true;
                    break;
                }
                else{
                    destroyed=true;
                    break;
                }
            }

            if(!destroyed){
                st.push(a);
            }
        }
        int[] result = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            result[i] = st.pop();
        }

        return result;
    }
}