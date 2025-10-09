class Solution {
    public String simplifyPath(String path) {
        return Simplify(path);
    }
    public String Simplify(String path){
        Stack<String> st = new Stack<>();
        String[] parts = path.split("/");

        for(String s : parts){
            if(s.equals("") || s.equals(".")){
                continue;
            }
            else if(s.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else{
                st.push(s);
            }
        }

        StringBuilder str = new StringBuilder();

        for(String s :st){
            str.append("/").append(s);
        }

        return str.length()==0 ? "/" : str.toString();
    }
}