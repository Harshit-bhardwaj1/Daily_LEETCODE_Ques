class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=1; i<=edges.length+1; i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            int v1= edges[i][0];
            int v2= edges[i][1];
            map.get(v1).add(v2);
            map.get(v2).add(v1);
        }
        for(int i: map.keySet()){
            if(map.get(i).size()==edges.length){
                return i;
            }
        }
        return -1;
    }
}