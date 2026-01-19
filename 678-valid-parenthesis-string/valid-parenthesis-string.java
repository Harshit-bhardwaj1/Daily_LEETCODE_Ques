class Solution {
    public boolean checkValidString(String s) {
        return String(s);
    }
    public boolean String(String s){
        int a=0;
        int b=0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='('){
                a++;
                b++;
            }
            else if(ch==')'){
                a--;
                b--;
            }
            else{
                a--;
                b++;
            }
            if (b < 0) return false;   // too many ')'
            if (a < 0) a = 0;     
        }
        
        return a==0;
    }
}