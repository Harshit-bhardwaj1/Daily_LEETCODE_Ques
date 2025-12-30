class Solution {
    public int findJudge(int n, int[][] trust) {
        return Judge(n,trust);
    }
    public int Judge(int n, int[][] arr){
        if(n==1 && arr.length==0) return 1;

        int[] trustcount = new int[n+1];
        int[] trustsomeone = new int[n+1];

        for(int i=0; i<arr.length; i++){
            int a = arr[i][0];
            int b = arr[i][1];

            trustcount[b]++;
            trustsomeone[a]++;
        }

        for(int i=1; i<=n; i++){
            if(trustcount[i]==n-1 && trustsomeone[i]==0){
                return i;
            }
        }
        return -1;
    }
}