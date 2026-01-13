class Solution {
    public int largestPrime(int n) {
        if(n==2) return 2;
        return Prime(n);
    }
    public int Prime(int n){
        int sum=0;
        int prime=0;
        boolean [] arr = new boolean[n+1];
        Arrays.fill(arr,true);
        arr[0]=arr[1]=false;
        for(int i=2; i*i<=n; i++){
            if(arr[i]){
                for(int j=i*i; j<=n; j+=i){
                    arr[j]=false;
                }
            }
        }
        for(int i=2; i<arr.length; i++){
            if(arr[i]){
                if((sum+i)<=n){
                    sum+=i;
                    if(arr[sum]){
                        prime=sum;
                    }
                }
            }
        }
        return prime;
    }
}