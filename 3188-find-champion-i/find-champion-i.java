class Solution {
    public int findChampion(int[][] grid) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<grid.length; i++){
            map.put(i, new ArrayList<>());
        }
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    map.get(i).add(j);
                }
            }
        }
        for(int nbrs : map.keySet()){
            if(map.get(nbrs).size()==map.size()-1){
                return nbrs;
            }
        }
        return -1;
    }
}