// class Solution {
//     public int countPaths(int n, int[][] roads) {
        
//     }
// }


class Solution {
    static class Pair {
        int node;
        long dist;
        Pair(int n, long d) {
            node = n;
            dist = d;
        }
    }

    public int countPaths(int n, int[][] roads) {
        long MOD = 1000000007;

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] r : roads) {
            int u = r[0], v = r[1], w = r[2];
            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w));
        }

        long[] dist = new long[n];
        long[] ways = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int u = cur.node;

            if (cur.dist > dist[u]) continue;

            for (Pair nbr : graph.get(u)) {
                int v = nbr.node;
                long newDist = dist[u] + nbr.dist;

                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    ways[v] = ways[u];
                    pq.add(new Pair(v, newDist));
                } 
                else if (newDist == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }

        return (int)(ways[n - 1] % MOD);
    }
}
