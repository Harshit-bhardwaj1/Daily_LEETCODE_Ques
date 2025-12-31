class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer , List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(i, new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            int v1= edges[i][0];
            int v2= edges[i][1];
            map.get(v1).add(v2);
            map.get(v2).add(v1);
        }
        return Path(map, source, destination);
    }
    public boolean Path(HashMap<Integer, List<Integer>> map, int src, int des){
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.add(src);
        while(!q.isEmpty()){
            int rv = q.poll();
            if(visited.contains(rv)){
                continue;
            }
            visited.add(rv);
            if(rv==des){
                return true;
            }
            for(int nbrs : map.get(rv)){
                if(!visited.contains(nbrs)){
                    q.add(nbrs);
                }
            }
        }
        return false;
    }
}