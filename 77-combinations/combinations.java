class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        Combine(ll,ans,n,k,1);
        return ans;
    }
    public void Combine(List<Integer> ll, List<List<Integer>> ans,int n, int k, int idx){
        if(ll.size()==k){
            ans.add(new ArrayList<>(ll));
            return;
        }
        for(int i=idx; i<=n; i++){
            ll.add(i);
            Combine(ll,ans,n,k,i+1);
            ll.remove(ll.size()-1);
        }
    }
}