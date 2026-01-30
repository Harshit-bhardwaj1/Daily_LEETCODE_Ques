class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<tickets.length; i++){
            q.add(tickets[i]);
        }
        int time=0;
        while(true){
            int curr =q.poll();
            curr--;
            time++;


            if(k==0 && curr==0){
                return time;
            }
            if (curr > 0) {
                q.add(curr);
            }

            if(k>0) k--;
            else k=q.size()-1;
        }
    }
}