class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                DFS(i, isConnected, visited);
                provinces++;
            }
        }
        return provinces;
    }
    public void DFS(int i, int[][] isConnected, boolean[] visited){
        Stack<Integer> st = new Stack<>();
        st.push(i);
        visited[i]=true;
        
        while(!st.isEmpty()){
            // 1. remove
            int rv = st.pop();

            // 2. ignore

            // 3. mark visited

            // 4. self work

            // 5. add nbrs
            for(int nbrs=0; nbrs<isConnected.length; nbrs++){
                if(isConnected[rv][nbrs]==1 && visited[nbrs]==false){
                    visited[nbrs] = true;
                    st.push(nbrs);
                }
            }
        }
    }
}