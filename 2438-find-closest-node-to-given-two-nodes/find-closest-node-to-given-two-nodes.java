// class Solution {
//     public int closestMeetingNode(int[] edges, int node1, int node2) {
        
//     }
// }


class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);
        
        // Distance from node1
        int d = 0;
        int curr = node1;
        while (curr != -1 && dist1[curr] == -1) {
            dist1[curr] = d++;
            curr = edges[curr];
        }
        
        // Distance from node2
        d = 0;
        curr = node2;
        while (curr != -1 && dist2[curr] == -1) {
            dist2[curr] = d++;
            curr = edges[curr];
        }
        
        int ans = -1;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < min) {
                    min = maxDist;
                    ans = i;
                }
            }
        }
        
        return ans;
    }
}
