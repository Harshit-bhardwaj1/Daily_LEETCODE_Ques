import java.util.*;

class Solution {
    int n;
    List<List<Integer>> adj;
    int[] bobTime;
    int maxProfit = Integer.MIN_VALUE;
    int[] amount;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        this.n = amount.length;
        this.adj = new ArrayList<>();
        this.bobTime = new int[n];
        this.amount = amount;
        Arrays.fill(bobTime, Integer.MAX_VALUE);

        // Build adjacency list
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        // Step 1: calculate Bob's arrival time for each node
        calcBobTime(bob, -1, 0);

        // Step 2: simulate Alice’s traversal from node 0
        dfsAlice(0, -1, 0, 0);

        return maxProfit;
    }

    private boolean calcBobTime(int node, int parent, int time) {
        if (node == 0) {  // reached Alice's root
            bobTime[node] = time;
            return true;
        }
        for (int nei : adj.get(node)) {
            if (nei == parent) continue;
            if (calcBobTime(nei, node, time + 1)) {
                bobTime[node] = time;
                return true;
            }
        }
        return false;
    }

    private void dfsAlice(int node, int parent, int time, int profit) {
        // Compare arrival times
        if (time < bobTime[node]) {
            profit += amount[node];
        } else if (time == bobTime[node]) {
            profit += amount[node] / 2;
        }
        // else Bob got here earlier → Alice gets 0

        boolean isLeaf = (adj.get(node).size() == 1 && parent != -1) || (n == 1);
        if (isLeaf) {
            maxProfit = Math.max(maxProfit, profit);
            return;
        }

        for (int nei : adj.get(node)) {
            if (nei != parent) {
                dfsAlice(nei, node, time + 1, profit);
            }
        }
    }
}
