// class Solution {
//     public List<String> generateParenthesis(int n) {
//         List<String> ll = new ArrayList<>();
//         Parenthesis(n, 0, 0, "",ll);
//         return ll;
//     }
//     public static void Parenthesis(int n, int closed, int open, String ans, List<String> ll){
//         if(open==n && closed==n){
//             //System.out.println(ans);

//             ll.add(ans);
//             return;
//         }
//         if(open>n || closed > open){
//             return;
//         }

//         Parenthesis(n, closed, open+1, ans+"(",ll);
//         Parenthesis(n, closed+1, open, ans+")",ll);
//     }
// }


class Solution{
    public List<String> generateParenthesis(int n){
        List<String> ll = new ArrayList<>();
        Generate(ll,0,0,"",n);
        return ll;
    }
    public void Generate(List<String> ll , int closed, int open, String ans,int n){
        if(closed==n && open== n){
            ll.add(ans);
            return;
        }
        if(open>n || closed >open){
            return;
        }

        Generate(ll,closed,open+1,ans+"(",n);
        Generate(ll,closed+1,open,ans+")",n);
    }
}