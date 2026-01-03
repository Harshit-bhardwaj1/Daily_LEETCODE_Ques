class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        for(int i=0; i<numCourses; i++){
            map.put(i, new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++){
            int v2 = prerequisites[i][0];
            int v1 = prerequisites[i][1];
            map.get(v1).add(v2);
        }
        return Topo_Sort();
    }
    public int[] indegree(){
        int[] arr = new int[map.size()];
        for(int v1 : map.keySet()){
            for(int v2 : map.get(v1)){
                arr[v2]++;
            }
        }
        return arr;
    }
    public boolean  Topo_Sort(){
        Queue<Integer> q = new LinkedList<>();
        int[] in = indegree();
        int count =0;
        for(int i=0; i<in.length; i++){
            if(in[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int rv = q.poll();
            count++;
            for(int nbrs : map.get(rv)){
                in[nbrs]--;
                if(in[nbrs]==0){
                    q.add(nbrs);
                }
            }
        }
        return count== map.size();
    }
}