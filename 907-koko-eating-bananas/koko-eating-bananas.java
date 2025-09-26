class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo=1;
        int hi=1000000000;
        // for (int pile : piles) {
        //     hi = Math.max(hi, pile); // max pile = upper bound
        // }

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(isPossible(piles,h,mid)){
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return lo;
    }
    public boolean isPossible(int[] piles, int h, int k){
        long hours=0;
        for(int x: piles){
            hours+= (x+k-1)/k;
            if(hours>h) return false;
        }
        return (hours<=h);
    }
}