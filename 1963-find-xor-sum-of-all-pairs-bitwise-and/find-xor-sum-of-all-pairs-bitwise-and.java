class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        return Bitwise_XOR(arr1) & Bitwise_XOR(arr2);
    }
    public static int Bitwise_XOR(int[] arr){
        int xor=0;
        for(int v : arr){
            xor ^=v;
        }
        return xor;
    }
}