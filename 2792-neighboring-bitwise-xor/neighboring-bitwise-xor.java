class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int xor=0;
        for(int v: derived){
            xor^=v;
        }
        if(xor==0) return true;
        return false;
    }
}