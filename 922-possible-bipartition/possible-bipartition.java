class Solution {

    public boolean possibleBipartition(int n, int[][] dislikes) {

        // build graph
        List<Integer>[] graph = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] d : dislikes){
            graph[d[0]].add(d[1]);
            graph[d[1]].add(d[0]);
        }

        Queue<GroupPair> q = new LinkedList<>();
        HashMap<Integer, Integer> visited = new HashMap<>();

        // check all components
        for(int person = 1; person <= n; person++){

            if(visited.containsKey(person)){
                continue;
            }

            q.add(new GroupPair(person, 0));

            while(!q.isEmpty()){
                GroupPair rv = q.poll();

                if(visited.containsKey(rv.person)){
                    if(visited.get(rv.person) != rv.group){
                        return false;
                    }
                    continue;
                }

                visited.put(rv.person, rv.group);

                for(int enemy : graph[rv.person]){
                    if(!visited.containsKey(enemy)){
                        q.add(new GroupPair(enemy, 1 - rv.group));
                    }
                }
            }
        }

        return true;
    }

    class GroupPair{
        int person;
        int group;

        public GroupPair(int person, int group){
            this.person = person;
            this.group = group;
        }
    }
}
