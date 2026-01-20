class Solution {
    public boolean backspaceCompare(String s, String t) {
        // return String(s,t);
        return Check(s).equals(Check(t));
    }
    public boolean String(String s , String t){
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!='#'){
                st.push(s.charAt(i));
            }
            else{
                if(!st.isEmpty()) st.pop();
            }
        }

        String s1 = st.toString();
        Stack<Character> st2 = new Stack<>();
        for(int i=0; i<t.length(); i++){
            if(t.charAt(i)!='#'){
                st2.push(t.charAt(i));
            }
            else{
                if(!st2.isEmpty()) st2.pop();
            }
        }

        String s2 = st2.toString();

        if(s1.equals(s2)) return true;
        return false;
    }

    public String Check(String s){
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!='#'){
                st.push(s.charAt(i));
            }
            else{
                if(!st.isEmpty()) st.pop();
            }
        }
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()){
            str.append(st.pop());
        }
        return str.reverse().toString();
    }
}