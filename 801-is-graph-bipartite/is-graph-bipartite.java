class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<BipartitePair> q = new LinkedList<>();
        HashMap<Integer, Integer> visited = new HashMap<>();
        for(int key=0; key<graph.length; key++){
            if(visited.containsKey(key)){
                continue;
            }
            q.add(new BipartitePair(key,0));

            while(!q.isEmpty()){
                BipartitePair rv = q.poll();

                if(visited.containsKey(rv.vtx)){
                    if(visited.get(rv.vtx) != rv.dis){
                        return false;
                    }
                    continue;
                }
                visited.put(rv.vtx, rv.dis);

                for(int nbrs : graph[rv.vtx]){
                    if(!visited.containsKey(nbrs)){
                        q.add(new BipartitePair(nbrs, rv.dis+1));
                    }
                }
            }
        }
        return true;
    }
    class BipartitePair{
        int vtx;
        int dis;

        public BipartitePair(int vtx, int dis){
            this.vtx= vtx;
            this.dis=dis;
        }
    }
}