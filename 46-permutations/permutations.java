class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> ll= new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Permutations(nums, ll, ans,used);
        return ans;
    }
    public void Permutations(int[] arr, List<Integer> ll, List<List<Integer>>ans , boolean[] used){
        if(ll.size()==arr.length){
            ans.add(new ArrayList<>(ll));
            return;
        }
        
        for(int i=0; i<arr.length; i++){
            if(!used[i]){
                used[i]=true;
                ll.add(arr[i]);
                Permutations(arr,ll,ans,used);
                ll.remove(ll.size()-1);
                used[i]=false;
            }
        }

    }
}