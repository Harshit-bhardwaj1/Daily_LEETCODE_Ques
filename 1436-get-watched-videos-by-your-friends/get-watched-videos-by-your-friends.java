class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> q = new LinkedList<>();
        int n = friends.length;
        HashSet<Integer> visited = new HashSet<>();

        q.add(id);
        visited.add(id);

        while(!q.isEmpty() && level>0){
            int size = q.size();

            for(int i=0; i<size; i++){
                int person = q.poll();

                for(int fr : friends[person]){
                    if(!visited.contains(fr)){
                        q.add(fr);
                        visited.add(fr);
                    }
                }
            }
            level--;
        }
        HashMap<String, Integer> count = new HashMap<>();

        while(!q.isEmpty()){
            int person = q.poll();
            for(String video : watchedVideos.get(person)){
                count.put(video, count.getOrDefault(video,0)+1);
            }
        }

        List<String> result = new ArrayList<>(count.keySet());
        Collections.sort(result, (a, b) -> {
            if (!count.get(a).equals(count.get(b))) {
                return count.get(a) - count.get(b);
            }
            return a.compareTo(b);
        });

        return result;
    }
}