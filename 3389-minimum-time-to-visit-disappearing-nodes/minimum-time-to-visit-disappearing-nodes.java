// class Solution {
//     public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        
//     }
// }


class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {

        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

        if (0 < disappear[0]) {
            dist[0] = 0;
            pq.add(new int[]{0, 0});
        }

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int time = cur[0];
            int node = cur[1];

            if (time > dist[node]) continue;

            for (int[] nei : graph[node]) {
                int next = nei[0];
                int newTime = time + nei[1];

                if (newTime < disappear[next] && newTime < dist[next]) {
                    dist[next] = newTime;
                    pq.add(new int[]{newTime, next});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }

        return dist;
    }
}
