class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n;i++){
            q.add(i);
        }
        int temp=k;
        while(q.size()!=1){
            int rv= q.poll();
            temp--;
            if(temp!=0){
                q.add(rv);
            }
            else{
                temp=k;
            }
        }
        return q.poll();
    }
}