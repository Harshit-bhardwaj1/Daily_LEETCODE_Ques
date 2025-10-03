// class Solution {
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<List<Integer>> ans= new ArrayList<>();
//         List<Integer> ll = new ArrayList<>();
//         Combination(candidates, target, ll, 0,ans);
//         return ans;
//     }
//     public static void Combination(int[] coin, int amount,List<Integer> ll,int idx, List<List<Integer>> ans){
//         if(amount==0){
//             //System.out.println(ll);
//             ans.add(new ArrayList<>(ll));
//             return;
//         }
//         for(int i=idx; i<coin.length; i++){
//             if(amount>=coin[i]){
//                 ll.add(coin[i]);
//                 Combination(coin, amount-coin[i], ll,i,ans);
//                 ll.remove(ll.size()-1);
//             }
//         }
//     }
// }


class Solution{
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> ll = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Sum(ll,candidates,target,0,ans,0);
        return ll;
    }
    public void Sum(List<List<Integer>> ll, int[] candidates, int target, int amount,List<Integer> ans,int idx){
        if(amount==target){
            ll.add(new ArrayList<>(ans));
            return;
        }
        for(int i= idx; i<candidates.length; i++){
            if(amount<target){

                amount=amount+candidates[i];
                ans.add(candidates[i]);
                Sum(ll,candidates,target,amount,ans,i);
                amount=amount-candidates[i];
                ans.remove(ans.size()-1);
            }
        }
    }
}