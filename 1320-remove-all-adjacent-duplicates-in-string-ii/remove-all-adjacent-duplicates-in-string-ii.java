class Solution {
    public String removeDuplicates(String s, int k) {
        return Remove(s,k);
    }
    public String Remove(String s, int k){
        Stack<int[]> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            if(!st.isEmpty() && st.peek()[0]==c){
                st.peek()[1]++;
            }
            else{
                st.push(new int[]{c,1});
            }

            if(st.peek()[1]==k){
                st.pop();
            }
        }
        for (int[] pair : st) {
            for (int i = 0; i < pair[1]; i++) {
                sb.append((char) pair[0]);
            }
        }
        return sb.toString();
    }
}