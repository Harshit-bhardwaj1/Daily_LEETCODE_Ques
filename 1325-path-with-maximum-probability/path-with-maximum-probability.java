class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        // adjacency list: node -> (neighbor, probability)
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];

            graph.get(u).add(new Pair(v, p));
            graph.get(v).add(new Pair(u, p));
        }

        double[] prob = new double[n];
        prob[start] = 1.0;

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));

        pq.add(new Pair(start, 1.0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();

            int node = cur.node;
            double currProb = cur.prob;

            if (node == end) return currProb;

            for (Pair next : graph.get(node)) {
                double newProb = currProb * next.prob;

                if (newProb > prob[next.node]) {
                    prob[next.node] = newProb;
                    pq.add(new Pair(next.node, newProb));
                }
            }
        }

        return 0.0;
    }
}

class Pair {
    int node;
    double prob;

    Pair(int n, double p) {
        node = n;
        prob = p;
    }
}
