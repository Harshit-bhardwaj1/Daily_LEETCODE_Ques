// class Solution {
//     public int countPrimes(int n) {
//         if(n<=2){
//             return 0;
//         }
//         return PrimeSieve(n);
//     }
//     public static int PrimeSieve(int n){
//         int[] ans= new int[n];
//         ans[0]=ans[1]=1;
//         for(int i=2; i*i<=ans.length; i++){
//             if(ans[i]==0){ // i prime hai
//                 for(int j=2; i*j<ans.length; j++){
//                     ans[i*j]=1;
//                 }
//             }
//         }
//         int c=0;
//         for(int i=2; i<ans.length; i++){
//             if(ans[i]==0){
//                 c++;
//             }
//         }
//         return c;
//     }
// }


class Solution{
    public int countPrimes(int n){
        if(n<2) return 0;
        return PrimeSeive(n);
    }
    public int PrimeSeive(int n){
        boolean [] arr = new boolean[n];
        Arrays.fill(arr,true);
        arr[0]=arr[1]=false;
        for(int i=2; i*i<=n; i++){
            if(arr[i]){
                for(int j=2; i*j<n; j++){
                    arr[i*j]=false;
                }
            }
        }
        int count=0;
        for(boolean x:arr){
            if(x) count++;
        }
        return count;
    }
}