// class Solution {
//     public int[] countRectangles(int[][] rectangles, int[][] points) {
        
//     }
// }


import java.util.*;

class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {

        // heights go from 1 to 100
        List<Integer>[] map = new ArrayList[101];

        for (int i = 1; i <= 100; i++) {
            map[i] = new ArrayList<>();
        }

        // group rectangle lengths by height
        for (int[] r : rectangles) {
            map[r[1]].add(r[0]);
        }

        // sort lengths for each height
        for (int i = 1; i <= 100; i++) {
            Collections.sort(map[i]);
        }

        int[] ans = new int[points.length];

        // process each point
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];

            int count = 0;

            for (int h = y; h <= 100; h++) {
                List<Integer> list = map[h];
                if (list.size() == 0) continue;

                // find first index with value >= x
                int idx = lowerBound(list, x);
                count += list.size() - idx;
            }

            ans[i] = count;
        }

        return ans;
    }

    // binary search: first index >= target
    private int lowerBound(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
