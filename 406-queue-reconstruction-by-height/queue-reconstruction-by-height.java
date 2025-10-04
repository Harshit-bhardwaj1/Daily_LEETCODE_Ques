class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1]; // smaller k first
            }
            return b[0] - a[0]; // taller first
        });

        List<int[]> list = new ArrayList<>();
        for(int[] curr : people){
            list.add(curr[1],curr);
        }

        return list.toArray(new int[people.length][2]);
    }
}