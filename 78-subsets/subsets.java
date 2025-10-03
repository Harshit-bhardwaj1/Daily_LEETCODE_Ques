class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return Subsets(nums);
    }
    public List<List<Integer>> Subsets(int[] arr){
        List<List<Integer>> ll = new ArrayList<>();

        backtrack(ll,new ArrayList<>(), 0, arr);
        return ll;
    }
    public void backtrack(List<List<Integer>> ll , List<Integer> current, int idx, int[] arr){
        ll.add(new ArrayList<>(current));

        for(int i= idx; i<arr.length; i++){
            current.add(arr[i]);
            backtrack(ll,current, i+1, arr);
            current.remove(current.size()-1);
        }
    }
}