class Solution {
    public int largestAltitude(int[] gain) {
        int[] diff = new int[gain.length+1];
        diff[0]=0;
        for(int i=0; i<gain.length; i++){
            diff[i+1]=diff[i]+gain[i];
        }
        Arrays.sort(diff);
        return diff[gain.length];
    }
}