// class Solution {
//     public int minimumJumps(int[] forbidden, int a, int b, int x) {
        
//     }
// }


import java.util.*;

class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> forbid = new HashSet<>();
        int maxF = 0;
        for (int f : forbidden) {
            forbid.add(f);
            maxF = Math.max(maxF, f);
        }

        int limit = Math.max(maxF + a, x) + b;

        boolean[][] visited = new boolean[limit + 1][2];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0}); // {position, lastWasBackward}
        visited[0][0] = true;

        int jumps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                int pos = cur[0];
                int back = cur[1];

                if (pos == x) return jumps;

                // forward jump
                int fwd = pos + a;
                if (fwd <= limit && !forbid.contains(fwd) && !visited[fwd][0]) {
                    visited[fwd][0] = true;
                    q.add(new int[]{fwd, 0});
                }

                // backward jump (only if last was not backward)
                int bwd = pos - b;
                if (back == 0 && bwd >= 0 && !forbid.contains(bwd) && !visited[bwd][1]) {
                    visited[bwd][1] = true;
                    q.add(new int[]{bwd, 1});
                }
            }
            jumps++;
        }
        return -1;
    }
}
