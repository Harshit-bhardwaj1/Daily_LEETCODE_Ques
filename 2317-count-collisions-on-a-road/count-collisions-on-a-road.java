class Solution {
    public int countCollisions(String directions) {
        return Collisions(directions);
    }
    public int Collisions(String directions) {
        int left = 0;
        int right = directions.length() - 1;

        // skip all leading L
        while (left <= right && directions.charAt(left) == 'L') {
            left++;
        }

        // skip all trailing R
        while (left <= right && directions.charAt(right) == 'R') {
            right--;
        }

        int collisions = 0;

        // count remaining L and R
        for (int i = left; i <= right; i++) {
            if (directions.charAt(i) != 'S') {
                collisions++;
            }
        }

        return collisions;
    }
}