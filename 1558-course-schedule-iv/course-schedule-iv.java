class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        HashMap<Integer , List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(i, new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++){
            int v1= prerequisites[i][0];
            int v2= prerequisites[i][1];
            map.get(v1).add(v2);
        }
        List<Boolean> ll = new ArrayList<>();
        for(int[] q : queries){
            ll.add(Path(map,q[0],q[1]));
        }
        return ll;
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