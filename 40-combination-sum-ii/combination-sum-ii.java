class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        Arrays.sort(candidates);
        Combination(ans,ll,target,candidates,0);
        return ans;
    }
    public void Combination(List<List<Integer>> ans, List<Integer> ll ,int amount, int[] candidates, int idx){
        if(amount==0){
            ans.add(new ArrayList<>(ll));
            return;
        }
        for(int i=idx; i<candidates.length; i++){
            if(i>idx && candidates[i]==candidates[i-1]) continue;
            if(candidates[i]> amount) break;
            
            ll.add(candidates[i]);
            Combination(ans,ll, amount-candidates[i],candidates,i+1);
            ll.remove(ll.size()-1);
        }
    }
}